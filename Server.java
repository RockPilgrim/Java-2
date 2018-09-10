/**
 * Java-2 Homework-7
 *
 * Class Server
 * Manage clients and resend them/there message
 *
 * @author Timofei Tokarev
 * @version dated 10.09.18
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {

    private Vector<ClientHandler> clients;

    public static void main(String[] args) {
        new Server();
    }

    public Server()
    {
        try
        {
            ServerSocket serv_socket = new ServerSocket(12345);

            clients = new Vector<>();

            while(true){
                System.out.println("Waiting for a new client!");
                Socket socket = serv_socket.accept();

                ClientHandler cl = new ClientHandler(this, socket); //клиент подключился
                add_client(cl); //клиент попал в список клиентов после подключения
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    //добавить клиента в список clients
    public void add_client(ClientHandler client){
        client.sendMsg("You "+Integer.toString(clients.size()+1)+" client\n");
        clients.add(client);
    }

    //удалить клиента из списка clients
    public void remove_client(ClientHandler client){
        clients.remove(client);
    }

    //отослать сообщение всем клиентам сразу
    public void broadcastMsg(String msg){
        for(ClientHandler client: clients){
            client.sendMsg(msg);
        }
    }
    // NEW CODE Send message to concrete client
    public void broadcastMsg(String msg,char num){
        try {
            int index=(Integer.parseInt(String.valueOf(num))-1);
            clients.get(index).sendMsg(msg);
        }catch (NullPointerException e){  // Возможно излишне?
            broadcastMsg("!!!Client not found!!!");
        }catch (NumberFormatException e) {
            broadcastMsg("!!!Client not found!!!");
        }catch (Exception e){
            broadcastMsg("!!! ERROR !!! ");
            e.printStackTrace();
        }
    }
}
