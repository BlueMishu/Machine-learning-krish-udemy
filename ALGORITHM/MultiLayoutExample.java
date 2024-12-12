import javax.swing.*;
import java.awt.*;

public class MultiLayoutExample extends JFrame {

    public MultiLayoutExample() {
        setTitle("Multiple Layout Managers Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Section: BorderLayout
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("BorderLayout Example"));
        topPanel.add(new JButton("North"), BorderLayout.NORTH);
        topPanel.add(new JButton("South"), BorderLayout.SOUTH);
        topPanel.add(new JButton("East"), BorderLayout.EAST);
        topPanel.add(new JButton("West"), BorderLayout.WEST);
        topPanel.add(new JButton("Center"), BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Center Section: GridLayout
        JPanel centerPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        centerPanel.setBorder(BorderFactory.createTitledBorder("GridLayout Example"));
        for (int i = 1; i <= 6; i++) {
            centerPanel.add(new JButton("Button " + i));
        }
        add(centerPanel, BorderLayout.CENTER);

        // Left Section: GridBagLayout
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("GridBagLayout Example"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(new JLabel("Label 1:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        leftPanel.add(new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(new JLabel("Label 2:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        leftPanel.add(new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        leftPanel.add(new JButton("Submit"), gbc);

        add(leftPanel, BorderLayout.WEST);

        // Bottom Section: GroupLayout
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder("GroupLayout Example"));
        GroupLayout layout = new GroupLayout(bottomPanel);
        bottomPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel label = new JLabel("Enter Text:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Click Me");

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(label)
                .addComponent(textField)
                .addComponent(button)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label)
                .addComponent(textField)
                .addComponent(button)
        );

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultiLayoutExample frame = new MultiLayoutExample();
            frame.setVisible(true);
        });
    }
}