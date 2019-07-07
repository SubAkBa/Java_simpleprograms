package ex1;

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

public class ServerThread extends Thread
{
	DataInputStream dis;
	Socket s;
	JTextArea jta;
	String message;
	public ServerThread(JTextArea jta, Socket s)
	{
		this.jta = jta;
		this.s = s;
		try {
			dis = new DataInputStream(s.getInputStream());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run()
	{
		while(true) {
			try {
				message = dis.readUTF();
				jta.append("»ó´ë¹æ : " + message + "\n");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
