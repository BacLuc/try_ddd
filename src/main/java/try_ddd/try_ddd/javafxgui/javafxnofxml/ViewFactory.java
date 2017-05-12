package try_ddd.try_ddd.javafxgui.javafxnofxml;

import try_ddd.try_ddd.javafxgui.javafxnofxml.views.View1;
import try_ddd.try_ddd.javafxgui.javafxnofxml.views.View2;
import javafx.scene.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
