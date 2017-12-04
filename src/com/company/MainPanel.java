/*
 * Created by JFormDesigner on Tue Nov 21 23:47:24 CST 2017
 */

package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

import static com.company.RandomDataGenerator.*;

/**
 * @author unknown
 */
public class MainPanel extends JPanel {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JPanel panel1;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JComboBox<String> comboBox5;
    private JComboBox<String> comboBox6;
    private JComboBox<String> comboBox7;
    private JComboBox<String> comboBox8;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton buttonGenerate;
    private JScrollPane scrollPane;
    private JTextArea textAreaLogger;
    private JTextField textFieldSql;
    private JLabel label1;
    private JButton buttonClear;
    private JButton buttonCopy;
    private JButton buttonRestorePanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    List<JComboBox<String>> comboBoxes = new ArrayList<>();
    List<JTextField> textFields = new ArrayList<>();

    public MainPanel() {
        initComponents();
        collectComponents();
    }


    public static void showJFrame() {
        MainPanel mainPanel = new MainPanel();
        mainPanel.frame1.setVisible(true);
    }

    private void collectComponents() {
        comboBoxes.add(comboBox1);
        comboBoxes.add(comboBox2);
        comboBoxes.add(comboBox3);
        comboBoxes.add(comboBox4);
        comboBoxes.add(comboBox5);
        comboBoxes.add(comboBox6);
        comboBoxes.add(comboBox7);
        comboBoxes.add(comboBox8);
        textFields.add(textField1);
        textFields.add(textField2);
        textFields.add(textField3);
        textFields.add(textField4);
        textFields.add(textField5);
        textFields.add(textField6);
        textFields.add(textField7);
        textFields.add(textField8);
    }

    RandomDataGenerator randomDataGenerator;

    // insert into MANAGER values( 3115005078 , '姚海标','男', 22, 3500 );
    private void buttonGenerateActionPerformed(ActionEvent e) {
        String rawClause = textFieldSql.getText();
        int size = 0;
        for (int i = 0; i < comboBoxes.size(); i++) {
            String content = comboBoxes.get(i).getItemAt(comboBoxes.get(i).getSelectedIndex());
            if (!"nothing".equals(content)) {
                size++;
            }
        }

        String[] methodNames = new String[size];
        for (int i = 0; i < methodNames.length; i++) {
            String itemAt = comboBoxes.get(i).getItemAt(comboBoxes.get(i).getSelectedIndex());
            methodNames[i] = itemAt.substring(0, itemAt.indexOf("("));
        }
        String[] methodParamsStringArray = new String[size];
        for (int i = 0; i < methodNames.length; i++) {
            methodParamsStringArray[i] = textFields.get(i).getText();
        }

        if (randomDataGenerator == null) {
            randomDataGenerator = new RandomDataGenerator();
        }
        textAreaLogger.append(
                randomDataGenerator.fillValues(
                        rawClause,
                        randomDataGenerator.generateValues(methodNames, methodParamsStringArray)
                )
        );
        textAreaLogger.append("\n");

    }

    private void buttonClearActionPerformed(ActionEvent e) {
        // TODO add your code here
        textAreaLogger.setText("");
    }

    private void buttonCopyActionPerformed(ActionEvent e) {
        // TODO add your code here
        textAreaLogger.copy();
    }

