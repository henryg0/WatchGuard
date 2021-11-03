import java.util.ArrayList;

public class HeartRateSensor {
    int PORT_NUMBER = null;
    public HeartRateSensor() {
        // calibrate
    }

    public int getHeartRate() {
        // read from UART sensor
        return null;
    }

    public int getAvgHeartRate() {
        // read from database
        List<Integer> heartRateReadings = null;
        int res = 0;
        for (int heartRate : heartRateReadings) {
            res += heartRate;
        }
        return res / heartRateReadings.size();
    }


}
