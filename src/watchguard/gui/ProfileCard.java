package watchguard.gui;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * A <code>JPanel</code> that represents a single user that is connected to the program. A variety
 * of information related to the user is displayed here.
 */
public class ProfileCard extends JPanel {
    private static final String CHANGE_NAME_STR = "Change Name";
    private static final String CONFIRM_STR = "Confirm";
    private static final String CANCEL_STR = "Cancel";
    private static final String REMOVE_STR = "Remove";

    private String profileName;
    private int profileId;
    
    // Card header components (assigned in createCardHeader())
    private JPanel headerPanel;
    private JLabel profileDisplayLabel;
    private JTextField newNameField;
    private JButton newNameButton;
    private JButton setNameButton;
    private JButton expandButton;

    // Card content components (assigned in createCardContent())
    private JPanel contentPanel;

    // Card footer components (assigned in createCardFooter())
    private JPanel footerPanel;
    private JButton profileRemoveButton;

    public ProfileCard() {
        super();
        
        // Set initial values
        this.profileName = "N/A";
        this.profileId = -1;

        // Initialize and assign all the components
        initHeaderPanel();
        initContentPanel();
        initFooterPanel();

        BorderLayout layout = new BorderLayout(0, 0);
        setLayout(layout);

        add(this.headerPanel, BorderLayout.PAGE_START);
        add(this.contentPanel, BorderLayout.CENTER);
        add(this.footerPanel, BorderLayout.PAGE_END);

        setName(this.profileName);
        setId(this.profileId);
    }

    /**
     * Sets the display name of the profile card.
     * @param name the name to be displayed
     */
    public void setName(String name) {
        profileName = name;
        updateNameAndId();
    }

    /**
     * Returns the name displayed on the profile card.
     * @return the displayed name
     */
    public String getName() {
        return profileName;
    }

    /**
     * Sets the display id of the profile card.
     * @param id the id to be displayed
     */
    public void setId(int id) {
        profileId = id;
        updateNameAndId();
    }

    /**
     * Returns the id displayed on the profile card.
     * @return the displayed id
     */
    public int getId() {
        return profileId;
    }

    /**
     * Adds an <code>ActionListener</code> to the remove button of the profile card. The intention
     * of this listener is to remove the profile card from the parent container.
     * @param l the <code>ActionListener</code> to be added
     * @see javax.swing.JButton#addActionListener(ActionListener)
     */
    public void addRemoveButtonActionListener(ActionListener l) {
        profileRemoveButton.addActionListener(l);
    }

    /**
     * Removes an <code>ActionListener</code> from the remove button of the profile card. If the
     * listener is the currently set <code>Action</code> for the remove button, then the
     * <code>Action</code> is set to null.
     * @param l the <code>ActionListener</code> to be removed.
     * @see javax.swing.JButton#removeActionListener(ActionListener)
     */
    public void removeRemoveButtonActionListener(ActionListener l) {
        profileRemoveButton.removeActionListener(l);
    }

    /**
     * Returns an array of all the <code>ActionListener</code>s added to the remove button of the
     * profile card with addRemoveButtonActionListener().
     * @return all of the <code>ActionListener</code>s added or an empty array if no listeners have
     * been added.
     * @see javax.swing.JButton#getActionListeners()
     */
    public ActionListener[] getRemoveButtonActionListeners() {
        return profileRemoveButton.getActionListeners();
    }

