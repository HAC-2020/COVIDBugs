set PATH_TO_FX="C:\Users\miled\Documents\Mile\Hackathon\JavaFX\javafx-sdk-14.0.2.1\lib"
set PATH_TO_JDK="C:\Program Files\Java\jdk-13.0.1\bin\java.exe"
set JAR_TO_LAUNCH="NewHackathon.jar"


%PATH_TO_JDK% --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -jar %JAR_TO_LAUNCH%