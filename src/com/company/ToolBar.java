package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ToolBar extends JToolBar
 * Contains 3 buttons which have the same functions as buttons in Panel class
 * and dialog button which shows information about program
 */

public class ToolBar extends JToolBar {

    private JButton closebtn;
    private JButton dialogbtn;
    private JButton okbtn;
    private JButton zapisbtn;
    private JButton zerowaniebtn;
    JDialog dialog;

    private StringListener stringListener;
    private Panel panel;

    public ToolBar(){

        closebtn = new JButton("Close");
        okbtn = new JButton("Ok");
        zapisbtn = new JButton("Zapis");
        zerowaniebtn = new JButton("Zerowanie");
        dialogbtn = new JButton("Dialog");
        dialog = new JDialog();

        dialog.setLayout(new FlowLayout());

        setLayout(new FlowLayout(FlowLayout.LEFT));

        /**
         * if clicked display dialog
         */

        dialogbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });

        /**
         * if clicked close dialog
         */

        closebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        /**
         * if clicked pass index of button to MainFrame class where it's executed
         */

        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringListener.textEmitted("ok");
                //panel.ok();
            }
        });

        zapisbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringListener.textEmitted("zapis");
            }
        });

        zerowaniebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringListener.textEmitted("zerowanie");
            }
        });

        dialog.add(new JLabel("Autor: Rafał Karwowski\n"));
        dialog.add(new JLabel("Wersja: 2\n"));
        dialog.setSize(200,100);
        dialog.setVisible(false);
        dialog.add(closebtn);
        add(dialogbtn);
        add(okbtn);
        add(zerowaniebtn);
        add(zapisbtn);
    }

    /**
     * sets the StringListener
     * @param listener
     */

    public void setStringListener(StringListener listener){
        this.stringListener = listener;
    }

}
