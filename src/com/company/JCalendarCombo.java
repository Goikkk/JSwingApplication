package com.company;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

/**
 * JCalendarCombo extends JPanel
 * Here is located: Calendar and text area with current picked date
 */

public class JCalendarCombo extends JPanel {

    private JTextArea textArea;
    private JCalendar calendar;

    public JCalendarCombo(){

        textArea = new JTextArea(20,20);
        textArea.setEnabled(false);
        calendar = new JCalendar();

        /**
         * Every time date is changed text area append new date
         * Format: RRRR-MM-DD
         */
        calendar.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                Date date = calendar.getDate();
                String x = String.format("%1$tY-%1$tm-%1$td",date);

                textArea.setText(null);
                textArea.append(x);
                //textArea.append("Data: "+(calendar.getDate().toString()));
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(calendar, gc);


        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 1;
        add(textArea, gc);

    }

}