    private void buttonRestorePanelActionPerformed(ActionEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("com.company.values");
        frame1 = new JFrame();
        panel1 = new JPanel();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        comboBox3 = new JComboBox<>();
        comboBox4 = new JComboBox<>();
        comboBox5 = new JComboBox<>();
        comboBox6 = new JComboBox<>();
        comboBox7 = new JComboBox<>();
        comboBox8 = new JComboBox<>();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        buttonGenerate = new JButton();
        scrollPane = new JScrollPane();
        textAreaLogger = new JTextArea();
        textFieldSql = new JTextField();
        label1 = new JLabel();
        buttonClear = new JButton();
        buttonCopy = new JButton();
        buttonRestorePanel = new JButton();

        //======== frame1 ========
        {
            Container frame1ContentPane = frame1.getContentPane();

            //======== panel1 ========
            {
                panel1.setPreferredSize(new Dimension(705, 36));
                panel1.setMaximumSize(new Dimension(994, 32767));
                panel1.setMinimumSize(new Dimension(994, 32));
                panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[]{
                        "nothing",
                        "date( 2 param(s) )",
                        "generateValues( 2 param(s) )",
                        "fillValues( 2 param(s) )",
                        "today( 0 param(s) )",
                        "dateToLast( 1 param(s) )",
                        "dateFuture( 1 param(s) )",
                        "bigint( 1 param(s) )",
                        "bigint( 2 param(s) )",
                        "autoIncreaseBigint( 3 param(s) )",
                        "gender( 0 param(s) )",
                        "smallint( 1 param(s) )",
                        "smallint( 2 param(s) )",
                        "generateChineseName( 1 param(s) )",
                        "generateChineseName( 0 param(s) )",
                        "enums( 1 param(s) )"
                }));
                comboBox1.setPreferredSize(new Dimension(135, 26));
                comboBox1.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                comboBox1.setForeground(UIManager.getColor("Button.foreground"));
                panel1.add(comboBox1);

                //---- comboBox2 ----
                comboBox2.setModel(new DefaultComboBoxModel<>(new String[]{
                        "nothing",
                        "date( 2 param(s) )",
                        "generateValues( 2 param(s) )",
                        "fillValues( 2 param(s) )",
                        "today( 0 param(s) )",
                        "dateToLast( 1 param(s) )",
                        "dateFuture( 1 param(s) )",
                        "bigint( 1 param(s) )",
                        "bigint( 2 param(s) )",
                        "gender( 0 param(s) )",
                        "smallint( 1 param(s) )",
                        "smallint( 2 param(s) )",
                        "generateChineseName( 1 param(s) )",
                        "generateChineseName( 0 param(s) )",
                        "enums( 1 param(s) )"
                }));
                comboBox2.setPreferredSize(new Dimension(135, 26));
                comboBox2.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                comboBox2.setForeground(UIManager.getColor("Button.foreground"));
                panel1.add(comboBox2);

                //---- comboBox3 ----
                comboBox3.setModel(new DefaultComboBoxModel<>(new String[]{
                        "nothing",
                        "date( 2 param(s) )",
                        "generateValues( 2 param(s) )",
                        "fillValues( 2 param(s) )",
                        "today( 0 param(s) )",
                        "dateToLast( 1 param(s) )",
                        "dateFuture( 1 param(s) )",
                        "bigint( 1 param(s) )",
                        "bigint( 2 param(s) )",
                        "gender( 0 param(s) )",
                        "smallint( 1 param(s) )",
                        "smallint( 2 param(s) )",
                        "generateChineseName( 1 param(s) )",
                        "generateChineseName( 0 param(s) )",
                        "enums( 1 param(s) )"
                }));
                comboBox3.setPreferredSize(new Dimension(135, 26));
                comboBox3.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                comboBox3.setForeground(UIManager.getColor("Button.foreground"));
                panel1.add(comboBox3);

                //---- comboBox4 ----
                comboBox4.setModel(new DefaultComboBoxModel<>(new String[]{
                        "nothing",
                        "date( 2 param(s) )",
                        "generateValues( 2 param(s) )",
                        "fillValues( 2 param(s) )",
                        "today( 0 param(s) )",
                        "dateToLast( 1 param(s) )",
                        "dateFuture( 1 param(s) )",
                        "bigint( 1 param(s) )",
                        "bigint( 2 param(s) )",
                        "gender( 0 param(s) )",
                        "smallint( 1 param(s) )",
                        "smallint( 2 param(s) )",
                        "generateChineseName( 1 param(s) )",
                        "generateChineseName( 0 param(s) )",
                        "enums( 1 param(s) )"
                }));
                comboBox4.setPreferredSize(new Dimension(135, 26));
                comboBox4.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                comboBox4.setForeground(UIManager.getColor("Button.foreground"));
                panel1.add(comboBox4);

                //---- comboBox5 ----
                comboBox5.setModel(new DefaultComboBoxModel<>(new String[]{
                        "nothing",
                        "date( 2 param(s) )",
                        "generateValues( 2 param(s) )",
                        "fillValues( 2 param(s) )",
                        "today( 0 param(s) )",
                        "dateToLast( 1 param(s) )",
                        "dateFuture( 1 param(s) )",
                        "bigint( 1 param(s) )",
                        "bigint( 2 param(s) )",
                        "gender( 0 param(s) )",
                        "smallint( 1 param(s) )",
                        "smallint( 2 param(s) )",
                        "generateChineseName( 1 param(s) )",
                        "generateChineseName( 0 param(s) )",
                        "enums( 1 param(s) )"
                }));
                comboBox5.setPreferredSize(new Dimension(135, 26));
                comboBox5.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                comboBox5.setForeground(UIManager.getColor("Button.foreground"));
                panel1.add(comboBox5);

                //---- comboBox6 ----
                comboBox6.setModel(new DefaultComboBoxModel<>(new String[]{
                        "nothing",
                        "date( 2 param(s) )",
                        "generateValues( 2 param(s) )",
                        "fillValues( 2 param(s) )",
                        "today( 0 param(s) )",
                        "dateToLast( 1 param(s) )",
                        "dateFuture( 1 param(s) )",
                        "bigint( 1 param(s) )",
                        "bigint( 2 param(s) )",
                        "gender( 0 param(s) )",
                        "smallint( 1 param(s) )",
                        "smallint( 2 param(s) )",
                        "generateChineseName( 1 param(s) )",
                        "generateChineseName( 0 param(s) )",
                        "enums( 1 param(s) )"
                }));
                comboBox6.setPreferredSize(new Dimension(135, 26));
                comboBox6.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                comboBox6.setForeground(UIManager.getColor("Button.foreground"));
                panel1.add(comboBox6);

                //---- comboBox7 ----
                comboBox7.setModel(new DefaultComboBoxModel<>(new String[]{
                        "nothing",
                        "date( 2 param(s) )",
                        "generateValues( 2 param(s) )",
                        "fillValues( 2 param(s) )",
                        "today( 0 param(s) )",
                        "dateToLast( 1 param(s) )",
                        "dateFuture( 1 param(s) )",
                        "bigint( 1 param(s) )",
                        "bigint( 2 param(s) )",
                        "gender( 0 param(s) )",
                        "smallint( 1 param(s) )",
                        "smallint( 2 param(s) )",
                        "generateChineseName( 1 param(s) )",
                        "generateChineseName( 0 param(s) )",
                        "enums( 1 param(s) )"
                }));
                comboBox7.setPreferredSize(new Dimension(135, 26));
                comboBox7.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                comboBox7.setForeground(UIManager.getColor("Button.foreground"));
                panel1.add(comboBox7);

                //---- comboBox8 ----
                comboBox8.setModel(new DefaultComboBoxModel<>(new String[]{
                        "nothing",
                        "date( 2 param(s) )",
                        "generateValues( 2 param(s) )",
                        "fillValues( 2 param(s) )",
                        "today( 0 param(s) )",
                        "dateToLast( 1 param(s) )",
                        "dateFuture( 1 param(s) )",
                        "bigint( 1 param(s) )",
                        "bigint( 2 param(s) )",
                        "gender( 0 param(s) )",
                        "smallint( 1 param(s) )",
                        "smallint( 2 param(s) )",
                        "generateChineseName( 1 param(s) )",
                        "generateChineseName( 0 param(s) )",
                        "enums( 1 param(s) )"
                }));
                comboBox8.setPreferredSize(new Dimension(135, 26));
                comboBox8.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                comboBox8.setForeground(UIManager.getColor("Button.foreground"));
                panel1.add(comboBox8);

                //---- textField1 ----
                textField1.setPreferredSize(new Dimension(135, 21));
                textField1.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textField1.setForeground(Color.black);
                panel1.add(textField1);

                //---- textField2 ----
                textField2.setPreferredSize(new Dimension(135, 21));
                textField2.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textField2.setForeground(Color.black);
                panel1.add(textField2);

                //---- textField3 ----
                textField3.setPreferredSize(new Dimension(135, 21));
                textField3.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textField3.setForeground(Color.black);
                panel1.add(textField3);

                //---- textField4 ----
                textField4.setPreferredSize(new Dimension(135, 21));
                textField4.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textField4.setForeground(Color.black);
                panel1.add(textField4);

                //---- textField5 ----
                textField5.setPreferredSize(new Dimension(135, 21));
                textField5.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textField5.setForeground(Color.black);
                panel1.add(textField5);

                //---- textField6 ----
                textField6.setPreferredSize(new Dimension(135, 21));
                textField6.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textField6.setForeground(Color.black);
                panel1.add(textField6);

                //---- textField7 ----
                textField7.setPreferredSize(new Dimension(135, 21));
                textField7.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textField7.setForeground(Color.black);
                panel1.add(textField7);

                //---- textField8 ----
                textField8.setPreferredSize(new Dimension(135, 21));
                textField8.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textField8.setForeground(Color.black);
                panel1.add(textField8);
            }

