package try_ddd.try_ddd.javafxgui.javafxnofxml;

import try_ddd.try_ddd.javafxgui.javafxnofxml.views.View1;
import try_ddd.try_ddd.javafxgui.javafxnofxml.views.View2;
import javafx.scene.Node;

/**
 * Created by lucius on 12.05.17.
 */
public class ViewFactory {

    public AbstractView getView(Class viewclass){
        if(viewclass.equals(View1.class)) return new View1();
        if(viewclass.equals(View2.class)) return new View2();

        throw new IllegalArgumentException(String.format("%s not supported by %s",viewclass,getClass().getName() ));
    }

    public Node getNodeOfView(Class viewclass){
        return getView(viewclass).getRoot();
    }
}
