package try_ddd.try_ddd.dolphingui.javafxnofxml.combined;

import javafx.application.Application;
import org.opendolphin.core.client.comm.JavaFXUiThreadHandler;
import org.opendolphin.core.comm.DefaultInMemoryConfig;
import org.opendolphin.core.server.ServerDolphin;
import try_ddd.try_ddd.dolphingui.javafxnofxml.client.JavaFXApplication;
import try_ddd.try_ddd.dolphingui.javafxnofxml.server.TutorialAction;


/**
 * Created by lucius on 12.05.17.
 */
public class ApplicationStarter {


    private static void addServerSideAction(final ServerDolphin config) {
        config.register(new TutorialAction());
    }

    public static void main(String[] args) throws Exception {
        DefaultInMemoryConfig config = new DefaultInMemoryConfig();
        config.getServerDolphin().registerDefaultActions();
        config.getClientDolphin().getClientConnector().setUiThreadHandler(new JavaFXUiThreadHandler());
        addServerSideAction(config.getServerDolphin());
        JavaFXApplication.clientDolphin = config.getClientDolphin();
        Application.launch(JavaFXApplication.class);
    }
}
