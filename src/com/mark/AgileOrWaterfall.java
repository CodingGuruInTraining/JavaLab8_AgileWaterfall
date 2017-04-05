package com.mark;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class defines the attributes and methods of a
 * form for determining whether to use Agile or
 * Waterfall methodology based on User inputs.
 */
public class AgileOrWaterfall extends JFrame {
    // Defines controls.
    private JTextField projectNameTextField;
    private JCheckBox deadlinesCheckBox;
    private JCheckBox knowledgeCheckBox;
    private JCheckBox requirementsCheckBox;
    private JCheckBox integrationCheckBox;
    private JCheckBox prototypesCheckBox;
    private JButton recommendButton;
    private JLabel resultLabel;
    private JPanel rootPanel;
    private JTextField programmersTextField;

    // Creates an arraylist to hold the checkboxes.
    private ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();

    protected AgileOrWaterfall() {
        // Sets up form.
        super("Agile or Waterfall?");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Adds checkboxes to list.
        boxes.add(deadlinesCheckBox);
        boxes.add(knowledgeCheckBox);
        boxes.add(requirementsCheckBox);
        boxes.add(integrationCheckBox);
        boxes.add(prototypesCheckBox);

        // Adds event listener to button.
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = 0;
                // Checks if project name field is filled in before continuing.
                String projectName = projectNameTextField.getText();
                if (projectName.equals("")) {
                    resultLabel.setText("Please enter a Project Name.");
                    return;
                }
                // Exception handler for numeric input.
                try {
                    // Checks if programmers field is filled in before continuing.
                    String programmersText = programmersTextField.getText();
                    if (!programmersText.equals("")) {
                        int programmers = Integer.parseInt(programmersText);
                        // Checks if input is less than a made up static value.
                        if (programmers <= 15) {
                            counter++;
                        }
                    } else {
                        resultLabel.setText("Please enter a number.");
                        return;
                    }
                }
                // Catch for entering non-numbers or decimals.
                catch (NumberFormatException err) {
                    System.out.println("Please only enter whole numbers.");
                }

                // Loops through checkbox list and counts how many are
                // currently selected.
                for (JCheckBox box : boxes) {
                    if (box.isSelected()) {
                        counter++;
                    }
                }

                // Checks what value the counter is at and determines
                // an answer for the User.
                String answer;
                if (counter > 3) {
                    answer = "Agile";
                } else if (counter < 3) {
                    answer = "Waterfall";
                } else {
                    answer = "either one";
                }

                // Displays the entered project name along with the decided answer in a label
                String result = projectNameTextField.getText() + " should use " + answer + " based on the provided data.";
                resultLabel.setText(result);
            }
        });
    }
}
