import java.io.*;
import java.net.*;
import java.util.*;


public class ProxyServer {
 public Socket insock;
 public Socket outsock;
  public static void main(String[] args) throws IOException {
    int portNumber = 8082;
System.out.println("Server running on 127.0.0.1"+portNumber); 
 
    ServerSocket insock = new ServerSocket(portNumber);
    ServerSocket outsock = new ServerSocket();
    byte buf[] = new byte[bufSize];
    
    Socket client = serverSocket.accept();
    PrintWriter out =
        new PrintWriter(client.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(client.getInputStream()));
        String inputLine="",remoteURL="";
        int cnt=0;
     while((inputLine = in.readLine()) != null) {
        System.out.println(inputLine);
        //StringTokenizer tok = new StringTokenizer(inputLine);
        //tok.nextToken();
        if (cnt == 0) {
        String[] tokens = inputLine.split(" ");
        remoteURL = tokens[1];
          System.out.println(remoteURL);
        }
        cnt ++;
        
    }
     System.out.println("URL open");
    URL url = new URL(remoteURL);
    
                URLConnection conn = url.openConnection();
           System.out.println("URL open");
            
   System.out.println("URL closed");
                    

                conn.setDoInput(true);
                //not doing HTTP posts
                conn.setDoOutput(false);
                InputStream is = null;
                HttpURLConnection huc = (HttpURLConnection)conn;
                if (conn.getContentLength() > 0) {
                    try {
                        is = conn.getInputStream();
                       BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                       System.out.println("Caught stream");
                    
                    } catch (IOException ioe) {
                        System.out.println(
				"********* IO EXCEPTION **********: " + ioe);
                    }
                }
                else
                   System.out.println("No stream");
                    
                //end send request to server, get response from server
                ///////////////////////////////////

                ///////////////////////////////////
                //begin send response to client
                byte by[] = new byte[32768];
                int index = is.read( by, 0, 32768 );
                while ( index != -1 )
                {
                  System.out.write( by, 0, index );
                  index = is.read( by, 0, 32768 );
                }
                System.out.flush();
    }
  }

    