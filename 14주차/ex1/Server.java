package ex1;

import java.net.*;
import java.io.*;

public class Server extends Thread
{
	HighLow hl = new HighLow();
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	String msg = "", result = "";
	public Server(String ip, String port)
	{
		try {
			ss = new ServerSocket(Integer.parseInt(port));
			s = ss.accept();
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run()
	{
		while(true) {
			try {
				msg = dis.readUTF();
				result = hl.Process(msg);
				
				dos.writeUTF(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
