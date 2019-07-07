package ex2;

import javax.swing.*;
import java.awt.*;

public class NorthRiceProject 
{
	int rice = -1;
	JLabel kg;
	synchronized public void SettingRice(String rice, JLabel kg)
	{
		this.kg = kg;
		if(this.rice == 0)
			notify();
		this.rice += Integer.parseInt(rice);
	}
	synchronized public void Projecting()
	{
		if(rice == 0)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.getStackTrace();
			}
		}
		rice--;
		kg.setText(String.valueOf(rice) + " kg");
	}
}
