package ex2;

import java.net.*;
import java.io.*;

public class Server extends Thread
{
	int idx;
	Calculator cal = new Calculator();
	byte[] buffer, buffer1;
	String msg, result;
	DatagramSocket ds;
	DatagramPacket dp, dp1;
	InetAddress ia;
	public Server(String ip, String port)
	{
		try {
			ds = new DatagramSocket(Integer.parseInt(port));
			ia = InetAddress.getByName(ip);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run()
	{
		while(true)
		{
			try {
				idx = 0;
				buffer = new byte[] {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
				dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp);
				while(buffer[idx] != ' ')
					idx++;
				msg = new String(dp.getData()).substring(0, idx);
				
				buffer1 = cal.Process(msg).getBytes();
				dp1 = new DatagramPacket(buffer1, buffer1.length, ia, 8888);
				ds.send(dp1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
