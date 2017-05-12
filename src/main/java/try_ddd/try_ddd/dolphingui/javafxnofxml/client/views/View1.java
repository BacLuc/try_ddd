package try_ddd.try_ddd.dolphingui.javafxnofxml.client.views;

import groovy.lang.Closure;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.opendolphin.binding.JFXBinder;
import org.opendolphin.core.PresentationModel;
import org.opendolphin.core.Tag;
import org.opendolphin.core.client.ClientAttribute;
import org.opendolphin.core.client.ClientPresentationModel;
import org.opendolphin.core.client.comm.OnFinishedHandlerAdapter;
import try_ddd.try_ddd.dolphingui.javafxnofxml.client.AbstractView;
import try_ddd.try_ddd.dolphingui.javafxnofxml.client.JavaFXApplication;


import static try_ddd.try_ddd.dolphingui.javafxnofxml.shared.TutorialConstants.*;

import java.util.List;


/**
 * Created by lucius on 11.05.17.
 */
public class View1 extends AbstractView {
    private Button button;
    private TextField textField;

    private CheckBox status;


    private PresentationModel textAttributeModel;



    public View1(){
        Pane anchor = new Pane(
                new VBox(
                    button = new Button("clickme")
                    ,textField = new TextField()
                    ,new HBox(
                            new Label("Is dirty ?")
                            ,status = new CheckBox()

                    )
                )
        );

        status.setDisable(true);



        setRoot(anchor);

        textAttributeModel = JavaFXApplication.getClientDolphin().presentationModel(PM_PERSON, new ClientAttribute(ATT_FIRSTNAME, "", null, Tag.VALUE));


        setupBinding();


        addClientSideActions();






    }

    private void setupBinding() {
        JFXBinder.bind("text").of(textField).to(ATT_FIRSTNAME).of(textAttributeModel);
        JFXBinder.bindInfo("dirty").of(textAttributeModel).to("selected").of(status);

        Closure converter = new Closure(null) {
            @SuppressWarnings("unused")
            protected Object doCall(boolean dirtyState) {
                return !dirtyState;
            }
        };
        JFXBinder.bindInfo("dirty").of(textAttributeModel).using(converter).to("disabled").of(button);
    }


    private void addClientSideActions(){
        button.setOnAction(event ->{
                System.out.println("button clicked");
                testFunction();


                JavaFXApplication.getClientDolphin().send(CMD_LOG, new OnFinishedHandlerAdapter() {
                    @Override
                    public void onFinished(List<ClientPresentationModel> presentationModels) {
                        textAttributeModel.getAt(ATT_FIRSTNAME).rebase();
                    }
                });
            }
        );
    }










    public void testFunction(){
        System.out.println("in testfunciton");
    }

}
