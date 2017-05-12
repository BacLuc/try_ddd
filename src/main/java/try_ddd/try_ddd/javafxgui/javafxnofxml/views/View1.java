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
public class View1 extends AbstractView {
    private Button button;

    public View1(){
        AnchorPane anchor = new AnchorPane(
                button = new Button("clickme")
        );

        button.setOnAction(e -> {
            System.out.println("button clicked");
            testFunction();
        });
        setRoot(anchor);

    }










    public void testFunction(){
        System.out.println("in testfunciton");
        JavaFXMain.setCenterView(new View2().getRoot());
    }

}
