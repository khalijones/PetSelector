import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

// Main class
public class PetSelector extends JFrame {
    private JLabel imageLabel; // Label to display images
    private ButtonGroup group; // Button group to allow selection
    private String[] petNames = { "Bird", "Cat", "Dog", "Rabbit", "Pig" }; // Pet names
    private String[] imagePaths = { // Paths to pet images
            "bird.png", "cat.png", "dog.png", "rabbit.png", "pig.png"
    };

    // Constructor for the GUI
    public PetSelector() {
        setTitle("RadioButtonDemo");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Panel to hold the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        group = new ButtonGroup();

        // A loop which creates radio buttons for each pet
        for (int i = 0; i < petNames.length; i++) {
            JRadioButton radioButton = new JRadioButton(petNames[i]);
            group.add(radioButton);
            radioPanel.add(radioButton);

            int index = i;
            radioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Change the image according to the selected pet
                    imageLabel.setIcon(new ImageIcon(imagePaths[index]));
                    // Show a message displaying the selected pet
                    JOptionPane.showMessageDialog(null, "You selected: " + petNames[index]);
                }
            });
        }

        // Create a label to display images
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(150, 150));

        // Thus is the Default pet image which is the first pet image
        imageLabel.setIcon(new ImageIcon(imagePaths[0]));

        add(radioPanel);
        add(imageLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PetSelector();
    }
}