    private void initHeaderPanel() {
        JPanel root = new JPanel();
        root.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 2));

        this.profileDisplayLabel = new JLabel();

        this.newNameButton = new JButton(CHANGE_NAME_STR);
        this.newNameButton.addActionListener(this::handleNewName);

        this.setNameButton = new JButton(CONFIRM_STR);
        this.setNameButton.addActionListener(this::handleSetName);
        this.setNameButton.setEnabled(false);
        this.setNameButton.setVisible(false);

        this.newNameField = new JTextField();
        this.newNameField.setEnabled(false);
        this.newNameField.setVisible(false);

        GroupLayout layout = new GroupLayout(root);
        root.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.profileDisplayLabel)
                .addComponent(this.newNameField)
        );
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.newNameButton)
                .addComponent(this.setNameButton)
        );

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.profileDisplayLabel)
                .addComponent(this.newNameButton)
        );
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.newNameField)
                .addComponent(this.setNameButton)
        );

        layout.setHorizontalGroup(hGroup);
        layout.setVerticalGroup(vGroup);

        this.headerPanel = root;
    }

    private void initContentPanel() {
        JPanel root = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        root.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));
        // add button to expand profile w/ graphs of metrics
        this.expandButton = new JButton(String.format("%s's metrics", profileName));
        // set names as sensor data labels
        // i.e heartRateLabel
        JLabel heartRateLabel = new JLabel("heart rate:");
        JLabel carbonLabel = new JLabel("carbon monoxide reading:");
        // change to labels so user can't edit
        JTextField label3 = new JTextField("Placeholder");
        JTextField label4 = new JTextField("Placeholder");
        this.expandButton.addActionListener(this::handleExpandProfile);

        GroupLayout layout = new GroupLayout(root);
        root.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup();
        hGroup.addComponent(this.expandButton);
        hGroup.addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(heartRateLabel)
                        .addComponent(carbonLabel)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(label4)
                )
        );

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addComponent(this.expandButton);
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(heartRateLabel)
                .addComponent(label3)
        );
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(carbonLabel)
                .addComponent(label4)
        );

        layout.setHorizontalGroup(hGroup);
        layout.setVerticalGroup(vGroup);

        this.contentPanel = root;
    }

    private void initFooterPanel() {
        JPanel root = new JPanel();
        root.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 2));

        this.profileRemoveButton = new JButton(REMOVE_STR);

        root.add(this.profileRemoveButton);

        this.footerPanel = root;
    }

    private void displayNewNameComponents(boolean flag) {
        newNameField.setEnabled(flag);
        setNameButton.setEnabled(flag);
        newNameField.setVisible(flag);
        setNameButton.setVisible(flag);
    }

    /**
     * When prompting for a new name, a <code>JTextField</code> and a "confirm" <code>JButton</code>
     * will be displayed below. To allow the user to cancel the action, the "new name"
     * <code>JButton</code> will be temporarily changed to a cancel <code>JButton</code> that stops
     * the prompt for a new name.
     * @param event the button press event
     */
    private void handleNewName(ActionEvent event) {
        if (newNameButton.getText().equals(CHANGE_NAME_STR)) {
            newNameButton.setText(CANCEL_STR);
            displayNewNameComponents(true);
        } else {
            newNameField.setText("");
            newNameButton.setText(CHANGE_NAME_STR);
            displayNewNameComponents(false);
        }
    }

     /**
      * This <code>ActionListener</code> lambda will be called when the user presses on the
      * "confirm" <code>JButton</code>. This updates the display <code>JLabel</code> of the profile
      * card and then hides and disables the <code>JTextField</code> and the "confirm"
      * <code>JButton</code>.
      * @param event the button press event
      * @see #handleNewName(ActionEvent)
      */
    private void handleSetName(ActionEvent event) {
        if (newNameField.getText().isBlank()) {
            return;
        }
        String newName = newNameField.getText();
        setName(newName);
        updateExpandButton(newName);
        newNameButton.setText(CHANGE_NAME_STR);
        newNameField.setText("");
        displayNewNameComponents(false);
    }

    private void updateNameAndId() {
        profileDisplayLabel.setText(String.format("name: %s (id: %d)", profileName, profileId));
    }

    private void updateExpandButton(String newName) {
        this.expandButton.setText(String.format("%s's metrics", newName));
    }

    private void handleExpandProfile(ActionEvent e) {
        // createNewFrame
        createProfileFrame();
    }

    private void createProfileFrame() {
        JFrame profileFrame = new JFrame("Test");
        JPanel testPanel = new JPanel();
        JLabel testLabel = new JLabel("hello world");
        testPanel.add(testLabel);
        profileFrame.add(testPanel);
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.pack();
        profileFrame.setLocationByPlatform(true);
        profileFrame.setVisible(true);
        profileFrame.setResizable(false);
    }
}
