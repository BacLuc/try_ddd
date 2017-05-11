package try_ddd.try_ddd.javafxgui.javafxnofxml.views;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Created by lucius on 11.05.17.
 */
public class View2 {
    public static Node getNode(){
        AnchorPane anchor = new AnchorPane(
                new Label("view2")
        );
        return anchor;
    }

}
