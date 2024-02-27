package app.impacto_manager;

import app.impacto_manager.stage.StageReadyEvent;
import app.impacto_manager.util.theme.ThemeConfigUtils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFXMain extends Application {
    public static ConfigurableApplicationContext context;

    private ConfigurableApplicationContext initContext() {
        return new SpringApplicationBuilder()
                .sources(ImpactoManagerApplication.class)
                .initializers(new JpaInitializer())
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    private static class JpaInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            applicationContext.registerShutdownHook();
        }
    }

    @Override
    public void init(){
        context = initContext();
    }

    @Override
    public void start(Stage stage){
        ThemeConfigUtils.LightTheme();
        this.context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop(){
        this.context.stop();
        Platform.exit();
    }
}
