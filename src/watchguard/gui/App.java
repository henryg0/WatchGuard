package watchguard.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import watchguard.sensors.HeartRateSensor;

import java.awt.Dimension;

class App {
    private static final int NUM_PROFILES = 6;
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

        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(0,3, 10, 10));

        for (int i = 0; i < NUM_PROFILES; i++ ) { 
            profilePanel.add(new ProfileCard());
        }
        jf.add(profilePanel);
        jf.pack();

        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}