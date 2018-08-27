/**
 * Java-2 Homework-4
 *
 * Класс "Интерфейс чата"
 *
 * @author Timofei Tokarev
 * @version dated 27.08.18
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class ChatInterface extends Application{

    private static final  int STAGE_WIDTH=300;
    private static final  int STAGE_HEIGHT=300;
    private Button send=new Button();
    int index=0;


    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage stage)throws Exception{

        Parent root=FXMLLoader.load(getClass().getResource("chat_layout.fxml"));
        Scene scene=new Scene(root);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("Telegram Chat");
        stage.show();
    }

    @FXML
    private TextField text_Field;
    @FXML
    private GridPane massage_layout;

    @FXML
    void onClick(ActionEvent event) {
        addToPanel();
    }
    @FXML
    void onEnterText(ActionEvent event) {
        addToPanel();
    }

    private void addToPanel(){
        String textOne=text_Field.getText();
        if (!textOne.isEmpty() && textOne.charAt(0)!=' '){
            Button btn=new Button();
            btn.setText(text_Field.getText());
            massage_layout.add(btn,1,index);
            index++;
            text_Field.setText("");
        }
    }
}

