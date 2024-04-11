<div style="text-align: center;"> <h1>Application de gestion de produits</h1> </div>

Cette application est une application Spring Boot qui gère les produits. Elle permet de créer, lire, mettre à jour et supprimer des produits à partir d'une base de données MySQL.
## Configuration de la base de données

1. Assurez-vous d'avoir une instance MySQL en cours d'exécution sur votre machine ou un serveur accessible.

2. Créez une base de données nommée `db_izichange`.

3. Mettez à jour le fichier `application.properties` dans le dossier `src/main/resources` avec les informations de connexion à votre base de données :

   - spring.datasource.url=jdbc:mysql://localhost:3306/product_db 
   - spring.datasource.username=votre_nom_utilisateur 
   - spring.datasource.password=votre_mot_de_passe 

## Exécution de l'application

### Avec Maven

1. Ouvrez un terminal dans le dossier racine de l'application.

2. Exécutez la commande suivante :

    - mvn spring-boot:run

### Avec un IDE

1. Importez le projet dans votre IDE.

2. Configurez le projet pour utiliser Java 8 ou une version ultérieure.

3. Exécutez la classe principale `YourApplication.java` en tant qu'application Java.

## Accès à l'application

Une fois l'application démarrée, vous pouvez accéder à l'API à l'adresse suivante :

    http://localhost:8080

L'API expose les opérations CRUD pour gérer les produits.



