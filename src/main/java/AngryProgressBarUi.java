import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class AngryProgressBarUi extends BasicProgressBarUI {
    UglyColors uglyColors = new UglyColors();
    UglyTiming uglyTiming = new UglyTiming();

    public static ComponentUI createUI(JComponent c) {
        c.setBorder(JBUI.Borders.empty().asUIResource());
        return new AngryProgressBarUi();
    }

    @Override
    protected void paintIndeterminate(Graphics g2d, JComponent c) {
        int w = progressBar.getWidth();
        int h = progressBar.getPreferredSize().height;
        Graphics2D g = (Graphics2D) g2d;
        g.setColor(uglyColors.nextUglyColorChanedIf(uglyTiming::isExceeded));
        g.fillRect(0, 0, w, h);
        return;
    }

    @Override
    protected void paintDeterminate(Graphics g2d, JComponent c) {
        int w = progressBar.getWidth();
        int h = progressBar.getPreferredSize().height;
        Graphics2D g = (Graphics2D) g2d;
        g.setColor(uglyColors.nextUglyColorChanedIf(uglyTiming::isExceeded));
        g.fillRect(0, 0, w, h);
        return;
    }
}
