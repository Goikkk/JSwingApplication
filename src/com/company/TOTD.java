package com.company;

import com.l2fprod.common.swing.JTipOfTheDay;
import com.l2fprod.common.swing.tips.DefaultTip;
import com.l2fprod.common.swing.tips.DefaultTipModel;

import javax.swing.*;
import java.awt.*;

/**
 * TipOfTheDay class
 * Display dialog with tip every time program starts
 */

public class TOTD {

    private JTipOfTheDay tipOfTheDay;

    public TOTD() {

        JDialog d = new JDialog((Frame)null,"Tip of the Day");
        JPanel basic = new JPanel();
        basic.setLayout(new BorderLayout());

        DefaultTipModel model = new DefaultTipModel();

        DefaultTip tip1 = new DefaultTip("tip1","REALY USEFUL TIP :p");
        DefaultTip tip2 = new DefaultTip("tip2","TIP number 2");

        model.add(tip1);
        model.add(tip2);

        tipOfTheDay = new JTipOfTheDay(model);
        basic.add(tipOfTheDay);

        d.add(basic);
        d.add(tipOfTheDay);
        d.setSize(new Dimension(450, 350));
        d.setResizable(false);
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setVisible(true);

    }

}
