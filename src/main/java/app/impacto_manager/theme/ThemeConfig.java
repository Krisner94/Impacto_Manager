package app.impacto_manager.theme;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;

public class ThemeConfig {
    public static void DarkTheme(){
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
    }

    public static void LightTheme(){
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
    }
}
