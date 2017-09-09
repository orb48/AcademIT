package ru.academit.temperature.view;

import ru.academit.temperature.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class View {
    private JFrame frame;

    private View() {
        frame = new JFrame("Перевод температур");
    }

    private void createFrame() {
        JPanel centre = new JPanel(new GridLayout(3, 1));
        JLabel label = new JLabel("Выберите температуры для перевода");
        frame.add(label, BorderLayout.NORTH);
        JPanel panelCentre = new JPanel();
        JPanel panelText = new JPanel();
        JButton button = new JButton("Перевести");

        String[] items = {
                "Celsius",
                "Fahrenheit",
                "Kelvin"
        };
        JComboBox<String> comboBoxFirst = new JComboBox<>(items);
        JComboBox<String> comboBoxSecond = new JComboBox<>(items);

        button.setActionCommand(comboBoxFirst.getSelectedItem().toString());
        JLabel imageLabel = new JLabel(new ImageIcon("image1.png"));
        panelCentre.add(comboBoxFirst);
        panelCentre.add(imageLabel);
        panelCentre.add(comboBoxSecond);
        centre.add(panelCentre);

        panelText.add(new JLabel("Введите температуру:"));
        JTextField enteredTemperature = new JTextField(15);
        panelText.add(enteredTemperature);
        panelText.add(button);
        centre.add(panelText);
        frame.add(centre, BorderLayout.CENTER);
        JTextField textField = new JTextField();
        centre.add(textField);

        Image img = Toolkit.getDefaultToolkit().getImage("temperature.jpg");
        frame.setIconImage(img);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button.addActionListener((ActionEvent e) -> {
            final double[] temp = new double[1];
            boolean isDouble;
            try {
                temp[0] = Double.parseDouble(enteredTemperature.getText());
                isDouble = true;
            } catch (Exception exception) {
                isDouble = false;
            }
            if (isDouble) {
                String tempFirst = (String) comboBoxFirst.getSelectedItem();
                String tempSecond = (String) comboBoxSecond.getSelectedItem();
                Controller controller = new Controller();
                textField.setText(String.valueOf(controller.calculate(temp[0], tempFirst, tempSecond)));
            }
            if (!isDouble) {
                textField.setText("Неправильно введены данные");
            }
        });
    }

    public static void startApplication() {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            view.createFrame();
        });
    }
}
