
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

create table t_paiement
(
	
	constraint pk_paiement primary key()

)

create table t_detail_paiement
(
	constraint pk_paiement primary key(id)
)