
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
	client  varchar(100),
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
	constraint pl_paiement primary key(id)
)

create table t_depense
(
	id int not null,
	intitule text not null,
	executant varchar(255) not null,
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
