
create database db_Hairm

go
use db_Hairm

create table t_user
(
	u_name varchar(100) not null,
	u_pass varchar(25) not null,
	u_accreditation varchar(50) not null,
	constraint pf_user primary key(u_name)
)

create table t_journalier
(
	id int not null,
	nom varchar(50) not null,
	postnom varchar(50) not null,
	prenom varchar(50) not null,
	lieu_naissance text,
	date_naissance date,
	etat_civil varchar(100),
	piece_identite char(255),
	numero_piece_identite varchar(50),
	constraint pk_jpurnalier primary key(id)
)

create table t_type
(
	id int not null,
	typeItem varchar(100) not null,
	constraint pk_type primary key(id)
)

create table t_coiffure
(
	id int not null,
	modele varchar(255) not null,
	typeItem text,
	montant float not null,
	constraint pk_coiffure primary key(id)
)

create table t_souscription
(
	id int not null,
	date_souscription date,
	client varchar(100),
	u_name varchar(100),
	constraint pk_souscription primary key(id)
)

create table t_ligne_souscription
(
	id_souscription int not null,
	id_coiffure int not null,
	qte float,
	constraint pk_ primary key(id_souscription, id_coiffure)
)

create table t_paiement
(
	id int not null,
	id_souscription int not null,
	date_paiement date,
	montant float,
	u_name varchar(100),
	cash float,
	constraint pl_paiement primary key(id)
)

create table t_depense
(
	id int not null,
	intitule text not null,
	executant varchar(255) not null,
	montant float,-- doit se soustraire a la caisse
	date_depense date,
	u_name varchar(100) not null,
	constraint pk_depense primary key(id)
)

create table t_caisse
(
	id int not null,
	montant float,
	date_update date,
	contraint pk_caisse primary key(id)
)

create table t_abone
(
	id int not null,
	nom varchar(50) not null,
	postnom varchar(50) not null,
	prenom varchar(50) not null,
	telephone varchar(15) not null,
	adresse varchar(100) not null,
	contraint pk_abone primary key(id)

)


------------Autres contraintes---------------

alter table t_type add constraint Unique_type unique(typeItem)
alter table t_coiffure add constraint Unique_coiffure unique(typeItem)
alter table t_journalier add constraint Unique_Name unique(nom, postnom, prenom,numero_piece_identite)

alter table t_souscription add constraint fk_user_souscription foreign key (u_name) references t_user(id) on delete no action
alter table t_paiement add constraint fk_user_paiement foreign key (u_name) references t_user(u_name) on delete no action
alter table t_depense add constraint fk_user_depense foreign key (u_name) references t_user(u_name) on delete no action

----------- Procedures Stockées--------------

go
create procedure sp_update_user
(
	@uname varchar(100),
	@upass varchar(25),
	@uaccreditation varchar(50)
)
as
begin
	if not exists(select * from t_user where u_name = @u_name)
		insert into t_user values(@u_name, @u_pass, @u_accreditation)
	else
		update t_user set u_pass = @u_pass, u_accreditation = @u_accreditation where u_name = @u_name
end


GO
create procedure sp_update_type
(
	@_id int ,
	@typeItem varchar(100)


)
as
begin
	if not exists(select * from t_type where id = @id)
		insert into t_type values(@id, @typeItem)
	else
		update t_type set typeItem = @typeItem where id = @id
end

GO
create procedure sp_update_coiffure
(
	@id int ,
	@modele varchar(255),
	@typeItem text,
	@montant float


)
as
begin
	if not exists(select * from t_coiffure where id = @id)
		insert into t_coiffure values(@id,@modele, @typeItem,@montant)
	else
		update t_type set modele=modele,typeItem = @typeItem,montant=@montant where id = @id
end

GO
create procedure sp_update_souscription
(
	@id int ,
	@date_souscription date,
	@client varchar(100),
	@u_name varchar(100)


)
as
begin
	declare @_u_name varchar(100) = (select u_name from t_user where u_name = @u_name)
	if not exists(select * from t_salaire where id = @id)
		insert into t_souscription values(@id, @date_souscription, @client,@u_name)
	else
		update t_souscription set date_souscription = @date_souscription, client=@client, u_name=@_u_name where id = @id
end

GO
create procedure sp_update_ligne_souscription
(
	@souscription int ,
	@coiffure int ,
	@qte float


)
as
begin
	declare @id_souscription  int = (select id from t_souscription where id = souscription)
	declare @id_coiffure int = (select id from t_coiffure where id = coiffure)
	if not exists(select * from t_ligne_souscription where id = @id)
		insert into t_ligne_souscription values(@souscription, @coiffure, @qte)
	else
		update t_souscription set id_souscription = @id_souscription, id_coiffure=@id_coiffure, qte=@qte where concat(id_souscription,' ',id_coiffure) = concat(@id_souscription,' ',@id_coiffure)
end

GO
CREATE PROCEDURE SP_UPDATE_depense
(
	@id int ,
	@intitule text ,
	@executant varchar(255),
	@montant float,-- doit se soustraire a la caisse
	@date_depense date,
	@u_name varchar(100) not null
)
AS
BEGIN	
	declare @_u_name varchar(100) = (select u_name from t_user where u_name = @u_name)
	INSERT INTO t_depense VALUES(@id, @intitule,@executant, @montant, @date_depense, _u_name)
	UPDATE t_caisse SET montant  = montant - @montant WHERE id = 1
END


GO
CREATE PROCEDURE SP_UPDATE_tPaiement
(
	@id int,
	@souscription int,
	@date_paiement date,
	@montant float,
	@u_name varchar(100)
)
AS
BEGIN
	DECLARE @id_souscription INT =(SELECT id FROM t_souscription WHERE id =@souscription)
	declare @_u_name varchar(100) = (select u_name from t_user where u_name = @u_name)
	INSERT INTO tPaiement VALUES(@id, @id_souscription, @date_paiement,@montant, @_u_name  )
	UPDATE t_caisse SET montant = montant + @montant WHERE id = 1
END

GO
create procedure sp_update_abone
(
	@id int ,
	@nom varchar(50) ,
	@postnom varchar(50),
	@prenom varchar(50) ,
	@telephone varchar(15) ,
	@adresse varchar(100) 

)
as
begin
	if not exists(select * from t_coiffure where id = @id)
		insert into t_abone values(@id,@nom,@postnom ,@prenom,@telephone,@adresse)
	else
		update t_abone set nom=@nom, postnom= @postnom ,prenom=@prenom,telephone=@telephone,adresse=@adresse where id = @id
end