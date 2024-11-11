import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements KeyListener {

    JLabel start, achievements, help, settings;
    JLabel[] menuOptions;
    int selectedOption = 0; // Index to keep track of the selected option
    Timer flashTimer;
    boolean isYellow = true; // Flag to toggle color

    MainMenu() {
        this.setTitle("AOOP Project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(new BorderLayout());

        this.setResizable(false);

        ImageIcon logo = new ImageIcon("C:\\Users\\Administrator\\Desktop\\Notes\\S.Y.  _24 - _25\\Java Projects\\FinalsProject\\pixelWizard.png");
        this.setIconImage(logo.getImage());

        Insets insets = this.getInsets();
        int widthWithInsets = 1280 + insets.left + insets.right;
        int heightWithInsets = 720 + insets.top + insets.bottom;
        this.setSize(new Dimension(widthWithInsets, heightWithInsets));

        this.setLocationRelativeTo(null);

        JPanel title = new JPanel();
        JPanel options = new JPanel();
        JPanel copyright = new JPanel();

        title.setBackground(Color.black);
        options.setBackground(Color.black);
        copyright.setBackground(Color.black);

        title.setPreferredSize(new Dimension(100, 200));
        options.setPreferredSize(new Dimension(100, 100));
        copyright.setPreferredSize(new Dimension(100, 100));

        title.setLayout(new GridBagLayout());
        options.setLayout(new GridBagLayout());
        copyright.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 0, 10);

        JLabel Simpaul = new JLabel("A O O P");
        Simpaul.setFont(new Font("RetroPix Regular", Font.PLAIN, 100));
        Simpaul.setForeground(new Color(0xFFDE59));
        gbc.gridx = 0;
        gbc.gridy = 0;
        title.add(Simpaul, gbc);

        JLabel TextRPG = new JLabel("TEXT ROLE PLAYING GAME");
        TextRPG.setFont(new Font("RetroPix Regular", Font.PLAIN, 25));
        TextRPG.setForeground(new Color(0xFFDE59));
        gbc.gridx = 0;
        gbc.gridy = 1;
        title.add(TextRPG, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Menu options as JLabels
        start = new JLabel("START");
        start.setFont(new Font("RetroPix Regular", Font.PLAIN, 23));
        start.setForeground(Color.yellow); // Start is selected initially
        gbc.gridx = 0;
        gbc.gridy = 0;
        options.add(start, gbc);

        achievements = new JLabel("ACHIEVEMENTS");
        achievements.setFont(new Font("RetroPix Regular", Font.PLAIN, 23));
        achievements.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 2;
        options.add(achievements, gbc);

        help = new JLabel("HELP");
        help.setFont(new Font("RetroPix Regular", Font.PLAIN, 23));
        help.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 3;
        options.add(help, gbc);

        settings = new JLabel("SETTINGS");
        settings.setFont(new Font("RetroPix Regular", Font.PLAIN, 23));
        settings.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 4;
        options.add(settings, gbc);

        // Store all options in an array for easy access
        menuOptions = new JLabel[]{start, achievements, help, settings};

        JLabel Credits = new JLabel("Copyright 2024 Paul 'n Friends");
        Credits.setFont(new Font("VT323", Font.PLAIN, 20));
        Credits.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 0;
        copyright.add(Credits, gbc);

        this.add(title, BorderLayout.NORTH);
        this.add(options, BorderLayout.CENTER);
        this.add(copyright, BorderLayout.SOUTH);
        this.setVisible(true);

        // Add KeyListener
        this.addKeyListener(this);
        this.setFocusable(true); // Allow key events

        // Timer to flash colors between white and yellow
        flashTimer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleSelectionColor();
            }
        });
        flashTimer.start(); // Start flashing immediately for the initial selection
    }

    // Method to toggle between white and yellow colors for the selected option
    private void toggleSelectionColor() {
        JLabel selectedLabel = menuOptions[selectedOption];
        if (isYellow) {
            selectedLabel.setForeground(Color.white); // Switch to white
        } else {
            selectedLabel.setForeground(Color.yellow); // Switch to yellow
        }
        isYellow = !isYellow; // Toggle the flag
    }

    // Method to stop the flashing for all options except the selected one
    private void updateSelection() {
        for (int i = 0; i < menuOptions.length; i++) {
            if (i != selectedOption) {
                menuOptions[i].setForeground(Color.white); // Reset to white
            }
        }
        isYellow = true; // Reset the flashing flag for the new selection
    }

    // KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Use W or UP arrow key to move up the menu
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            if (selectedOption > 0) {
                selectedOption--;
            } else {
                selectedOption = menuOptions.length - 1; // Wrap around to the last option
            }
        }

        // Use S or DOWN arrow key to move down the menu
        if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            if (selectedOption < menuOptions.length - 1) {
                selectedOption++;
            } else {
                selectedOption = 0; // Wrap around to the first option
            }
        }

        // Trigger action on ENTER key press
        if (keyCode == KeyEvent.VK_ENTER) {
            executeAction(selectedOption);
        }

        // Update the selection highlight
        updateSelection();
    }

    // Perform an action based on the selected option
    private void executeAction(int selectedOption) {
        switch (selectedOption) {
            case 0:
                TypewriterEffect effect = new TypewriterEffect();

                
                effect.askInput("Please type your text below");
                
                this.dispose();
                break;
            case 1:
                System.out.println("Achievements!");
                // Achievements logic here
                break;
            case 2:
                System.out.println("Help!");
                // Help logic here
                break;
            case 3:
                System.out.println("Settings!");
                // Settings logic here
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}
