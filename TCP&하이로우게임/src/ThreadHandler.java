
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class ThreadHandler extends Thread
{
	DataInputStream dis;
	DefaultListModel dlm;
	public ThreadHandler(DataInputStream dis, DefaultListModel dlm)
	{
		this.dlm = dlm;
		this.dis = dis;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				String s = dis.readUTF();
				dlm.addElement("Server : " + s);
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
		}
	}
}
