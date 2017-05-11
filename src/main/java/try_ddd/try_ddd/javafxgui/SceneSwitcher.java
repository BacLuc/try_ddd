/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package try_ddd.try_ddd.javafxgui;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lucius
 */
public class SceneSwitcher {
    public static final String SCENE_MAIN= "/index.fxml";
    public static final String SCENE_ADD_COPY= "/addcopy.fxml";
    
    
    public static void switchScene(Node node, String newScene){
        Stage stage = (Stage) node.getScene().getWindow();
        URL url = SceneSwitcher.class.getResource(newScene);
        if(url == null){
            throw new IllegalArgumentException(String.format("There is no Ressource named %s", newScene));
        }
        Parent root = null;
        try {
            root = FXMLLoader.load(url);
        } catch (IOException ex) {
            Logger.getLogger(SceneSwitcher.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException(String.format("Ressource %s is invalid", newScene));
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
}
