package com.mark;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * Created by hl4350hb on 3/22/2017.
 */
public class AgileOrWaterfall extends JFrame {
    private JTextField projectNameTextField;
//    private JCheckBox programmersCheckBox;
    private JCheckBox deadlinesCheckBox;
    private JCheckBox knowledgeCheckBox;
    private JCheckBox requirementsCheckBox;
    private JCheckBox integrationCheckBox;
    private JCheckBox prototypesCheckBox;
    private JButton recommendButton;
    private JLabel resultLabel;
    private JPanel rootPanel;
    private JTextField programmersTextField;

    private int counter = 0;

    private ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();

    protected AgileOrWaterfall() {
        super("Agile or Waterfall?");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

//        ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();
        boxes.add(deadlinesCheckBox);
        boxes.add(knowledgeCheckBox);
        boxes.add(requirementsCheckBox);
        boxes.add(integrationCheckBox);
        boxes.add(prototypesCheckBox);

        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter = 0;
                String projectName = projectNameTextField.getText();
                if (projectName.equals("")) {
                    resultLabel.setText("Please enter a Project Name.");
                    return;
                }
                String programmersText = programmersTextField.getText();
                if (!programmersText.equals("")) {
                    int programmers = Integer.parseInt(programmersText);
                    if (programmers <= 15) {
                        counter++;
                    }
                } else {
                    resultLabel.setText("Please enter a number.");
                    return;
                }


//                ArrayList<JCheckBox> boxes = Array.stream(rootPanel.getComponents());
//                for (Component control : rootPanel.getComponents()) {
//                    if (control instanceof JCheckBox) {
//
//                    }
//                }



                for (JCheckBox box : boxes) {
                    if (box.isSelected()) {
                        counter++;
                    }
                }



//                String answer = (counter > 3) ? "Agile" : "Waterfall";
                String answer;
                if (counter > 3) {
                    answer = "Agile";
                } else if (counter < 3) {
                    answer = "Waterfall";
                } else {
                    answer = "either one";
                }

                String result = projectNameTextField.getText() + " should use " + answer + " based on the provided data.";
                resultLabel.setText(result);
            }
        });
        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                System.out.println(e);
                JCheckBox j = (JCheckBox)e.getSource();
                if (j.isSelected()) {
                    counter++;
                }
                else if (counter != 0){
                    counter--;
                }
            }
        };
//        programmersCheckBox.addItemListener(listener);
        deadlinesCheckBox.addItemListener(listener);
        knowledgeCheckBox.addItemListener(listener);
        requirementsCheckBox.addItemListener(listener);
        integrationCheckBox.addItemListener(listener);
        prototypesCheckBox.addItemListener(listener);
    }
}