            //---- buttonGenerate ----
            buttonGenerate.setText(bundle.getString("MainPanel.buttonGenerate.text"));
            buttonGenerate.setAutoscrolls(true);
            buttonGenerate.setFocusPainted(false);
            buttonGenerate.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
            buttonGenerate.setForeground(UIManager.getColor("CheckBox.foreground"));
            buttonGenerate.addActionListener(e -> {
                buttonGenerateActionPerformed(e);
                buttonGenerateActionPerformed(e);
            });

            //======== scrollPane ========
            {

                //---- textAreaLogger ----
                textAreaLogger.setEditable(false);
                textAreaLogger.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
                textAreaLogger.setForeground(UIManager.getColor("CheckBox.foreground"));
                scrollPane.setViewportView(textAreaLogger);
            }

            //---- textFieldSql ----
            textFieldSql.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
            textFieldSql.setForeground(UIManager.getColor("CheckBox.foreground"));

            //---- label1 ----
            label1.setText(bundle.getString("MainPanel.label1.text"));
            label1.setLabelFor(textFieldSql);
            label1.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
            label1.setForeground(UIManager.getColor("CheckBox.foreground"));

            //---- buttonClear ----
            buttonClear.setText(bundle.getString("MainPanel.buttonClear.text"));
            buttonClear.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
            buttonClear.setForeground(UIManager.getColor("CheckBox.foreground"));
            buttonClear.addActionListener(e -> buttonClearActionPerformed(e));

