package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MenuBar extends JMenuBar
 * Contains 3 buttons which have the same functions as buttons in Panel class
 */

public class MenuBar extends JMenuBar {

    JMenu menu;
    JMenuItem okItem,zapisItem,zerowanieItem;
    private StringListener stringListener;

    public MenuBar(){

        menu = new JMenu("Menu");
        okItem  = new JMenuItem("Ok");
        zerowanieItem = new JMenuItem("Zerowanie");
        zapisItem = new JMenuItem("Zapis");

        /**
         * if clicked pass index of button to MainFrame class where it's executed
         */

        okItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringListener.textEmitted("ok");
            }
        });

        zerowanieItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringListener.textEmitted("zerowanie");
            }
        });

        zapisItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringListener.textEmitted("zapis");
            }
        });

        menu.add(okItem);
        menu.add(zerowanieItem);
        menu.add(zapisItem);
        add(menu);
    }

    /**
     * sets the StringListener
     * @param listener
     */

    public void setStringListener(StringListener listener){
        this.stringListener = listener;
    }
}
