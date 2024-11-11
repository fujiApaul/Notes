import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlashingLabel extends JFrame implements KeyListener {

    JLabel option1, option2;
    Timer timer;
    boolean isFlashing;
    int selectedOption = 1; // 1 for option1, 2 for option2

    FlashingLabel() {
        // Set up the JFrame
        this.setTitle("Flashing Label Selector");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1)); // Use grid layout for 2 options
        this.setResizable(false);

        // Create two labels for two options
        option1 = new JLabel("Option 1", SwingConstants.CENTER);
        option2 = new JLabel("Option 2", SwingConstants.CENTER);

        // Set font and color for the options
        option1.setFont(new Font("Arial", Font.BOLD, 30));
        option1.setForeground(Color.RED);
        option2.setFont(new Font("Arial", Font.BOLD, 30));
        option2.setForeground(Color.RED);

        this.add(option1); // Add option1 label to the top
        this.add(option2); // Add option2 label to the bottom

        // Add KeyListener to the frame to capture key events
        this.addKeyListener(this);
        this.setFocusable(true);

        // Create a Timer to toggle the selected label's visibility
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFlashing) {
                    // Toggle visibility of the selected option
                    if (selectedOption == 1) {
                        option1.setVisible(!option1.isVisible());
                        option2.setVisible(true); // Ensure option 2 is visible when not selected
                    } else {
                        option2.setVisible(!option2.isVisible());
                        option1.setVisible(true); // Ensure option 1 is visible when not selected
                    }
                }
            }
        });

        // Start the timer and begin flashing for the first option
        timer.start();
        isFlashing = true;
        this.setVisible(true);
    }

    // Handle key presses
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Switch between options using LEFT and RIGHT arrow keys
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            if (selectedOption == 1) {
                selectedOption = 2; // Switch to option2
            } else {
                selectedOption = 1; // Switch to option1
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed in this case
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed in this case
    }

    public static void main(String[] args) {
        // Create and show the flashing label window
        new FlashingLabel();
    }
}
