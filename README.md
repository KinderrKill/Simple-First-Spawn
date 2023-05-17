# SimpleFirstSpawn

![SimpleFirstSpawn_Logo](https://i.goopics.net/PO8j5.png)

# SimpleFirstSpawn

SimpleFirstSpawn est un plugin Minecraft conçu pour faciliter la configuration d'un point de spawn personnalisé pour les nouveaux joueurs. Il a été créé dans le cadre d'une vidéo sur la mise en place d'un serveur de type "Holycube", afin de résoudre le problème du spawn automatique dans le Nether et/ou l'End.

## Fonctionnalités

- Définition d'un point de spawn personnalisé sans limite de monde.
- Message d'accueil personnalisé pour les nouveaux joueurs.
- Lecture d'un son lorsqu'un nouveau joueur se connecte.
- Message de connexion personnalisé pour les joueurs.
- Message de déconnexion personnalisé pour les joueurs.

## Installation

1. Téléchargez le plugin depuis [Spigot]( https://www.spigotmc.org/resources/simplefirstspawn.82386/
).
2. Enregistrez-le sur votre bureau (ou dans un autre dossier).
3. Placez le fichier "SimpleFirstSpawn.jar" dans le dossier "plugins" de votre serveur Minecraft.
4. Démarrez votre serveur.
5. Abonnez-vous à ma chaîne YouTube (c'est gratuit ;)).

## Commandes

- `/simplefirstspawn define` ou `/sfs define` : Définit le point de spawn en fonction de la position du joueur (doit être exécuté en jeu).

Remarque : L'orientation de la tête du joueur est prise en compte lors de la définition du spawn.

## Permissions

- `sfs.define` : Permet d'autoriser l'utilisation de la commande `/sfs define`.

## Configuration

Lors du premier lancement de votre serveur avec le plugin activé, un fichier `config.yml` sera créé dans le dossier `SimpleFirstSpawn`. 

Voici une explication des paramètres de ce fichier :

- `spawn-location` : Les coordonnées du point de spawn (x, y, z).
- `welcome-message` : Le message d'accueil pour les nouveaux joueurs.
- `join-sound` : Le nom du son à jouer lorsqu'un nouveau joueur se connecte.
- `join-message` : Le message affiché lorsqu'un joueur se connecte.
- `quit-message` : Le message affiché lorsqu'un joueur quitte le serveur.

N'hésitez pas à personnaliser ce fichier `config.yml` selon vos besoins.

## Auteur

Ce plugin a été créé par [E-Code](https://github.com/KinderrKill).

## Remarques

- Assurez-vous d'avoir les permissions nécessaires pour utiliser les commandes du plugin.
