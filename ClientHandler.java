/**
 * Java-2 Homework-7
 *
 * Class Client Handler
 * Handle client, help to server
 * manage message and work with many clients(not only one)
 *
 * @author Timofei Tokarev
 * @version dated 10.09.18
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    //Служебный класс, которому сервер передаст сокет
    //По сокету будет происходить общение с подключившимся клиентом

    private Server server; //ссылка на сервер для клиента
    private Socket socket;
    private DataInputStream  in; //поток ввода, используется UTF-кодировка
    private DataOutputStream out;//поток вывода, используется UTF-кодировка

    public ClientHandler(Server server, Socket socket)
    {
        try{
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(()-> {
                try{
                    while(true){
                        String str = in.readUTF();//блокирующая операция!!! Читаем то, что пришло от клиента
                        System.out.println("A message from a client: " + str);

                        if(str.contentEquals("/end")){
                            break;
                        }
                        if (str.charAt(0)=='/' && str.charAt(1)=='w'){    /// NEW CODE Check message
                             str=str.replace("/w ","");  // Change message to new version
                            sendMsg("-> "+str);
                            server.broadcastMsg("<- "+str,str.charAt(0));
                        }else
                            server.broadcastMsg(str);//Cервер разослал сообщение String str = in.readUTF() ВСЕМ подключенным клиентам
                        out.flush();
                    }
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
                finally//освобождаем ресурсы
                {
                    try
                    {
                        in.close();
                        //out.close();   //в отдельный блок try - catch
                        //socket.close();//в отдельный блок try - catch
                    }
                    catch(IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    try
                    {
                        out.close();
                    }
                    catch(IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    try
                    {
                        socket.close();
                    }
                    catch(IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    server.remove_client(this);//Клиент отключился и больше не активен
                }//finally
            }).start();

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }//public ClientHandler

    //если нужно послать сообщение клиенту
    public void sendMsg(String msg)
    {
        try
        {
            out.writeUTF(msg);//отослать сообщение клиенту
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}//class ClientHandler
