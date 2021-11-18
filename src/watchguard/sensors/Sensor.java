package watchguard.sensors;

public abstract class Sensor {
    int PORT_NUMBER;
    public Sensor(int portNumber) {
        PORT_NUMBER = portNumber;
    }
}
