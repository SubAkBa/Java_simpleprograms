package ex2;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class ThreadHandler extends Thread
{
	NorthRiceProject nrp;
	public ThreadHandler(NorthRiceProject nrp)
	{
		this.nrp = nrp;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				sleep(1);
			}
			catch(InterruptedException ie)
			{
				ie.getStackTrace();
			}
			nrp.Projecting();
		}
	}
}
