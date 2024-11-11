import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypewriterEffect extends JFrame {
    
    private JTextArea textArea;
    private JTextField inputField;
    private int charIndex = 0;
    private Timer timer;
    private String textToDisplay = "";  // Dynamic text for typewriter effect

    public TypewriterEffect() {
        // Basic JFrame setup
        this.setTitle("Typewriter RPG");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Text Area for typewriter effect display
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        this.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Input Field for user to type
        inputField = new JTextField();
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 16));
        this.add(inputField, BorderLayout.SOUTH);

        // Action listener for input field
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                inputField.setText("");
                askInput("You typed: " + input);  // Respond to input using typewriter effect
            }
        });

        this.setVisible(true);
    }

    // Typewriter effect method to display text
    public void displayText(String text) {
        textToDisplay = text;  // Assign the new text
        charIndex = 0;  // Reset the character index
        textArea.setText("");  // Clear the text area

        // Timer for typewriter effect
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (charIndex < textToDisplay.length()) {
                    textArea.append(String.valueOf(textToDisplay.charAt(charIndex)));
                    charIndex++;
                } else {
                    timer.stop();  // Stop when all characters are displayed
                }
            }
        });
        
        timer.start();  // Start the typing effect
    }

    // Ask for input method with typewriter effect
    public void askInput(String prompt) {
        displayText(prompt);  // Show the prompt with typewriter effect
    }

    public static void main(String[] args) {
        // Create the frame
        TypewriterEffect effect = new TypewriterEffect();

        // Ask for input with a typewriter effect
        effect.askInput("Welcome to the text-based RPG! What's your name?");
    }
}
