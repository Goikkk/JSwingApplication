package com.company;

import com.l2fprod.common.swing.JButtonBar;

import javax.swing.*;
import java.awt.*;

/**
 * ButtonBar extends JPanel
 * Contains two main JPanels located in the center of the application
 */

public class ButtonBar extends JPanel {

    private JButtonBar buttonBar;
    private Panel panel;
    private JButton button = new JButton("tests");
    private Panel2 panel2;

    public ButtonBar(){

        setLayout(new BorderLayout());
        buttonBar = new JButtonBar(1);
        panel = new Panel();
        panel2 = new Panel2();

        panel.setPanel(panel2);

       JTabbedPane tabs = new JTabbedPane();
        tabs.add("pierwszy", panel);
        tabs.setPreferredSize(new Dimension(200,393));
        tabs.add("drugi", panel2);

        buttonBar.add(tabs);

        add(buttonBar, BorderLayout.CENTER);

    }

    /**
     * Passes reference to panel located in ButtonBar
     * @return Panel
     */
    public Panel getPanel()
    {
        return this.panel;
    }

}
