import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.LafManagerListener;
import com.intellij.ide.ui.laf.LafManagerImpl;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AngryProgressBarApplicationComponent implements ApplicationComponent {
    AngryProgressBarApplicationComponent(LafManagerImpl lafManager) {
        lafManager.addLafManagerListener(new LafManagerListener() {
            @Override
            public void lookAndFeelChanged(LafManager lafManager) {
                updateProgressBarUi();
            }
        });
    }

    @Override
    public void initComponent() {
        updateProgressBarUi();
    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "AngryProgressBarUiUpdater";
    }

    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", AngryProgressBarUi.class.getName());
        UIManager.getDefaults().put(AngryProgressBarUi.class.getName(), AngryProgressBarUi.class);
    }
}
