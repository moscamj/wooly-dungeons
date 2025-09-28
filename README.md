# Wooly Dungeons – Forge Mod Skeleton

This repository contains a very basic starting point for a Forge‐based
Minecraft mod.  It is tailored for the **"Hello Lime"** story described
in your planning document and provides enough scaffolding to get you
into the game quickly.  The layout follows the conventions from the
official Forge MDK; however, the large binary wrapper files have been
omitted for brevity.  Once you clone this repo you should still
download the official **Mod Development Kit (MDK)** for your target
version of Forge and copy its `gradle` folder, `gradlew` and
`gradlew.bat` scripts into this project so that Eclipse can execute
the Gradle tasks.  The Forge documentation explains this process in
the *From Zero to Modding* section where it instructs you to download
the MDK, extract it into an empty directory and import the project
into your IDE【9580055740765†L125-L132】.

## Prerequisites

* **JDK 21** – Forge 1.21.x requires Java 21.  Forge recommends
  installing an Eclipse Temurin distribution【9580055740765†L117-L122】.
* **Forge MDK** – Download the MDK for the version of Minecraft you
  intend to mod (e.g. *forge‑1.20.1‑47.x.x‑mdk*).  Extract its
  contents next to this repository so that the `gradle` directory and
  wrapper scripts are available【9580055740765†L125-L132】.
* **Eclipse IDE 2025‑09 (JEE)** – The IDE you plan to use.  Ensure
  the Gradle integration plug‑in is installed (it usually is by
  default).

## Getting started

1. **Clone this repository** and copy the missing wrapper files:

   ```sh
   git clone https://example.com/yourusername/woolydungeons.git
   cd woolydungeons
   # copy gradle wrapper from the downloaded MDK
   cp -r ../forge-1.20.1-47.x.x-mdk/gradle .
   cp ../forge-1.20.1-47.x.x-mdk/gradlew .
   cp ../forge-1.20.1-47.x.x-mdk/gradlew.bat .
   chmod +x gradlew
   ```

2. **Import the project into Eclipse**:

   * Open Eclipse and choose *File → Import… → Gradle → Existing
     Gradle Project*.
   * Select the root folder of this repository.  Eclipse will
     automatically download the Forge dependencies and set up the
     project structure.  Forge’s documentation notes that Eclipse’s
     Gradle integration will handle downloading Mojang and Forge
     libraries on import【9580055740765†L149-L159】.
   * Once imported, run the Gradle task `genEclipseRuns` either from
     the *Gradle Tasks* view or the command line.  This task
     generates the run configurations used to launch the client and
     server in development mode【9580055740765†L161-L163】.

3. **Run the mod**:

   * After `genEclipseRuns` completes, refresh the project and you will
     see `Minecraft Client` and `Minecraft Server` launch
     configurations.  Choose *Run* on the client configuration to
     start a development copy of Minecraft with your mod loaded.
   * In game, use `/give @p woolydungeons:lime_keystone` to obtain the
     keystone item.  Right‑click it in the overworld to teleport to
     the Lime realm; right‑click again to return to the overworld.  A
     basic stub dimension definition is provided in
     `src/main/resources/data/woolydungeons/dimension/lime_realm.json`.

4. **Next steps**:

   * Flesh out the Lime dimension by tweaking its JSON definitions in
     `data/woolydungeons/dimension_type/lime_type.json` and the
     dimension generator settings.  You can add a custom biome and
     worldgen features via additional datapack files.
   * Replace the simple teleport item with a portal block and frame
     detection logic as planned in your MVP roadmap.
   * See the `DEVELOPING.md` file for additional guidance.

This scaffold is intentionally minimal.  The official Forge
documentation contains much more detail on mod files, registries,
versioning, and resource formats【9580055740765†L147-L167】【15952368173086†L120-L160】.# wooly-dungeons
