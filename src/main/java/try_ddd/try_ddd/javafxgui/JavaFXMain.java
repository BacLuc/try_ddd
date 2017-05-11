/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package try_ddd.try_ddd.javafxgui;

import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author lucius
 */
public class JavaFXMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
        URL url = getClass().getResource("/index.fxml");
        
        Parent root = FXMLLoader.load(url);
    
        Scene scene = new Scene(root, 400, 400);
        
    
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }
 public static void main(String[] args) {
         Application.launch(JavaFXMain.class, args);
    }

}