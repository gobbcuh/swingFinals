import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main() {
        // Set up the main frame
        setTitle("Covalent Hotel Reservation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        // Create header panel with logo
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Logo label (upper left)
        JLabel logoLabel = new JLabel("COVALENT");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoLabel.setForeground(new Color(0, 102, 204)); // Blue color
        
        // Navigation panel
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        navPanel.setBackground(Color.WHITE);
        
        // Search field
        JTextField searchField = new JTextField(15);
        
        // Menu button with dropdown
        JButton menuButton = new JButton("Menu");
        menuButton.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Create popup menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem registerItem = new JMenuItem("Register");
        JMenuItem faqItem = new JMenuItem("FAQs");
        popupMenu.add(registerItem);
        popupMenu.add(faqItem);
        
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(menuButton, 0, menuButton.getHeight());
            }
        });
        
        navPanel.add(searchField);
        navPanel.add(menuButton);
        
        headerPanel.add(logoLabel, BorderLayout.WEST);
        headerPanel.add(navPanel, BorderLayout.EAST);
        
        // Center panel with main logo
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        
        JLabel mainLogo = new JLabel("<html><center>COVALENT<br>HOTEL</center></html>");
        mainLogo.setFont(new Font("Arial", Font.BOLD, 48));
        mainLogo.setForeground(new Color(0, 102, 204)); // Blue color
        
        centerPanel.add(mainLogo);
        
        // Footer panel with reserve button
        JPanel footerPanel = new JPanel(new GridBagLayout());
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        
        JButton reserveButton = new JButton("RESERVE NOW!");
        reserveButton.setFont(new Font("Arial", Font.BOLD, 18));
        reserveButton.setBackground(new Color(0, 102, 204)); // Blue color
        reserveButton.setForeground(Color.WHITE);
        reserveButton.setPreferredSize(new Dimension(200, 50));
        
        footerPanel.add(reserveButton);
        
        // Add all panels to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        
        // Add main panel to frame
        add(mainPanel);
        
        // Set visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}