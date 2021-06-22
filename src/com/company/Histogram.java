package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Histogram extends JPanel
 * Creates chart and contains all methods used on it
 */

public class Histogram extends JPanel{

    private static final String test = "Statystyki tableli";
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public Histogram(){

        setBackground(Color.blue);
        JFreeChart chart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500,200));

        setLayout(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER);
    }

    /**
     * Creates keys for dataset and fills dateset with "0"
     * @return CategoryDataset
     */
    private CategoryDataset createDataset(){
        String key = "";

        for(int i = 0; i<5; i++)
        {
            for(int j = 0; j<5; j++)
            {
                key="[" + (i+1) + "," + (j+1) + "]";
                dataset.addValue(0,test,key);
            }
        }

        return dataset;
    }

    /**
     * Creates chart
     * @param dataset
     * @return JFreeChart
     */

    private static JFreeChart createChart(CategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("Value in the table", "Index", "Value", dataset, PlotOrientation.HORIZONTAL, false, true, false);

        return chart;
    }

    /**
     * Changes data in the chart
     * Used evey time value in add to the table
     * @param d value inserted to table
     * @param x position x
     * @param y position y
     */

    public void changeChart(double d, int x, int y)
    {
        String key = "[" + x + "," + y + "]";
        dataset.setValue(d,test,key);
    }

    /**
     * Resets the chart
     */

    public void clearChart()
    {
        String key = "";
        for(int i = 1; i<6; i++)
        {
            for(int j = 1; j<6; j++)
            {
                key = "[" + i + "," + j + "]";
                dataset.setValue(0,test,key);
            }
        }
    }

}
