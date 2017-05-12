package try_ddd.try_ddd.javafxgui.javafxnofxml.views;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.opendolphin.binding.JFXBinder;
import org.opendolphin.core.PresentationModel;
import org.opendolphin.core.Tag;
import org.opendolphin.core.client.ClientAttribute;
import org.opendolphin.core.comm.Command;
import org.opendolphin.core.comm.NamedCommand;
import org.opendolphin.core.server.comm.NamedCommandHandler;
import try_ddd.try_ddd.javafxgui.javafxnofxml.AbstractView;
import try_ddd.try_ddd.javafxgui.javafxnofxml.JavaFXMain;

import java.util.List;


/**
 * Created by lucius on 11.05.17.
 */
public class View1 extends AbstractView {
    private Button button;
    private TextField field;

    public View1(){
        Pane anchor = new Pane(
                new VBox(
                    button = new Button("clickme"),
                    field = new TextField()
                )
        );



        setRoot(anchor);

        PresentationModel input = JavaFXMain.getClientDolphin().presentationModel("input", new ClientAttribute("text", null, null, Tag.VALUE));

        JFXBinder.bind("text").of(field).to("text").of(input);


        JavaFXMain.getServerDolphin().action("PrintText", new NamedCommandHandler() {
            @Override
            public void handleCommand(NamedCommand command, List<Command> response) {
                Object text = JavaFXMain.getServerDolphin().getAt("input").getAt("text").getValue();
                System.out.println("server text field contains: " + text);
            }
        });

        addActions();






    }


    private void addActions(){
        button.setOnAction(event ->{
                System.out.println("button clicked");
                testFunction();
                JavaFXMain.getClientDolphin().send("PrintText");
            }
        );
    }










    public void testFunction(){
        System.out.println("in testfunciton");
    }

}
