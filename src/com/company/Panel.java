package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

    /**
     * Panel extends JPanel and implements ActionListener and LoggerInterface
     * Here is located: table, slicers, score area, text field, buttons and combo box.
     * Contains methods used to insert value in the table, clear table and save date from the table to txt file
     */

public class Panel extends JPanel implements ActionListener, LoggerInterface {

    private JTextField wartoscText;
    private JLabel wartoscLabel, xLabel, yLabel;
    private JSlider xSlider, ySlider;
    private JButton okbtn, zerowaniebtn, zapisbtn;
    private JTable table;
    private JTextArea scoreArea;
    private JComboBox<String> comboBox;
    private Panel2 panel2;


    public Panel(){

        wartoscText = new JTextField(10);
        wartoscLabel = new JLabel("Wartość: ");
        xLabel = new JLabel("Pozycja x: ");
        yLabel = new JLabel("Pozycja y: ");
        okbtn = new JButton("OK");
        okbtn.setPreferredSize(new Dimension(165,26));
        okbtn.addActionListener(this);
        zerowaniebtn = new JButton("Zerowanie");
        zerowaniebtn.addActionListener(this);
        zapisbtn = new JButton("Zapis");
        zapisbtn.addActionListener(this);

        xSlider = new JSlider(1,5,1); //min, max, default value
        xSlider.setPreferredSize(new Dimension(100, 45));
        xSlider.setMajorTickSpacing(1);
        xSlider.setPaintTicks(true);
        xSlider.setPaintLabels(true); //sets visibility to numbers under slider

        ySlider = new JSlider(1,5,1);
        ySlider.setPreferredSize(new Dimension(100, 45));
        ySlider.setMajorTickSpacing(1);
        ySlider.setPaintTicks(true);
        ySlider.setPaintLabels(true);

        String[][] dataTable = new String[5][5];
        String[] columnNames = {"1", "2", "3", "4", "5"};
        table = new JTable(dataTable, columnNames);
        table.setTableHeader(null);
        table.setRowHeight(30);
        table.setEnabled(false);

        //fills table with zeros
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                table.getModel().setValueAt("0", i, j);
            }
        }

        scoreArea = new JTextArea(20,20);
        scoreArea.setEnabled(false);

        String[] optionComboBox = new String[]{
                "Suma elementów",
                "Średnia elementów",
                "Wartość max i min"
        };

        comboBox = new JComboBox<>(optionComboBox);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                score();
            }
        });

        //layout of Panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // First row
        gc.weightx = 1;
        gc.weighty = 0.1;// how much space it takes, relative to other cells

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;   //nr of current column
        gc.gridy = 0;   //nr of current row
        gc.insets = new Insets(0,5,0,0);
        gc.anchor = GridBagConstraints.LINE_START; // moves position of the cells to the left
        add(wartoscLabel, gc);


        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0,65,0,10);
        gc.anchor = GridBagConstraints.LINE_START;
        add(wartoscText, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 4;
        gc.insets = new Insets(0,20,0,20);
        add(table, gc);

        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;

        // Second row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0,5,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(xLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0,65,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(xSlider, gc);

        // Third row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0,5,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(yLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0,65,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(ySlider, gc);

        // Fourth row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 3;
        gc.insets = new Insets(0,5,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okbtn, gc);

        // Fifth row
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 4;
        gc.insets = new Insets(0,5,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.fill = GridBagConstraints.NONE;
        add(zerowaniebtn, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.insets = new Insets(0,105,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(zapisbtn, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 4;
        gc.insets = new Insets(10,20,20,20);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(comboBox, gc);

        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 1;
        gc.gridy = 4;
        gc.insets = new Insets(60,20,20,20);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JScrollPane(scoreArea), gc);
        //add(scoreArea,gc);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource(); // checks which button has been clicked

        if(clicked == okbtn)
        {
            ok();
        }else  if(clicked == zerowaniebtn)
        {
            zerowanie();
        }else  if(clicked == zapisbtn) {
            zapis();
        }


    }

    /**
     * Takes value from wartoscText, position from xSlider and ySlider and if is valid insets it in the table.
     * Display message dialog if value in watoscText is not numeric.
     */

    public void ok(){
        String wartosc = wartoscText.getText();
        int column = xSlider.getValue();
        int row = ySlider.getValue();
        double wartoscDouble;

        try {
            wartoscDouble = Double.parseDouble(wartosc);

            if(row == 5){
                row = 1;
            }else if(row == 4){
                row = 2;
            }else if(row == 2){
                row = 4;
            }else if(row == 1){
                row = 5;
            }

            table.getModel().setValueAt(wartosc, row-1, column-1);
            score();
            panel2.changeChartPanel(wartoscDouble,column, ySlider.getValue());
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter number!");
            log.error(e);
        }



    }

        /**
         * Inserts "0" in every cell of the table
         * Clears chart panel form Panel2
         */

    public void zerowanie()
    {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                table.getModel().setValueAt("0", i, j);
            }
        }
        score();
        panel2.clearChartPanel();
    }

        /**
         * Saves date from the table to file: "tabela.txt"
         * If necessary create this file
         */

    public void zapis(){
        try {
            File myObj = new File("tabela.txt");

            if(myObj.createNewFile()){  //creating new field
                FileWriter myWriter = new FileWriter(myObj);
                String text="";

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        text = (String)table.getModel().getValueAt( i, j);
                        myWriter.write(text+" ");
                    }
                    myWriter.write("\n");
                }
                myWriter.write("\n");
                myWriter.close();
            }else{  //append text to already existing field
                FileWriter myWriterAppend = new FileWriter(myObj, true);
                String text="";

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        text = (String)table.getModel().getValueAt( i, j);
                        if(text ==null || text=="")
                        {
                            text = "0";
                        }
                        myWriterAppend.write(text+" ");
                    }
                    myWriterAppend.write("\n");
                }
                myWriterAppend.write("\n");
                myWriterAppend.close();
            }

        }catch (IOException ee){
            System.out.println("Wystapil blad!!");
            ee.printStackTrace();    //error
        }
    }

        /**
         * Activated by changing selected item in the comboBox. Counts and displays score in the scoreArea
         * - Suma elementow - sums all elements in the table
         * - Średnia elementów - average value of all elements in the table
         * - Wartość max i min - the lowest and the highest number in the table
         */

    public void score(){
        String selected = (String) comboBox.getSelectedItem();

        if(selected.equals("Suma elementów")){

            double suma=0;
            String text;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    text = (String)table.getModel().getValueAt( i, j);

                    suma += Double.parseDouble(text);
                }
            }
            //text = String.format("%.0f",suma);
            scoreArea.setText(null);
            scoreArea.append("Suma elementów: "+suma);
        }else if(selected.equals("Średnia elementów")){

            int liczba_elementow=0;
            double srednia=0;
            String text;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    text = (String)table.getModel().getValueAt( i, j);
                    if(!text.equals("0"))
                    {
                        srednia += Double.parseDouble(text);
                        liczba_elementow++;
                    }

                }
            }
            srednia /= liczba_elementow;
            //text = String.format("%.0f",suma);
            scoreArea.setText(null);
            scoreArea.append("Średnia elementów: "+srednia);

        }else if(selected.equals("Wartość max i min")){

            String text, mintext="0", maxtext="0";
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    text = (String)table.getModel().getValueAt( i, j);
                    if(Double.parseDouble(text)<Double.parseDouble(mintext))
                    {
                        mintext = text;
                    }
                    if(Double.parseDouble(text)>Double.parseDouble(maxtext))
                    {
                        maxtext =text;
                    }
                }
            }

            scoreArea.setText(null);
            scoreArea.append("Wartość min: "+mintext+"\n");
            scoreArea.append("Wartość max: "+maxtext);
        }
    }

        /**
         * Sets panel2
         * @param panel2
         */

    public void setPanel(Panel2 panel2){
        this.panel2 = panel2;
    }

}
