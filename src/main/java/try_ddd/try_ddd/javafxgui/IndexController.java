/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package try_ddd.try_ddd.javafxgui;

 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
/**
 *
 * @author lucius
 */
public class IndexController {
    
    @FXML private Button manageBorrow;
    
    @FXML private Text label = new Text("test");
    
    @FXML protected void openAddCopy(ActionEvent event) {
        SceneSwitcher.switchScene(manageBorrow, SceneSwitcher.SCENE_ADD_COPY);
    }
    
    @FXML protected void openManageBorrows(ActionEvent event) {
    }
    @FXML protected void openManageComics(ActionEvent event) {
    }
    @FXML protected void openManageFriends(ActionEvent event) {
    }
    
    
}
