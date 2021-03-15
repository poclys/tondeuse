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
Le projet a quatre Packages.
### Modele
Contient les modèles de base du projet.
Un point correspond à deux coordonnées.
Il n'y a aucune intelligence dans les modèles hormis la gestion de nombre négatif qui n'ont aucune raison d'exister actuellement dans le projet.
### Exception
Contient toutes les Exception du projet. J'ai laissé uniquement le constructeur avec un message pour forcer son utilisation.
### Utils
Contient toute l'intelligence du projet. Leur usage est indiqué en Javadoc.
### CLI
Dans le package CLI on a la commande line interpreter qui communique avec l'utilisateur.
On y trouve aussi l'énumération Menu qui permet de supprimer les Magic Numbers liés aux choix de l'utilisateur. 

## Tests
Tout les tests sont unitaires désormais.
Sur Eclipse on voit que le projet a atteint les 75% de Coverage, il manque principalement le coverage au niveau de la CLI.

![Tests Eclipse](https://github.com/poclys/tondeuse/blob/main/readMe/testsCouverture.png)

## Sonar
Le projet a un plugin sonar. Pour l'utiliser il faut installer un serveur sonar sur votre machine, si vous avez docker :

    docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

Puis configurer le ( admin admin lors de la première installation, puis ajout de projet et utiliser le tocken dans ce qui suit )


    mvn sonar:sonar -Dsonar.projectKey=excilys:tondeuse -Dsonar.host.url=http://localhost:9000 -Dsonar.login=votre-tocken

Les codes smells sont liés à l'usage de System.out.println dans la CLI. Pour remonter une erreur aux admins, on passe par des loggers.

## Logs

On a des logs dans le dossier /logs
Pour le moment on log uniquement l'erreur qui survient quand la tondeuse sort de la carte, car cette erreur n'est pas
remonté à l'utilisateur et est ignoré lors du fonctionnement du programme

## Spring

Spring a été utilisé dans ce projet pour faire de l'Injection de Dépendances.

