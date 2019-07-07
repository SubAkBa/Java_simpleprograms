package ex1;

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

public class ClientThread extends Thread
{
	byte[] buffer;
	DatagramPacket dp;
	DatagramSocket ds;
	JTextArea jta;
	String message;
	public ClientThread(JTextArea jta, DatagramSocket ds)
	{
		this.jta = jta;
		this.ds = ds;
	}
	public void run()
	{
		while(true) {
			try {
				buffer = new byte[256];
				dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp);
				message = new String(dp.getData());
				jta.append("»ó´ë¹æ : " + message + "\n");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
