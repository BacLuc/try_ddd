package try_ddd.try_ddd.dolphingui.javafxnofxml.client.views;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import try_ddd.try_ddd.dolphingui.javafxnofxml.client.AbstractView;

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
