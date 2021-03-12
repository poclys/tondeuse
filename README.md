# tondeuse
Projet de tondeuse

## Lancement du projet
Pour lancer le projet :

    mvn clean install exec:java


Pour exécuter la vérification du checkstyle :

    mvn site


Le checkstyle est ensuite accessible dans target/site/checkstyle.xml

## Prérequis
Ce projet utilise Maven, il est donc nécessaire d'avoir Maven installé sur sa machine.
Une version Java 8 ou plus est aussi nécessaire.

## Packaging
Le projet a trois Packages.
### Modele
Contient les modèles de base du projet.
Un point correspond à deux coordonnées.
Il n'y a aucune intelligence dans les modèles hormis la gestion de nombre négatif qui n'ont aucune raison d'exister actuellement dans le projet.
### Exception
Contient toutes les Exception du projet. J'ai laissé uniquement le constructeur avec un message pour forcer son utilisation.
### Utils
Contient toute l'intelligence du projet. Leur usage est indiqué en Javadoc.
### Autre
J'ai laissé sans package la classe main. Elle pourrait aussi passé dans un package CLI.

## Tests
Les tests ne sont pas unitaire pour le moment.

## Sonar
Le projet a un plugin sonar. Pour l'utiliser il faut installer un serveur sonar sur votre machine, si vous avez docker :

    docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

Puis configurer le ( admin admin lors de la première installation, puis ajout de projet et utiliser le tocken dans ce qui suit )


    mvn sonar:sonar -Dsonar.projectKey=excilys:tondeuse -Dsonar.host.url=http://localhost:9000 -Dsonar.login=votre-tocken

On a très peu de code smells, la plupart sont dû à l'affichage dans la console des résultats qui ne sont donc pas des log.

## Logs

On a des log dans un fichier


