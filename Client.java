/*
    P15/1213/2018
*/
//Libraries needed for communication
/*
The client will connect to the server. It will also terminate the server connection using a command StopConn
*/
import java.net.*;
import java.io.*;
public class Client {
    //socket and input streams are initialized to null
    private Socket socket = null;   // responsible for establishing socket connections
    private DataInputStream input = null;   //Responsible for transmitting data to the client
    private DataOutputStream output = null;    // Outputting data from the clent
    
    // Class constructor
    public Client(String ipAddress, int portAddress){
        //try to establish a connection and catch exceptions
        try{
            socket = new Socket(ipAddress,portAddress);     //connection
            System.out.println("Connected");
            input = new DataInputStream(System.in);         //input from the user during runtime
            output = new DataOutputStream(socket.getOutputStream());    //send data to the socket
        }
        // exception for unknown host
        catch(UnknownHostException u){
            System.out.println(u);
        }
        // IO exception
        catch(IOException i){
            System.out.println(i);
        }
        String value = "";
        // keep reading until "StopConn" is input
        while(!value.equals("StopConn")){
            //Eception handling 
            try{
                value = input.readLine();
                output.writeUTF(value);     //outputs in UTF format
            }
            catch(IOException i){
                System.out.println(i);
            }
        }
        // Termination of the connection
        try{
            input.close();
            output.close();
            socket.close();
        }
        catch(IOException i){
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        String ip = "127.0.0.1";
        int port = 8920;
        Client client = new Client(ip,port);
    }
}
