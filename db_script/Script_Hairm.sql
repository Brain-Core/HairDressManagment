
create database db_Hairm

go
use db_Hairm

create table t_user
(
	u_name varchar(100) not null,
	u_phone varchar(13),
	u_pass varchar(25) not null,
	u_accreditation varchar(50) not null,
	constraint pf_user primary key(u_name)
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
	client  varchar(100),
	u_name varchar(100),
	constraint pk_souscription primary key()
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
	id_souscription int not null
	date_paiement date,
	montant float,
	u_name varchar(100),
	constraint pl_paiement primary key(id)
)

create table t_depense
(
	id int not null,
	intitule text not null,
	executant varchar(255), not null,
	montant float, -- doit se soustraire a la caisse
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

---------------------------- CONTRAINTES---------------------

alter table t_depense add constraint fk_user_depense foreign key (u_name) references t_user(u_name)
alter table t_paiement add constraint fk_user_paiement foreign key (u_name) references t_user(u_name)
alter table t_souscription add constraint fk_user_souscription foreign key (u_name) references t_user(u_name)

alter table t_ligne_souscription add constraint fk_souscription_paiement foreign key (id_souscription) references t_souscription(id)
alter table t_depense add constraint fk_user_depense foreign key (u_name) references t_user(u_name)

