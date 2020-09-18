import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Server 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(3141);
		Socket s = ss.accept();
		
		ThreadHandler1 t = new ThreadHandler1(s);
		t.start();		
	}
}
