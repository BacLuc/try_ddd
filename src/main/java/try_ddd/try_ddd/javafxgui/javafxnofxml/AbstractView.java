package try_ddd.try_ddd.javafxgui.javafxnofxml;

import javafx.scene.Node;
import try_ddd.try_ddd.javafxgui.javafxnofxml.views.View1;

/**
 * Created by lucius on 12.05.17.
 */
public abstract class AbstractView {

    private Node root;



    public Node getRoot(){
        return this.root;


    }

    public AbstractView setRoot(Node root){
        this.root = root;
        return this;
    }
}
