# Mon Rythme Sleeve 2.0 💜 — version bêta de test

Application Android native en Java, compilable **sur GitHub Actions sans ordinateur**.

## Nouvelles fonctions

- **5 prises + 6e collation facultative** : après le dîner, y compris le lendemain à 00 h 30 ou plus tard. Dans **Paramètres**, activer « 6e collation ».
- **Horaires réels** : « Je commence » mémorise l'heure exacte de début et estime la fin 30 minutes plus tard. « J'ai terminé » mémorise l'heure exacte de fin, puis recalcule les prises suivantes en tenant compte de l'intervalle sélectionné (2 h 30, 2 h 45 ou 3 h) et des minutes entamées.
- **Historique persistant** : base locale SQLite par journée, début, fin et durée réelle. Une collation prise après minuit reste associée au jour du dîner et est signalée « lendemain ».
- **Thème clair, sombre ou automatique** : sélection dans Paramètres.
- **Personnalisation avancée** : couleur unie, dégradés, fleurs, feuilles, bulles, étoiles, vagues, palette de couleurs, code couleur HEX et photo personnelle depuis le téléphone pour **chaque cadre**, y compris les cadres de chaque repas et le fond général.
- **Prénom et accueil personnalisé** : saisie du prénom et phrases de soutien variant selon l'heure de la journée.
- **Alertes et vibrations** : arrêt des boissons, début du repas, reprise des boissons après la fin réelle. Reprogrammation automatique des alertes, notamment après les actions « Je commence » et « J'ai terminé ».

Les données restent sur l'appareil : pas de compte, pas d'accès Internet requis pour les fonctions de l'application.

## Important : cette bêta ne remplace PAS la V1

Cette version porte l'identifiant Android `fr.monrythmesleeve.app.beta`, différent de la V1. **Elle s'installe à côté de la V1**, qui reste intacte. C'est volontaire : l'APK debug GitHub est signé avec une clé temporaire qui ne permet pas de garantir une mise à jour directe de la V1. Cette version bêta possède ses **propres paramètres et son propre historique** ; les anciens paramètres ne sont pas importés automatiquement. Renseigner son planning dans la bêta avant de la tester.

Pour éviter **deux notifications à la fois**, désactiver les alertes de la V1 pendant les essais de la V2, ou celles de la bêta selon l'application que l'on souhaite utiliser.

## Compilation avec GitHub, sans ordinateur

### Solution recommandée : un nouveau dépôt (conserve celui de la V1)

1. Télécharger ce ZIP et **l'extraire** avec le gestionnaire de fichiers du téléphone.
2. Créer un dépôt GitHub nommé par exemple `MonRythmeSleeve-V2` (public ou privé, au choix).
3. Dans le dépôt, importer **le contenu du dossier extrait**, **pas le ZIP lui-même** et **pas un sous-dossier enveloppe**. À la racine du dépôt, les éléments doivent être :

   ```text
   .github/workflows/build.yml
   app/build.gradle.kts
   app/src/main/AndroidManifest.xml
   app/src/main/java/fr/monrythmesleeve/app/MainActivity.java
   app/src/main/java/fr/monrythmesleeve/app/ScheduleStore.java
   app/src/main/java/fr/monrythmesleeve/app/HistoryStore.java
   app/src/main/java/fr/monrythmesleeve/app/StyledDrawable.java
   build.gradle.kts
   gradle.properties
   settings.gradle.kts
   README.md
   ```

   Le dossier `.github` commence bien par un **point** : certains gestionnaires de fichiers Android masquent les dossiers cachés, il faut activer leur affichage.
4. Vérifier que **`.github/workflows/build.yml`** est au bon endroit (et pas dans un dossier intitulé « flux de travail »).
5. Aller dans **Actions** → **Construire Mon Rythme Sleeve V2 APK** → **Run workflow** (ou la compilation se déclenche automatiquement après le dépôt sur `main`).
6. Après la coche verte, ouvrir l'exécution GitHub et télécharger l'**Artifact** `MonRythmeSleeve-V2-Beta-APK`.
7. Extraire le ZIP de l'artifact : le fichier à installer est **`app-debug.apk`**. Autoriser si demandé l'installation d'applications depuis le gestionnaire de fichiers ou le navigateur.
8. Lancer la bêta, autoriser les notifications, vérifier les paramètres de rappel et enregistrer son planning.

> **GitHub ne décompresse pas automatiquement un ZIP** téléversé comme fichier : l'extraction est nécessaire avant l'import.

### Si la compilation échoue

Ouvrir **Actions → dernière exécution → Compiler APK beta** et copier les dernières lignes de l'étape rouge. Ces journaux permettront de corriger exactement le problème.

## Notes de fonctionnement

- Les heures enregistrées sont réelles (timestamp Android) ; les horaires **futurs** sont arrondis à la minute suivante pour ne pas réduire l'intervalle minimal.
- Quand une prise a commencé mais n'est pas marquée terminée, l'alerte de reprise des boissons de cette prise n'est pas envoyée prématurément.
- Les motifs intégrés sont dessinés localement dans l'application ; les photos personnelles sont importées via le sélecteur de fichiers Android, sans téléversement.
- Les alertes peuvent être retardées si Android limite les alarmes exactes ou l'activité en arrière-plan. Vérifier **Alertes → Autorisations Android**.
- Cette version a fait l'objet d'une vérification statique des fichiers Java et du projet, **mais pas d'une compilation Android en local**. La compilation GitHub Actions et des essais sur téléphone restent nécessaires.
- Cette application aide à organiser les horaires indiqués personnellement. Elle ne remplace pas les instructions de l'équipe soignante.

## Configuration

- Identifiant bêta : `fr.monrythmesleeve.app.beta`
- Java 17, Android Gradle Plugin 8.7.3, Gradle 8.9
- compileSdk 35, minSdk 26, targetSdk 34
- Pas de bibliothèque externe supplémentaire
- APK de test (debug), pas une version Play Store
