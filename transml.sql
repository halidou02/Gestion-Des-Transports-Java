CREATE TABLE car (
  idcar int(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  marque varchar(15) ,
  matricule varchar(15) ,
  nb_place int(11) ,
  statut varchar(15)
);
CREATE TABLE chauffeur (
  idchauf int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nom varchar(30) ,
  adresse varchar(30) ,
  cni varchar(12) ,
  car int (8) ,
  salaire int(7) ,
  date_enreg date ,
  statut varchar(15) ,
  FOREIGN KEY (car) REFERENCES car(idcar)
);
CREATE TABLE client (
  idclt int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nom varchar(20) ,
  prenom varchar(20) ,
  telephone varchar(20) ,
  adresse varchar(30) ,
  genre varchar(5) ,
  cni varchar(12) ,
  dateenrg date 
) ;
CREATE TABLE voyage (
  idvoy int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  source varchar(11) ,
  destination varchar(11) ,
  idcar int(11) ,
  marque_car varchar(15),
  nb_place int(11) ,
  idchauf int(11),
  nom_ch varchar(30) ,
  depart varchar(20) ,
  arrive varchar(20),
  FOREIGN KEY (idcar) REFERENCES car(idcar),
  FOREIGN KEY (idchauf) REFERENCES chauffeur(idchauf)
) ;
CREATE TABLE ticket (
  idtkt int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idvoy int(11) ,
  idclt int(11) ,
  nom varchar(30) ,
  cni varchar(12) ,
  date date ,
  source varchar(30) ,
  destination varchar(30) ,
  prix int (6),
  FOREIGN KEY (idvoy) REFERENCES voyage(idvoy),
  FOREIGN KEY (idclt) REFERENCES client(idclt)
) ;
CREATE TABLE utilisateur (
  idu int(8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  login varchar(45) ,
  nom varchar(45) ,
  password varchar(45) ,
  profil varchar(45) 
) ;
