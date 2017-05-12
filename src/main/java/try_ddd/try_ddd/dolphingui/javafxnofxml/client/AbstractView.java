package try_ddd.try_ddd.dolphingui.javafxnofxml.client;

import javafx.scene.Node;

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
