CREATE DATABASE tp5;

CREATE TABLE Company(
    idCompany serial PRIMARY KEY,
    nom varchar(30)
);

CREATE TABLE TypeAvion(
    idType serial PRIMARY KEY,
    nomtype varchar(30) 
);

CREATE TABLE Modele(
    idModele serial PRIMARY KEY,
    idCompany INTEGER REFERENCES Company(idCompany),
    idType INTEGER REFERENCES TypeAvion,
    nomModele varchar(30)
);

CREATE TABLE Avion(
    idAvion serial PRIMARY KEY,
    capacite double precision NOT NULL,
    longueur double precision NOT NULL,
    hauteur double precision NOT NULL,
    vmax double precision NOT NULL,
    carburant double precision NOT NULL,
    idmodele INTEGER NOT NULL REFERENCES Modele(idModele),
    matricule varchar(20) NOT NULL,
    img text
);

CREATE TABLE Utilisateur(
    idUser serial PRIMARY KEY,
    login varchar(20) NOT NULL,
    mdp varchar(20) NOT NULL
);


CREATE TABLE Kilometrage(
    idkilometrage serial PRIMARY KEY,
    idAvion INTEGER NOT NULL references Avion(idAvion),
    dateModif date NOT NULL DEFAULT now(),
    debutKm double precision NOT NULL,
    finKm double precision NOT NULL
);

CREATE TABLE Societe_assurance(
    idSociete serial PRIMARY KEY,
    nomSociete varchar(30) NOT NULL
);

CREATE TABLE Payement_assurance(
    idpayement serial primary key,
    idSociete INTEGER references Societe_assurance(idSociete),
    idAvion INTEGER references Avion(idAvion),
    dateDebut date NOT NULl default now(),
    dateFin date NOT NULL,
    payer double precision NOT NULL,
    restant double precision
);


CREATE TABLE TypeEntretien(
    idType serial PRIMARY KEY,
    typeEntretien varchar(50) NOT NULL
);

CREATE TABLE Entretien (
    identretien serial PRIMARY KEY,
    idAvion INTEGER references Avion(idAvion),
    idType INTEGER references TypeEntretien(idType),
    dateEntretien date DEFAULT now()
);

CREATE TABLE Token_User(
    idToken serial PRIMARY KEY,
    idUser INTEGER references Utilisateur(idUser),
    token text NOT NULL,
    dateExp timestamp
);
