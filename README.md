# WatchGuard

## Running the Application

1. Change into the root directory of the project.
2. To build the project, run Maven with `mvn clean package`.
   - This will first clean the project.
   - This then compiles the project and builds the package.
3. To start the app, run java on newly created jar file with the command `java -cp ./target/WatchGuardCentral.jar watchguard.gui.App`.