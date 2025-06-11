package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends JFrame {
    public MainPage() {
        setTitle("Covalent Hotel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // GIF Background - Fixed loading
        JLabel backgroundLabel = new JLabel();
        try {
            // Try loading from file system first
            ImageIcon gifIcon = new ImageIcon("elements/covalent-gif.gif");
            if (gifIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                // Fallback to class loader if file system fails
                gifIcon = new ImageIcon(getClass().getResource("/elements/covalent-gif.gif"));
            }
            backgroundLabel.setIcon(gifIcon);
        } catch (Exception e) {
            System.err.println("Error loading GIF: " + e.getMessage());
            backgroundLabel.setBackground(Color.BLACK);
            backgroundLabel.setOpaque(true);
        }
        add(backgroundLabel, BorderLayout.CENTER);

        // HEADER PANEL - COMPLETELY UNCHANGED
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK);
        headerPanel.setPreferredSize(new Dimension(1280, 60));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setOpaque(true);

        // Header Icon (EXACTLY AS IN YOUR ORIGINAL CODE)
        try {
            ImageIcon headerIconImg = new ImageIcon("elements/logo.png");
            if (headerIconImg.getImageLoadStatus() == MediaTracker.COMPLETE) {
                JLabel headerIcon = new JLabel(
                        new ImageIcon(headerIconImg.getImage().getScaledInstance(65, 40, Image.SCALE_SMOOTH)));
                headerIcon.setPreferredSize(new Dimension(60, 60));
                headerPanel.add(headerIcon, BorderLayout.WEST);
            } else {
                System.err.println("Header logo not found!");
                JLabel placeholder = new JLabel("LOGO");
                placeholder.setForeground(Color.WHITE);
                headerPanel.add(placeholder, BorderLayout.WEST);
            }
        } catch (Exception e) {
            System.err.println("Error loading header logo: " + e.getMessage());
            JLabel placeholder = new JLabel("LOGO");
            placeholder.setForeground(Color.WHITE);
            headerPanel.add(placeholder, BorderLayout.WEST);
        }

        // Search and Menu Panel (EXACTLY AS IN YOUR ORIGINAL CODE)
        JPanel searchMenuPanel = new JPanel();
        searchMenuPanel.setOpaque(false);
        searchMenuPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton searchButton = new JButton("🔍");
        searchButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBackground(Color.BLACK);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);

        JTextField searchField = new JTextField(15);
        searchField.setVisible(false);
        searchMenuPanel.add(searchField);

        searchButton.addActionListener(e -> {
            if (searchField.isVisible()) {
                searchField.setVisible(false);
                searchButton.setVisible(true);
            } else {
                searchField.setVisible(true);
                searchField.requestFocus();
                searchButton.setVisible(false);
            }
        });

        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                searchField.setVisible(false);
                searchButton.setVisible(true);
            }
        });

        searchMenuPanel.add(searchButton);

        JButton menuButton = new JButton("☰");
        menuButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        menuButton.setForeground(Color.WHITE);
        menuButton.setBackground(Color.BLACK);
        menuButton.setBorderPainted(false);
        menuButton.setFocusPainted(false);

        JPopupMenu dropdownMenu = new JPopupMenu();
        JMenuItem registerItem = new JMenuItem("Register");
        JMenuItem faqsItem = new JMenuItem("FAQs");
        registerItem.setFont(new Font("Libre Baskerville", Font.PLAIN, 14));
        faqsItem.setFont(new Font("Libre Baskerville", Font.PLAIN, 14));
        dropdownMenu.add(registerItem);
        dropdownMenu.add(faqsItem);

        menuButton.addActionListener(e -> {
            dropdownMenu.show(menuButton, 0, menuButton.getHeight());
        });

        searchMenuPanel.add(menuButton);
        headerPanel.add(searchMenuPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel with adjusted spacing
        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(null);
        add(mainPanel, BorderLayout.CENTER);

        // Overlay Panel with adjusted vertical position (moved up higher)
        JPanel overlayPanel = new JPanel();
        overlayPanel.setLayout(new BoxLayout(overlayPanel, BoxLayout.Y_AXIS));
        overlayPanel.setOpaque(false);
        overlayPanel.setBounds(0, 55, 1280, 400); // Changed y-position from 100 to 80 (moved up)

        // Logo (unchanged except vertical position)
        try {
            ImageIcon overlayHexagonImg = new ImageIcon("elements/logo.png");
            if (overlayHexagonImg.getImageLoadStatus() == MediaTracker.COMPLETE) {
                JLabel overlayHexagon = new JLabel(
                        new ImageIcon(overlayHexagonImg.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
                overlayHexagon.setAlignmentX(Component.CENTER_ALIGNMENT);
                overlayPanel.add(overlayHexagon);
                overlayPanel.add(Box.createVerticalStrut(15)); // Reduced space from 20 to 15
            }
        } catch (Exception e) {
            System.err.println("Error loading overlay logo: " + e.getMessage());
            JLabel placeholder = new JLabel("[LOGO]");
            placeholder.setAlignmentX(Component.CENTER_ALIGNMENT);
            overlayPanel.add(placeholder);
            overlayPanel.add(Box.createVerticalStrut(15));
        }

        // Text Overlay with pink background (completely unchanged)
        JPanel textOverlay = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    ImageIcon pinkBg = new ImageIcon("elements/pink-bg.png");
                    if (pinkBg.getImageLoadStatus() == MediaTracker.COMPLETE) {
                        g.drawImage(pinkBg.getImage(), 0, 0, getWidth(), getHeight(), this);
                    } else {
                        g.setColor(new Color(255, 182, 193));
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                } catch (Exception e) {
                    g.setColor(new Color(255, 182, 193));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        textOverlay.setPreferredSize(new Dimension(1280, 140));
        textOverlay.setLayout(new BorderLayout());
        textOverlay.setOpaque(true);

        JLabel titleLabel = new JLabel(
                "<html><center><span style='font-size: 60px; font-weight: 400;'>COVALENT</span><br><span style='font-size: 24px; font-weight: 420;'>HOTEL</span></center></html>");
        titleLabel.setFont(new Font("Libre Baskerville", Font.PLAIN, 14));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.BLACK);
        textOverlay.add(titleLabel, BorderLayout.CENTER);

        overlayPanel.add(textOverlay);
        overlayPanel.add(Box.createVerticalStrut(30)); // Reduced from 40 to 30 for tighter spacing
        mainPanel.add(overlayPanel);

        // Reserve Button with adjusted position (moved up)
        JButton reserveButton = new JButton("RESERVE NOW!");
        reserveButton.setFont(new Font("Libre Baskerville", Font.PLAIN, 18));
        reserveButton.setBackground(new Color(255, 230, 240));
        reserveButton.setForeground(Color.BLACK);
        reserveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        reserveButton.setBounds(540, 470, 200, 50); // Changed y-position from 500 to 450
        reserveButton.setFocusPainted(false);
        reserveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reserveButton.setBackground(new Color(250, 200, 225));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reserveButton.setBackground(new Color(255, 230, 240));
            }
        });
        mainPanel.add(reserveButton);
    }
}