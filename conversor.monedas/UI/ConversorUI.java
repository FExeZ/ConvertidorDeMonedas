package UI;

import logic.*;

import javax.swing.*;
import java.awt.*;

public class ConversorUI {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Conversor");
        ventana.setSize(300, 250);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        JPanel topPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel lowPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setBackground(Color.WHITE);
        midPanel.setBackground(Color.GRAY);
        lowPanel.setBackground(Color.WHITE);
        bottomPanel.setBackground(Color.LIGHT_GRAY);

        ventana.setLayout(new BorderLayout());

        topPanel.setPreferredSize(new Dimension(600, 60));
        lowPanel.setPreferredSize(new Dimension(600, 60));
        bottomPanel.setPreferredSize(new Dimension(600, 50));

        // Crea un nuevo panel que contiene lowPanel y bottomPanel
        JPanel lowBottomPanel = new JPanel();
        lowBottomPanel.setLayout(new BorderLayout());
        lowBottomPanel.add(lowPanel, BorderLayout.NORTH);
        lowBottomPanel.add(bottomPanel, BorderLayout.SOUTH);

        ventana.add(topPanel, BorderLayout.NORTH);
        ventana.add(lowBottomPanel, BorderLayout.SOUTH);
        ventana.add(midPanel, BorderLayout.CENTER);

        // Reemplaza JTextArea con JTextField
        JTextArea amountTo = new JTextArea();
        JTextArea toAmount = new JTextArea();
        toAmount.setEditable(false);

        // Configura JTextField en topPanel y lowPanel
        topPanel.add(amountTo);
        lowPanel.add(toAmount);

        ventana.getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Agrega botones
        JButton buttonConverse = new JButton("Convertir");
        JButton buttonClean = new JButton("Limpiar");
//        JButton buttonReload = new JButton("Recargar");

        // Crea un panel para los botones y agrega los botones al panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonConverse);
        buttonPanel.add(buttonClean);
//        buttonPanel.add(buttonReload);

        // Agrega el panel de botones al panel inferior (bottomPanel)
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        JComboBox<Moneda> comboBoxCoinTo = new JComboBox<>();
        JComboBox<Moneda> comboBoxToCoin = new JComboBox<>();

        Moneda yen = new Yen();
        Moneda dolar = new Dolar();
        Moneda peso = new Peso();

        comboBoxCoinTo.setRenderer(new MonedaCellRenderer());
        comboBoxToCoin.setRenderer(new MonedaCellRenderer());

        comboBoxCoinTo.addItem(yen);
        comboBoxCoinTo.addItem(dolar);
        comboBoxCoinTo.addItem(peso);

        comboBoxToCoin.addItem(yen);
        comboBoxToCoin.addItem(dolar);
        comboBoxToCoin.addItem(peso);

        // Crea un panel para "Convertir a" y los JComboBox
        JPanel textComboBoxPanel = new JPanel(new GridLayout(1, 3, 5, 0));
        textComboBoxPanel.add(comboBoxCoinTo);
        textComboBoxPanel.add(new JLabel("convertir a", SwingConstants.CENTER));
        textComboBoxPanel.add(comboBoxToCoin);

        buttonConverse.addActionListener(e -> {
            String inputText = amountTo.getText();
            Moneda monedaOrigen = (Moneda) comboBoxCoinTo.getSelectedItem();
            Moneda monedaDestino = (Moneda) comboBoxToCoin.getSelectedItem();

            try {
                double monto = Double.parseDouble(inputText);
                assert monedaOrigen != null;
                assert monedaDestino != null;
                double resultado = ConversorMoneda.convertirMoneda(monto, monedaOrigen, monedaDestino);
                toAmount.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                // Manejar una entrada inválida
            }
        });

        buttonClean.addActionListener(e -> {
            amountTo.setText("      ");
            toAmount.setText("      ");

        });

        midPanel.setLayout(new BorderLayout());
        midPanel.add(textComboBoxPanel, BorderLayout.CENTER);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }
}


