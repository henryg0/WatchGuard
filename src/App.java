package src;
import src.HeartRateSensor;
import javax.swing.JFrame;

class App {
    public static void main() {
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
        jf.pack();
        jf.setVisible(true);
    }
}