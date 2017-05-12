package try_ddd.try_ddd.javafxgui.javafxnofxml.views;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import try_ddd.try_ddd.javafxgui.javafxnofxml.AbstractView;
import try_ddd.try_ddd.javafxgui.javafxnofxml.JavaFXMain;

/**
 * Created by lucius on 11.05.17.
 */
public class View2 extends AbstractView {


    public View2(){
        AnchorPane anchor = new AnchorPane(
                new Label("view2")
        );
        setRoot(anchor);

    }



}
