package watchguard;

import java.util.ArrayList;
import java.util.List;
import watchguard.Sensor;

public class HeartRateSensor extends Sensor {
    public HeartRateSensor(int portNumber) {
        super(portNumber);
    }

    public int getHeartRate() {
        // read from UART sensor
        // update database w/ new reading
        return 0;
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
