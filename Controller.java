/**
 * Java-2 Homework-7
 *
 * Class Control interface interaction
 * Listen action, send and read message
 *
 * @author Timofei Tokarev
 * @version dated 10.09.18
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    @Override
    public void initialize(URL url, ResourceBundle rb){  //при инициализации
        try {
            socket=new Socket("localhost",12345);
            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());

            new Thread(()-> {
                try{
                    while (true){
                        String str= in.readUTF(); // blocking operation
                        TextArea.appendText(str+"\n");
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    public void sendMsg(ActionEvent event) {
        String str=TextField.getText();
        try {
            out.writeUTF(str); // message send to server
            TextField.clear();
            TextField.requestFocus(); // focused
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private TextArea TextArea;

    @FXML
    private TextField TextField;
}
