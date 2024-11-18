import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TypewriterEffect extends JFrame {
    
    private JTextArea textArea;
    private JTextField inputField;
    private Timer timer;
    private String textToDisplay = "";
    private int charIndex = 0;
    private Clip typingSoundClip;
    private int typingSpeed = 50;

    public TypewriterEffect() {
        // Basic JFrame setup
        this.setTitle("Typewriter RPG");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Text Area setup
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        this.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Input Field setup
        inputField = new JTextField();
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 16));
        this.add(inputField, BorderLayout.SOUTH);

        // Input ActionListener
        inputField.addActionListener(e -> {
            String input = inputField.getText();
            inputField.setText("");
            showPrompt("You typed: " + input);
        });

        // Preload audio
        try {
            preloadAudio();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading audio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.setVisible(true);
    }

    private void preloadAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("very short sample typing sound 1.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        typingSoundClip = AudioSystem.getClip();
        typingSoundClip.open(audioStream);
    }

    public void displayText(String text) {
        textToDisplay = text;
        charIndex = 0;
        textArea.setText("");
        inputField.setEnabled(false);

        timer = new Timer(typingSpeed, e -> {
            if (charIndex < textToDisplay.length()) {
                textArea.append(String.valueOf(textToDisplay.charAt(charIndex)));
                charIndex++;

                if (typingSoundClip != null) {
                    if (typingSoundClip.isRunning()) {
                        typingSoundClip.stop();
                    }
                    typingSoundClip.setFramePosition(0);
                    typingSoundClip.start();
                }
            } else {
                timer.stop();
                inputField.setEnabled(true);
            }
        });
        timer.start();
    }

    public void showPrompt(String prompt) {
        displayText(prompt);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                TypewriterEffect effect = new TypewriterEffect();
                effect.showPrompt("Welcome to the text-based RPG! What's your name?");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
