package watchguard.gui;

import watchguard.HeartRateSensor;
import javax.swing.JFrame;
import java.awt.Dimension;

class App {
    public static void main(String[] args) {
        // calibrate UART
        // assign ports to each sensor
        int heartRateSensorPort = 0;
        HeartRateSensor heartRateSensor = new HeartRateSensor(heartRateSensorPort);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startGUI();
            }
        });
    }

    private static void startGUI() {
        JFrame jf = new JFrame("WatchGuard");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setMinimumSize(new Dimension(640, 480));

        jf.add(new ProfileCard());

        jf.pack();

        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}