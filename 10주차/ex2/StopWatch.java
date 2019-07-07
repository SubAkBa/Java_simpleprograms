package ex2;

import java.awt.*;
import javax.swing.*;

public class StopWatch 
{
	int count = 60;
	boolean a = false;
	JLabel lab;
	public StopWatch(JLabel lab)
	{
		this.lab = lab;
	}
	synchronized public void Process()
	{
		if(a == true)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ie)
			{
				ie.getStackTrace();
			}
		}
		lab.setText(count + " √ ");
		count--;
		if(count == -1)
			a = true;
		
		try
		{
			Thread.sleep(100);
		}
		catch(InterruptedException ie)
		{
			ie.getStackTrace();
		}
	}
	synchronized public void StartTimer()
	{
		if(count > -1)
		{
			notifyAll();
			a = false;
		}
	}
	public void StopTimer()
	{
		a = true;
	}
	public void ResetTimer()
	{
		a = false;
		count = 60;
		lab.setText(count + " √ ");
	}
}
