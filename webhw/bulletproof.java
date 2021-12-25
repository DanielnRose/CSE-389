import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream

public class bulletproof {

  private static final int BUFSIZE = 32;   // Size of receive buffer

  public static void main(String[] args) throws IOException {

    if (args.length != 1)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int servPort = Integer.parseInt(args[0]);

    // Create a server socket to accept client connection requests
    ServerSocket servSock = new ServerSocket(servPort);

    int recvMsgSize;   // Size of received message
    byte[] receiveBuf = new byte[BUFSIZE];  // Receive buffer

	boolean ban = false;
	int num = 0;
	int pos = 0;
	String[] bannedIPs = new String[10];
	String temp = " ";
	String temp2 = "  ";
	String temp3 = "   ";
    while (true) { // Run forever, accepting and servicing connections
      Socket clntSock = servSock.accept();     // Get client connection
	  
	  for (int j = 0; j<=9; j++){
		  if (clntSock.getRemoteSocketAddress().toString().substring(0,10).equals(bannedIPs[j])){
			  ban = true;
			  System.out.println("BAN");
		  }
		  System.out.print(j + bannedIPs[j] + " ");
		 
	  }
	  System.out.println();
	 //  System.out.println(clntSock.getRemoteSocketAddress().toString().substring(0,9));
	  if (ban == false){
		  
	  if(num == 0){ 
		  temp = clntSock.getRemoteSocketAddress().toString().substring(0,10);
		  num++;
		  if (temp.equals(temp2) && temp.equals(temp3)){
			  bannedIPs[pos] = temp;
			  pos++;
		  }
	  }
	  else if (num == 1){
		  temp2 = clntSock.getRemoteSocketAddress().toString().substring(0,10);
		  num++;
		  if (temp2.equals(temp) && temp3.equals(temp2)){
			  bannedIPs[pos] = temp3;
			  pos++;
		  }
	  }
	  else if(num == 2){
		  temp3 = clntSock.getRemoteSocketAddress().toString().substring(0,10);
		  num = 0;
		  if (temp3.equals(temp2) && temp3.equals(temp)){
			  bannedIPs[pos] = temp3;
			  pos++;
		  }
	  }
	  
      SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
      System.out.println("Handling client at " + clientAddress);
      
      InputStream in = clntSock.getInputStream();
      OutputStream out = clntSock.getOutputStream();

      // Receive until client closes connection, indicated by -1 return
      while ((recvMsgSize = in.read(receiveBuf)) != -1) {
        out.write(receiveBuf, 0, recvMsgSize);
      }

      clntSock.close();  // Close the socket.  We are done with this client!
	  }
	  else {
		  clntSock.close();
	  }
	  ban = false;
    }
    /* NOT REACHED */
  }
}
