/**
 * Java-2 Homework-6
 *
 * Class client part
 *
 * @author Timofei Tokarev
 * @version dated 06.09.18
 */

import java.io.IOException;
import java.net.Socket;

public class ClientChat {
    private final String SERVER_ADDR="localhost";
    private Socket socket;

    private InputMessage input;
    private OutputMessage output;


    public static void main(String[] args) {
        new ClientChat();
    }

    ClientChat(){
        try {
            socket=new Socket(SERVER_ADDR,ServerChat.SERVER_PORT);

            input=new InputMessage(socket);
            output=new OutputMessage(socket);
            new Thread(input).start();
            new Thread(output).start();

        }catch (IOException e){
            System.out.println("Cannot connect to server");
        }
    }
}


