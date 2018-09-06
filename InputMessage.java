/**
 * Java-2 Homework-6
 *
 * Class inbox messeges
 *
 * @author Timofei Tokarev
 * @version dated 06.09.18
 */

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class InputMessage implements Runnable {

    private Socket socket;
    private Scanner scannerIn;

    public InputMessage(Socket socket)throws IOException {
        this.socket=socket;
        scannerIn=new Scanner(socket.getInputStream());
    }

    @Override
    public void run(){
        while (true){
            String stringIn=scannerIn.nextLine();
            if (stringIn.equalsIgnoreCase("-> end")){  // Чат закрывается по взаимному согласию
                System.out.println("-> Bye.");
                break;
            }
            System.out.println(stringIn);
        }
    }
}
