# API de Gestion des Utilisateurs et des Tâches

Cette API permet de gérer les utilisateurs et les tâches. Elle inclut des fonctionnalités CRUD (Create, Read, Update, Delete) pour les deux entités, ainsi qu'un système d'authentification basé sur JWT (JSON Web Token).

## Table des Matières

- [Technologies CRUD](#technologies)
- [Installation CRUD](#installation)
- [Structure du Projet CRUD](#structure-du-projet)
- [Fonctionnalités CRUD](#fonctionnalités)
- [Endpoints API CRUD](#endpoints-api)
- [DTOs](#dtos)

## Technologies CRUD

- Spring Boot
- Java
- JWT (JSON Web Tokens)
- Lombok

## Installation CRUD

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/votre-repo/votre-projet.git
   ```
2. Accédez au répertoire du projet :
   ```bash
   cd votre-projet
   ```
3. Configurez le fichier `application.properties` avec vos informations de base de données.
4. Démarrez l'application :
   ```bash
   ./mvnw spring-boot:run
   ```

## Structure du Projet CRUD

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── fr/
│   │   │   ├── esgi/
│   │   │   │   ├── User_Task/
│   │   │   │   │   ├── application/
│   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── TacheController.java
│   │   │   │   │   │   │   ├── UtilisateurController.java
│   │   │   │   │   │   ├── dto/
│   │   │   │   │   │   │   ├── tache/
│   │   │   │   │   │   │   │   ├── InTacheDto.java
│   │   │   │   │   │   │   │   ├── OutTacheDto.java
│   │   │   │   │   │   │   ├── permission/
│   │   │   │   │   │   │   ├── JwtPayload.java
│   │   │   │   │   │   │   ├── InUtilisateurDto.java
│   │   │   │   │   │   │   ├── OutUtilisateurDto.java
│   │   │   │   │   ├── mapper/
│   │   │   │   │   │   ├── DtoToDomainUtilisateurMapper.java
│   │   │   │   │   │   ├── TacheDtoToDomainMapper.java
│   │   │   │   │   │── DataInitializer.java
│   │   │   │   │   │── config/
│   │   │   │   │   │   ├── SecurityConfig.java
│   │   │   │   │   │   ├── FilterConfiguration.java
│   │   │   │   │   ├── domain/
│   │   │   │   │   │   ├── ports/
│   │   │   │   │   │   │   ├── api/
│   │   │   │   │   │   │   │   ├── ITacheService.java
│   │   │   │   │   │   │   │   ├── IUtilisateurService.java
│   │   │   │   │   │   │   │   ├── TacheService.java
│   │   │   │   │   │   │   │   ├── UtilisateurService.java
│   │   │   │   │   │   │   ├── spi/
│   │   │   │   │   │   │   │   ├── ITacheDao.java
│   │   │   │   │   │   │   │   ├── IUtilisateurDao.java
│   │   │   │   │   │   │   ├── Tache.java
│   │   │   │   │   │   │   ├── Utilisateur.java
│   │   │   │   │   │   ├── filter/
│   │   │   │   │   │   │   ├── PermissionsFilter.java
│   │   │   │   │   │   ├── infrastructure/
│   │   │   │   │   │   │   ├── adapter/
│   │   │   │   │   │   │   │   ├── TacheDao.java
│   │   │   │   │   │   │   │   ├── UtilisateurDao.java
│   │   │   │   │   │   │   ├── entity/
│   │   │   │   │   │   │   │   ├── TacheEntity.java
│   │   │   │   │   │   │   │   ├── UtilisateurEntity.java
│   │   │   │   │   │   │   ├── mapper/
│   │   │   │   │   │   │   │   ├── EntityToDomainMapper.java
│   │   │   │   │   │   │   │   ├── TacheDomainToEntityMapper.java
│   │   │   │   │   │   │   ├── repository/
│   │   │   │   │   │   │   │   ├── TacheRepository.java
│   │   │   │   │   │   │   │   ├── UtilisateurRepository.java
│   │   │   │   ├── UserTaskApplication.java
├── resources/
│   ├── application.properties
```

## Fonctionnalités CRUD

### Authentification

- Génération et validation de tokens JWT.
- Gestion des rôles des utilisateurs.

### Gestion des Tâches

- Création, lecture, mise à jour et suppression de tâches.

### Gestion des Utilisateurs

- Création, lecture, mise à jour et suppression d'utilisateurs.

## Endpoints API CRUD

### Tâches

- **GET /api/taches/get-all-taches** : Récupérer toutes les tâches.
- **GET /api/taches/get-tache-by-id/{id}** : Récupérer une tâche par son ID.
- **POST /api/taches/nouveau-tache** : Créer une nouvelle tâche.
- **PUT /api/taches/modifie-tache/{id}** : Mettre à jour une tâche existante.
- **DELETE /api/taches/supprimer-tache/{id}** : Supprimer une tâche.

### Utilisateurs

- **GET /api/utilisateurs/get-all-utilisateurs** : Récupérer tous les utilisateurs.
- **GET /api/utilisateurs/get-utilisateur-by-id/{id}** : Récupérer un utilisateur par son ID.
- **POST /api/utilisateurs/nouveau-utilisateur** : Créer un nouvel utilisateur.
- **PUT /api/utilisateurs/modifie-utilisateur/{id}** : Mettre à jour un utilisateur existant.
- **DELETE /api/utilisateurs/supprimer-utilisateur/{id}** : Supprimer un utilisateur.

## DTOs

### InTacheDto

```java
package fr.esgi.User_Task.application.dto.tache;

public class InTacheDto {
    private String titre;
    private String description;
    private Long utilisateurId;

    // Getters and setters
}
```

### OutTacheDto

```java
package fr.esgi.User_Task.application.dto.tache;

public class OutTacheDto {
    private Long id;
    private String titre;
    private String description;
    private Long utilisateurId;

    // Getters and setters
}
```

### InUtilisateurDto

```java
package fr.esgi.User_Task.application.dto.utilisateur;

public class InUtilisateurDto {
    private String username;
    private String mail;
    private String password;

    // Getters and setters
}
```

### OutUtilisateurDto

```java
package fr.esgi.User_Task.application.dto.utilisateur;

import lombok.Data;

@Data
public class OutUtilisateurDto {
    private Long id;
    private String username;
    private String mail;
    private String password;
    private String roles;

    // Getters and setters
}
```

### JwtPayload

```java
package fr.esgi.User_Task.application.dto.permission;

import java.util.Date;
import java.util.List;

public class JwtPayload {
    private String sub;
    private List<String> roles;
    private Date exp;
    private Date iat;

    // Getters and setters
}
```

---

Ce README couvre les aspects essentiels de votre API CRUD, y compris l'installation, la structure du projet, les fonctionnalités et les endpoints disponibles.