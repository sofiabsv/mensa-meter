# Mensa Meter

**Kurzbeschreibung**

- Mensa Meter ist eine Android-App (Kotlin + Jetpack Compose), die als Katalog für die Speisen in unserer Mensa dient. Ziel ist es, Speisen anzuzeigen, Favoriten zu verwalten und das Tagesangebot schnell einzusehen.

**Technologie**

- Kotlin, Jetpack Compose
- Android Gradle (Wrapper)

**Funktionen (aktuell)**

- Drei Haupt-Views über Bottom Navigation: Heute, Favoriten, Menü
- Compose-basierte UI (siehe `MainActivity`)

**Voraussetzungen**

- Android Studio (empfohlen)
- Java JDK (z. B. 11 oder 17)
- Android SDK (üblich per Android Studio)

**Build & Run**

- Öffne das Projekt in Android Studio und klicke auf Run.
- Oder in der Konsole (macOS / Linux):

```bash
./gradlew assembleDebug
# oder auf ein verbundenes Gerät installieren
./gradlew installDebug
```

**Wichtige Dateien**

- Haupt-Activity: [app/src/main/java/com/example/myapplication/MainActivity.kt](app/src/main/java/com/example/myapplication/MainActivity.kt)
- UI & Screens: Suche unter `app/src/main/java/com/example/myapplication/` nach weiteren Composables (z. B. `today/TodayScreen`)

**Daten & Inhalt**

- Aktuell sind die Views als Platzhalter/Composables implementiert. Die tatsächlichen Speise-Daten (z. B. lokale DB oder API) müssen noch angebunden werden.

**Mitmachen / Contributing**

- Wünsche oder Fehler bitte als Issue anlegen.
- Für Änderungen: Fork → Branch → Pull Request.

**Lizenz**

- Noch nicht festgelegt. Tragt hier die gewünschte Lizenz ein (z. B. MIT, Apache-2.0).

Wenn du möchtest, ergänze ich die README noch um: Beispiel-Daten, Screenshots oder ein kurzes Architektur-Diagramm.
