import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGUIFrame extends JFrame {
    // Panels
    JPanel mainPnl, crustPnl, sizePnl, toppingsPnl, orderPnl, buttonPnl;

    // Crust Radio Buttons
    JRadioButton thinRB, regularRB, deepDishRB;
    ButtonGroup crustGroup;

    // Size comboBox
    JComboBox<String> sizeCB;
    String[] sizes = {"Small - $8", "Medium - $12", "Large - $16", "Super - $20"};
    double[] sizePrices = {8.00, 12.00, 16.00, 20.00};

    // Toppings checkboxes
    JCheckBox cheeseCB, pepperoniCB, existentialDreadCB, fetaCB, italianSausageCB, uranium222CB;

    // Order Receipt
    JTextArea orderTA;
    JScrollPane orderSP;

    // Action Buttons
    JButton orderBtn, clearBtn, quitBtn;

    public PizzaGUIFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4, 1));
        mainPnl.setBackground(Color.decode("#4A90E2"));

        createCrustPanel();
        createSizePanel();
        createToppingsPanel();
        createOrderPanel();
        createButtonPanel();

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.setBackground(Color.decode("#4A90E2"));
        topPanel.add(crustPnl);
        topPanel.add(sizePnl);

        mainPnl.add(topPanel);
        mainPnl.add(toppingsPnl);
        mainPnl.add(orderPnl);
        mainPnl.add(buttonPnl);

        add(mainPnl);
        setTitle("Pizza Order Form");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createCrustPanel() {
        crustPnl = new JPanel(new GridBagLayout());
        crustPnl.setBorder(new TitledBorder(new EtchedBorder(), "Pick Your Crust"));
        crustPnl.setBackground(Color.decode("#4A90E2"));

        thinRB = new JRadioButton("Thin");
        regularRB = new JRadioButton("Regular");
        deepDishRB = new JRadioButton("Deep-Dish");

        thinRB.setForeground(Color.BLACK);
        regularRB.setForeground(Color.BLACK);
        deepDishRB.setForeground(Color.BLACK);
        thinRB.setBackground(Color.decode("#4A90E2"));
        regularRB.setBackground(Color.decode("#4A90E2"));
        deepDishRB.setBackground(Color.decode("#4A90E2"));

        crustGroup = new ButtonGroup();
        crustGroup.add(thinRB);
        crustGroup.add(regularRB);
        crustGroup.add(deepDishRB);

        JPanel radioBtnContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        radioBtnContainer.setBackground(Color.decode("#4A90E2"));
        radioBtnContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        radioBtnContainer.add(thinRB);
        radioBtnContainer.add(regularRB);
        radioBtnContainer.add(deepDishRB);

        crustPnl.add(radioBtnContainer);
    }

    private void createSizePanel() {
        sizePnl = new JPanel(new GridBagLayout());
        sizePnl.setBorder(new TitledBorder(new EtchedBorder(), "Choose Pizza Size"));
        sizePnl.setBackground(Color.decode("#4A90E2"));

        sizeCB = new JComboBox<>(sizes);
        sizeCB.setForeground(Color.BLACK);
        sizeCB.setBackground(Color.WHITE);
        sizeCB.setFont(new Font("Arial", Font.BOLD, 14));

        sizePnl.add(sizeCB);
    }

    private void createToppingsPanel() {
        toppingsPnl = new JPanel(new GridLayout(2, 3));
        toppingsPnl.setBorder(new TitledBorder(new EtchedBorder(), "Choose Your Toppings ($1 each)"));
        toppingsPnl.setBackground(Color.decode("#4A90E2"));

        JCheckBox[] checkboxes = {
                cheeseCB = new JCheckBox("Cheese"),
                pepperoniCB = new JCheckBox("Pepperoni"),
                existentialDreadCB = new JCheckBox("Existential Dread"),
                fetaCB = new JCheckBox("Feta"),
                italianSausageCB = new JCheckBox("Italian Sausage"),
                uranium222CB = new JCheckBox("Uranium-222")
        };

        for (JCheckBox cb : checkboxes) {
            cb.setForeground(Color.BLACK);
            cb.setBackground(Color.decode("#4A90E2"));
            toppingsPnl.add(cb);
        }
    }

    private void createOrderPanel() {
        orderPnl = new JPanel(new BorderLayout());
        orderPnl.setBorder(new TitledBorder(new EtchedBorder(), "Order Details"));
        orderPnl.setBackground(Color.decode("#4A90E2"));

        orderTA = new JTextArea(10, 40);
        orderTA.setEditable(false);
        orderTA.setFont(new Font("Monospaced", Font.BOLD, 12));
        orderTA.setBackground(Color.WHITE);
        orderTA.setForeground(Color.BLACK);

        orderSP = new JScrollPane(orderTA);
        orderPnl.add(orderSP, BorderLayout.CENTER);
    }

    private void createButtonPanel() {
        buttonPnl = new JPanel(new GridBagLayout()); // This was the only way I could center within the Panels.
        buttonPnl.setBorder(new TitledBorder(new EtchedBorder(), "Actions"));
        buttonPnl.setBackground(Color.decode("#4A90E2"));

        orderBtn = new JButton("Order");
        clearBtn = new JButton("Clear");
        quitBtn = new JButton("Quit");

        JButton[] buttons = {orderBtn, clearBtn, quitBtn};
        for (JButton btn : buttons) {
            btn.setForeground(Color.WHITE);
            btn.setBackground(Color.decode("#E31837"));
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            btn.setFocusPainted(false);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel btnContainer = new JPanel(new GridLayout(1, 3, 10, 0));
        btnContainer.setBackground(Color.decode("#4A90E2"));
        btnContainer.add(orderBtn);
        btnContainer.add(clearBtn);
        btnContainer.add(quitBtn);

        buttonPnl.add(btnContainer, gbc);

        orderBtn.addActionListener(new OrderButtonListener());
        clearBtn.addActionListener(e -> clearForm());
        quitBtn.addActionListener(e -> quit());
    }

    private class OrderButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String crust = thinRB.isSelected() ? "Thin" : regularRB.isSelected() ? "Regular" : deepDishRB.isSelected() ? "Deep-Dish" : "";
            if (crust.isEmpty()) {
                JOptionPane.showMessageDialog(PizzaGUIFrame.this, "Please select a crust type.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int sizeIndex = sizeCB.getSelectedIndex();
            double sizePrice = sizePrices[sizeIndex];

            StringBuilder toppings = new StringBuilder();
            double toppingsCost = 0;
            JCheckBox[] checkboxes = {cheeseCB, pepperoniCB, existentialDreadCB, fetaCB, italianSausageCB, uranium222CB};

            for (JCheckBox cb : checkboxes) {
                if (cb.isSelected()) {
                    toppings.append(String.format("%-25s %10s\n", cb.getText(), "$1.00"));
                    toppingsCost += 1;
                }
            }

            if (toppings.isEmpty()) {
                JOptionPane.showMessageDialog(PizzaGUIFrame.this, "Please select at least one topping.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double subtotal = sizePrice + toppingsCost;
            double tax = subtotal * 0.07;
            double total = subtotal + tax;

            orderTA.setText(String.format(
                    """
                    =========================================
                    %-25s %10s
                    %s
                    
                    %-25s %10s
                    %-25s %10s
                    -----------------------------------------
                    %-25s %10s
                    =========================================""",
                    crust + " (" + sizes[sizeIndex] + ")", String.format("$%.2f", sizePrice),
                    toppings,
                    "Sub-total:", String.format("$%.2f", subtotal),
                    "Tax:", String.format("$%.2f", tax),
                    "Total:", String.format("$%.2f", total)
            ));
        }
    }

    private void clearForm() {
        crustGroup.clearSelection();
        sizeCB.setSelectedIndex(0);
        cheeseCB.setSelected(false);
        pepperoniCB.setSelected(false);
        existentialDreadCB.setSelected(false);
        fetaCB.setSelected(false);
        italianSausageCB.setSelected(false);
        uranium222CB.setSelected(false);
        orderTA.setText("");
    }

    private void quit() {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit AKA No Pizza?", "Exit", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
