package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainFrame class contains the main frame where are all elements of the program except TOTD class
 */

public class MainFrame extends JFrame {

    private MenuBar menuBar;
    private Panel panel;
    private Dialog dialog;
    private ToolBar toolBar;
    private JButton btn;
    private ButtonBar buttonBar;

    public MainFrame(){
        super("Programowanie Aplikacji");

        setLayout(new BorderLayout());

        menuBar = new MenuBar();
        toolBar = new ToolBar();
        buttonBar = new ButtonBar();
        panel = buttonBar.getPanel();
        btn = new JButton("Dialog");

        /*btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dialog = new Dialog();
            }
        });*/

        /**
         * Checks if toolBar buttons are clicked and activates suitable method
         * @param string of clicked button
         */
        toolBar.setStringListener(new StringListener() {
            public void textEmitted(String i) {
                if(i.equals("ok"))
                {
                    panel.ok();
                }else if(i.equals("zerowanie"))
                {
                    panel.zerowanie();;
                }else if(i.equals("zapis"))
                {
                    panel.zapis();
                }
            }
        });

        /**
         * Checks if menuBar buttons are clicked and activates suitable method
         * @param string of clicked button
         */

        menuBar.setStringListener(new StringListener() {
            public void textEmitted(String i) {
                if(i.equals("ok"))
                {
                    panel.ok();
                }else if(i.equals("zerowanie"))
                {
                    panel.zerowanie();;
                }else if(i.equals("zapis"))
                {
                    panel.zapis();
                }
            }
        });

        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.SOUTH);
        //add(panel, BorderLayout.CENTER);
        add(buttonBar, BorderLayout.NORTH);
        //add(btn, BorderLayout.EAST); used to be dialog test
        
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
