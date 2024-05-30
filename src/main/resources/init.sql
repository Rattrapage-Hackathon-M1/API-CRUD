-- PostgreSQL script

-- Database: crud
-- DROP DATABASE IF EXISTS crud;
-- CREATE DATABASE crud;

-- Connect to the database
-- \c crud

-- Table structure for table produit
CREATE TABLE tache (
  id SERIAL PRIMARY KEY,
  titre VARCHAR(16) NOT NULL,
  description VARCHAR(256) DEFAULT NULL,
  isDone BOOLEAN NOT NULL
  dateCreation DATE NOT NULL
  updateDate DATE NOT NULL
);

-- Table structure for table utilisateur
CREATE TABLE utilisateur (
  id SERIAL PRIMARY KEY,
  nom VARCHAR(32) NOT NULL,
  prenom VARCHAR(32) NOT NULL,
  mail VARCHAR(32) NOT NULL,
  password VARCHAR(32) NOT NULL,
);