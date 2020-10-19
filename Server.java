/*
    P15/1213/2018
*/
//Libraries needed for communication
/*
The client will connect to the server. It will also terminate the server connection using a command StopConn
*/
import java.net.*;
import java.io.*;
public class Server {
   //socket and input streams are initialized to null 
    private Socket socket = null;   // responsible for establishing socket connections; 
    private ServerSocket server = null;      // server variable 
    private DataInputStream input = null;   //Responsible for transmitting data to the server
    // The server constructor that takes the port number
    public Server(int portAddress) 
    { 
        // starts server and waits for client connection 
        try
        { 
            server = new ServerSocket(portAddress); // connection created
            System.out.println("Server started"); 
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept();   // accept incoming client connection
            System.out.println("Client accepted"); 
  
            // takes input from the client socket 
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //Reads the input from the client 
  
            String value = ""; 
  
            // reads message from client until "StopConn" is sent 
            while (!value.equals("StopConn")) 
            { 
                try
                { 
                    value = input.readUTF(); // Read in UTF format
                    System.out.println(value); 
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            } 
            System.out.println("Closing connection"); 
  
            // close serve connection 
            socket.close(); 
            input.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
    public static void main(String args[]) 
    { 
        int port = 8920;
        Server server = new Server(port); 
    }
}

