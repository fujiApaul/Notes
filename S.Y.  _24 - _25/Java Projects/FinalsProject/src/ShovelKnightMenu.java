import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShovelKnightMenu extends JPanel implements KeyListener {

    private int selectedOption = 0;
    private boolean gameStarted = false;

    public ShovelKnightMenu() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Draw background (black)
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw Shovel Knight title
        g2d.setColor(new Color(255, 165, 0)); // Orange
        g2d.setFont(new Font("Arial", Font.BOLD, 48)); // Adjust font size as needed
        g2d.drawString("SHOVEL", 100, 100);
        g2d.drawString("KNIGHT", 130, 160); // Adjusted position based on image

        // Draw menu options
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));

        // Highlight selected option
        switch (selectedOption) {
            case 0:
                g2d.setColor(Color.YELLOW);
                g2d.drawString("START GAME", 180, 280); // Adjusted positions based on image
                g2d.setColor(Color.WHITE);
                g2d.drawString("FEATS", 180, 330);
                g2d.drawString("HELP & OPTIONS", 180, 380);
                g2d.drawString("SWITCH PROFILE", 180, 430);
                break;
            case 1:
                g2d.setColor(Color.WHITE);
                g2d.drawString("START GAME", 180, 280);
                g2d.setColor(Color.YELLOW);
                g2d.drawString("FEATS", 180, 330);
                g2d.setColor(Color.WHITE);
                g2d.drawString("HELP & OPTIONS", 180, 380);
                g2d.drawString("SWITCH PROFILE", 180, 430);
                break;
            case 2:
                g2d.setColor(Color.WHITE);
                g2d.drawString("START GAME", 180, 280);
                g2d.setColor(Color.YELLOW);
                g2d.drawString("HELP & OPTIONS", 180, 380);
                g2d.setColor(Color.WHITE);
                g2d.drawString("FEATS", 180, 330);
                g2d.drawString("SWITCH PROFILE", 180, 430);
                break;
            case 3:
                g2d.setColor(Color.WHITE);
                g2d.drawString("START GAME", 180, 280);
                g2d.setColor(Color.YELLOW);
                g2d.drawString("SWITCH PROFILE", 180, 430);
                g2d.setColor(Color.WHITE);
                g2d.drawString("FEATS", 180, 330);
                g2d.drawString("HELP & OPTIONS", 180, 380);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            selectedOption = (selectedOption + 1) % 4; // Wrap around to the first option
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            selectedOption = (selectedOption - 1 + 4) % 4; // Wrap around to the last option
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            handleMenuSelection();
        }
    }

    private void handleMenuSelection() {
        switch (selectedOption) {
            case 0:
                gameStarted = true;
                System.out.println("Starting game...");
                // Add logic to transition to the game screen
                break;
            case 1:
                System.out.println("Opening Feats...");
                // Add logic to display feats or achievements
                break;
            case 2:
                System.out.println("Opening Help & Options...");
                // Add logic to display help or options
                break;
            case 3:
                System.out.println("Switching Profile...");
                // Add logic to switch profiles
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used, but required by KeyListener
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used, but required by KeyListener
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shovel Knight Menu");
        ShovelKnightMenu menuPanel = new ShovelKnightMenu();
        frame.add(menuPanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

