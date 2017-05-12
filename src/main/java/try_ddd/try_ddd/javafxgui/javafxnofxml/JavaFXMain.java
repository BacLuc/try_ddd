/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package try_ddd.try_ddd.javafxgui.javafxnofxml;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import try_ddd.try_ddd.javafxgui.javafxnofxml.views.View1;
import try_ddd.try_ddd.javafxgui.javafxnofxml.views.View2;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lucius
 */
public class JavaFXMain extends Application {
    private MenuBar menuBar;
    private Map<Menu,List<MenuItem>> itemList;
    private static BorderPane root;
    
    @Override
    public void start(Stage stage) throws Exception {

        root = new BorderPane();
    
        Scene scene = new Scene(root, 400, 400);

        menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        root.setTop(menuBar);


        ViewFactory factory = new ViewFactory();

        Node startNode;

        menuBar.getMenus().addAll(
                new Menu("Menu1", null,
                        newNodeMenuItem("View1", startNode = factory.getNodeOfView(View1.class))
                        , newNodeMenuItem("View2", factory.getNodeOfView(View2.class))
                        )



        );



        setCenterView(startNode);


    
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public static void setCenterView(Node node){
        root.setCenter(node);
    }

    public MenuItem newNodeMenuItem(String name, Node node){
        MenuItem menuItem = new MenuItem(name);
        menuItem.setOnAction(e -> setCenterView(node));
        return menuItem;
    }
 public static void main(String[] args) {
         Application.launch(JavaFXMain.class, args);
    }

}