            //---- buttonCopy ----
            buttonCopy.setText(bundle.getString("MainPanel.buttonCopy.text"));
            buttonCopy.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
            buttonCopy.setForeground(UIManager.getColor("CheckBox.foreground"));
            buttonCopy.addActionListener(e -> buttonCopyActionPerformed(e));

            //---- buttonRestorePanel ----
            buttonRestorePanel.setText(bundle.getString("MainPanel.buttonRestorePanel.text"));
            buttonRestorePanel.setFont(new Font("\u6587\u6cc9\u9a7f\u7b49\u5bbd\u5fae\u7c73\u9ed1", Font.BOLD, 12));
            buttonRestorePanel.setForeground(UIManager.getColor("CheckBox.foreground"));
            buttonRestorePanel.addActionListener(e -> buttonRestorePanelActionPerformed(e));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                    frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                            .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
                                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(3, 3, 3)
                                                    .addComponent(textFieldSql, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(buttonGenerate))
                                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                                    .addComponent(buttonRestorePanel)
                                                    .addGap(388, 388, 388)
                                                    .addComponent(buttonClear)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(buttonCopy)
                                                    .addGap(0, 448, Short.MAX_VALUE))
                                            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            frame1ContentPaneLayout.setVerticalGroup(
                    frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(buttonGenerate)
                                            .addComponent(textFieldSql, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(buttonRestorePanel)
                                            .addComponent(buttonClear)
                                            .addComponent(buttonCopy))
                                    .addContainerGap(26, Short.MAX_VALUE))
            );
            frame1.setSize(1150, 575);
            frame1.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


    }

}
