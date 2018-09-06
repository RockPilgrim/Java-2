/**
 * Java-2 Homework-6
 *
 * Class outbox messeges
 *
 * @author Timofei Tokarev
 * @version dated 06.09.18
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class OutputMessage implements Runnable {

    private Socket socket;

    private PrintStream sendMsg;
    private Scanner scannerOut;



    public OutputMessage(Socket socket)throws IOException {
        this.socket=socket;
        scannerOut=new Scanner(System.in);
        sendMsg=new PrintStream(socket.getOutputStream());
    }

    @Override
    public void run(){
        while (true){
            String stringOut=scannerOut.nextLine();
            sendMsg.println("-> "+stringOut);
            sendMsg.flush();
            if (stringOut.equalsIgnoreCase("end")) // Чат закрывается по взаимному согласию
                break;
        }
    }
}
