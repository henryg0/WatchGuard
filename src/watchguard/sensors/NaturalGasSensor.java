package watchguard.sensors;

import java.util.List;

public class NaturalGasSensor extends Sensor {
    public NaturalGasSensor(int portNumber) {
        super(portNumber);
    }
    public int getNaturalGas() {
        // read from UART sensor
        // update database w/ new reading
        return 0;
    }

    public int getAvgNaturalGas() {
        // read from database
        List<Integer> naturalGasReadings = null;
        int res = 0;
        for (int naturalGas : naturalGasReadings) {
            res += naturalGas;
        }
        return res / naturalGasReadings.size();
    }
}
