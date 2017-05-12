package try_ddd.try_ddd.dolphingui.javafxnofxml.client;

import javafx.scene.Node;

import java.lang.reflect.Constructor;

/**
 * Created by lucius on 12.05.17.
 */
public class ViewFactory {

    public AbstractView getView(Class viewclass) throws Exception {
        Constructor constructor = viewclass.getConstructor();
        return (AbstractView) constructor.newInstance();
    }

    public Node getNodeOfView(Class viewclass) throws Exception {
        return getView(viewclass).getRoot();
    }
}
