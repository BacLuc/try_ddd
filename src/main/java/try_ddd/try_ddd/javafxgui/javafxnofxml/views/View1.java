package try_ddd.try_ddd.javafxgui.javafxnofxml.views;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import try_ddd.try_ddd.javafxgui.javafxnofxml.JavaFXMain;


/**
 * Created by lucius on 11.05.17.
 */
public class View1 {
    private static Button button;
    public static Node getNode(){
        AnchorPane anchor = new AnchorPane(
                button = new Button("clickme")
        );

        button.setOnAction(e -> {
            System.out.println("button clicked");
            testFunction();
        });



        return anchor;


    }


    public static void testFunction(){
        System.out.println("in testfunciton");
        JavaFXMain.setCenterView(View2.getNode());
    }

}
