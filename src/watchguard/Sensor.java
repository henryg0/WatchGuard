package watchguard;

public abstract class Sensor {
  int PORT_NUMBER;
  public Sensor(int portNumber) {
    // calibrate
    PORT_NUMBER = portNumber;
  }
  public void Reset() {
    // reset sensor connection
  }
  public void Connect() {
    // establish connection to USB
  }
}