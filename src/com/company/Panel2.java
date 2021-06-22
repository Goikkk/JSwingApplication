package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Panel2 extends JPanel
 * Here is located: calendar and chart
 */

public class Panel2 extends JPanel {

    private JCalendarCombo calendarCombo;
    private Histogram histogram;

    public Panel2(){

        calendarCombo = new JCalendarCombo();
        histogram = new Histogram();

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0.3;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.gridy = 0;
        add(calendarCombo, gc);

        gc.weightx = 20;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 2;
        gc.fill = GridBagConstraints.BOTH;
        add(histogram, gc);

    }

    /**
     * Directs value which was inserted to table to Histogram where it's inserted to chart
     * @param d value inserted to table
     * @param x position x
     * @param y position y
     */

    public void changeChartPanel(double d, int x, int y)
    {
        histogram.changeChart(d,x,y);
    }

    /**
     * Directs ask for clearing chart to Histogram
     */

    public void clearChartPanel() {histogram.clearChart();}

}
