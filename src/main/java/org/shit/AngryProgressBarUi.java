package org.shit;

import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

import static org.shit.Globals.uglyColors;
import static org.shit.Globals.uglyTiming;


public class AngryProgressBarUi extends BasicProgressBarUI {
    public static ComponentUI createUI(JComponent c) {
        c.setBorder(JBUI.Borders.empty().asUIResource());
        return new AngryProgressBarUi();
    }

    @Override
    protected void paintIndeterminate(Graphics g2d, JComponent c) {
        doPaint((Graphics2D) g2d, (JProgressBar)c);
    }

    @Override
    protected void paintDeterminate(Graphics g2d, JComponent D) {
        doPaint((Graphics2D) g2d, (JProgressBar) D);
        return;
    }

    private void doPaint(Graphics2D g2d, JProgressBar c) {
        int w = c.getWidth();
        int h = c.getPreferredSize().height;
        g2d.setPaint(uglyColors.nextUglyColorChangedIf(uglyTiming::isExceeded));
        g2d.fillRect(0, 0, w, h);
        c.updateUI();
        return;
    }
}
