# WatchGuard

WatchGuard is a wearable device that aims to provide security to first responders, particularly firefighters, on the field. The device detects dangerous and life-threatening aspects of the wearer's environment through various peripherals connected to the device and alerts them of the dangers. Moreover, the wearable WatchGuard device will be connected to a central application that the team manager will command. The central application (which makes up the bulk of the repository) is responsible for receiving information sent by the wearable device(s) and sending signals on the to the devices on the team manager's command.

## Running the Application

### Requirements

- [Apache Maven](https://maven.apache.org) is used to build and compile the appliation into a `.jar` file.

### Directions

1. Change into the root directory of the project.
2. To build the project, run Maven with `mvn clean package`.
   - This will first clean the project.
   - This then compiles the project and builds the package.
3. To start the app, run java on newly created jar file with the command `java -cp ./target/WatchGuardControl.jar watchguard.gui.App`.