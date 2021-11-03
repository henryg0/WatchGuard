package src;
import src.HeartRateSensor;

class App {
    public static void main() {
        // calibrate UART
        // assign ports to each sensor
        int heartRateSensorPort = 0;
        HeartRateSensor heartRateSensor = new HeartRateSensor(heartRateSensorPort);
    }
}