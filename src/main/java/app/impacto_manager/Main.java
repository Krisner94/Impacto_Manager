package app.impacto_manager;

import app.impacto_manager.stage.StageReadyEvent;
import app.impacto_manager.util.theme.ThemeConfig;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class Main extends Application {
    private ConfigurableApplicationContext context;

    private ConfigurableApplicationContext initContext() {
        return new SpringApplicationBuilder()
                .sources(ImpactoManagerApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void init(){
        context = initContext();
    }

    @Override
    public void start(Stage stage){
        ThemeConfig.LightTheme();
        this.context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop(){
        this.context.stop();
        Platform.exit();
    }
}
