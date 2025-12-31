import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class Main extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField addFactorField;
    private JTextArea paragraph;

    // Column names mapping to your matrix
    private final String[] columns = {
        "Factor", 
        "Exec Cog", "Exec Ins", "Exec Aff", "Exec Root", "Exec Sac", "Exec Sol", "Exec Hea", "Exec Thr", "Exec Eye", "Exec Cro",
        "S&F Cog", "S&F Ins", "S&F Aff", "S&F Root", "S&F Sac", "S&F Sol", "S&F Hea", "S&F Thr", "S&F Eye", "S&F Cro",
        "O&T Cog", "O&T Ins", "O&T Aff", "O&T Root", "O&T Sac", "O&T Sol", "O&T Hea", "O&T Thr", "O&T Eye", "O&T Cro",
        "Portion (%)", "Anti", "Pro"
    };

    public Main() {
        setTitle("Counsul - 10Core Empathy Matrix");
        setSize(1000, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // 1. Header Label
        JLabel label = new JLabel("10Core Empathy Matrix, FinTech Artificial Neural Network, Swing Typography");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(label, BorderLayout.NORTH);

        // 2. Table Setup
        tableModel = new DefaultTableModel(columns, 0);
        initializeData();
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // For many columns
        JScrollPane scrollPane = new JScrollPane(table);
        
        // 3. Paragraph/Bottom UI
        paragraph = new JTextArea("The overall allocation of resources could be conceived as a long-term survival train trolley problem...");
        paragraph.setLineWrap(true);
        paragraph.setWrapStyleWord(true);
        paragraph.setEditable(false);
        paragraph.setBackground(getBackground());

        // 4. Controls (Add/Calculate)
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addFactorField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JButton calculateButton = new JButton("Calculate");

        addButton.addActionListener(this::addRow);
        calculateButton.addActionListener(this::calculateWeights);

        controls.add(new JLabel("Factor:"));
        controls.add(addFactorField);
        controls.add(addButton);
        controls.add(calculateButton);

        // Layout Assembly
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JScrollPane(paragraph), BorderLayout.NORTH);
        bottomPanel.add(controls, BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializeData() {
        String[] factors = {
            "honesty/integrity/transparency", "compassion/respect", "responsibility/accountability",
            "loyalty/trustworthiness", "law-abiding", "fairness", "leadership", "anti-discrimination",
            "workplace health/safety/security", "employee code of conduct", "attendance & vacation",
            "employee complaint", "work schedule", "substance abuse", "mobile device",
            "compensation and benefits", "travel", "inclement weather", "remote work",
            "conflict of interest", "acceptable use", "compensation", "safety", "relationships",
            "skill discretion", "prospects"
        };

        for (String f : factors) {
            Object[] row = new Object[columns.length];
            row[0] = f;
            for (int i = 1; i <= 30; i++) row[i] = "1";
            row[31] = "0"; // Value
            row[32] = "";  // Anti
            row[33] = "";  // Pro
            tableModel.addRow(row);
        }
    }

    private void addRow(ActionEvent e) {
        String factor = addFactorField.getText();
        if (!factor.isEmpty()) {
            Object[] row = new Object[columns.length];
            row[0] = factor;
            for (int i = 1; i <= 30; i++) row[i] = "1";
            row[31] = "0";
            tableModel.addRow(row);
            addFactorField.setText("");
        }
    }

    private void calculateWeights(ActionEvent e) {
        int rowCount = tableModel.getRowCount();
        double[] weights = new double[rowCount];
        double totalGlobalWeight = 0;

        try {
            for (int i = 0; i < rowCount; i++) {
                double rowWeight = 0;
                // Sum columns 1 through 30 (The core metrics)
                for (int j = 1; j <= 30; j++) {
                    rowWeight += Double.parseDouble(tableModel.getValueAt(i, j).toString());
                }
                weights[i] = rowWeight;
                totalGlobalWeight += rowWeight;
            }

            for (int i = 0; i < rowCount; i++) {
                double portion = (totalGlobalWeight > 0) ? (100 * weights[i] / totalGlobalWeight) : 0;
                tableModel.setValueAt(String.format("%.2f", portion), i, 31);
                
                // Logic for Anti/Pro coring
                String[] values = {"Cognition", "Instinct", "Affectation"};
                tableModel.setValueAt(values[0], i, 32); // Simplified placeholders
                tableModel.setValueAt(values[0], i, 33);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please ensure all matrix values are numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
