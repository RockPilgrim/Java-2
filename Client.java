/**
 * Java-2 Homework-7
 *
 * Class Client realize
 * Realize client interface
 *
 * @author Timofei Tokarev
 * @version dated 10.09.18
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {

    @Override
    public void start(Stage stage)throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("Chat_interface.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Small horse chat");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
