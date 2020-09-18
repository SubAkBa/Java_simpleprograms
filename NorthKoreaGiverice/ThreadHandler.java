import java.util.*;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

class ThreadHandler extends Thread
{
	Riceprocess rp;
	int ricenum;
	JLabel lab;
	public ThreadHandler(Riceprocess rp, JLabel lab)
	{
		this.lab = lab;
		this.rp = rp;
	}
	public void run()
	{
		while(true)
		{
			ricenum = rp.Minusrice();
			lab.setText(Integer.toString(ricenum) + " kg");
			
			try
			{
				sleep(1);
			}
			catch(InterruptedException ie)
			{
				ie.getStackTrace();
			}
		}
	}
}