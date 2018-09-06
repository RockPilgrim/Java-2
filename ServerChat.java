/**
 * Java-2 Homework-6
 *
 * Class server part
 *
 * @author Timofei Tokarev
 * @version dated 06.09.18
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {

    public static final int SERVER_PORT=8814;
    private ServerSocket servSoc;
    private Socket socket;

    private InputMessage input;
    private OutputMessage output;

    public static void main(String[] args) {
        new ServerChat();
    }

    public ServerChat(){
        try {
            servSoc=new ServerSocket(SERVER_PORT);
            System.out.println("Waiting...");
            socket=servSoc.accept();
            System.out.println("We have a client.");

            PrintStream pw=new PrintStream(socket.getOutputStream());
            pw.println("Connected"); // Сообщает клиенту о подключении

            input=new InputMessage(socket);
            output=new OutputMessage(socket);
            new Thread(input).start();
            new Thread(output).start();

        }catch (IOException e){
            System.out.println("Something go wrong.\nCheck server port/");
        }
    }
}
