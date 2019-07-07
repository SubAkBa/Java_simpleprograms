import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CountryMoney 
{
	int[] cmoney = {0, 0, 0, 0};
	boolean b = true;
	JLabel[] lab;
	int complete;
	String sentence = "money :";
	public CountryMoney(JLabel[] lab)
	{
		this.lab = lab;
	}
	synchronized public void SetStatement(String total)
	{
		notifyAll();
		b = true;
		Arrays.fill(cmoney, 0);
		complete = Integer.parseInt(total);
	}
	synchronized public void Process(String name)
	{
		if(b == false)
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
		
		switch(name)
		{
		case "Korea":
			cmoney[0]++;
			lab[0].setText(name + " " + sentence + " " + cmoney[0]);
			break;
		case "Japan":
			cmoney[1]++;
			lab[1].setText(name + " " + sentence + " " + cmoney[1]);
			break;
		case "China":
			cmoney[2]++;
			lab[2].setText(name + " " + sentence + " " + cmoney[2]);
			break;
		}
		
		cmoney[3]++;
		lab[3].setText(name + " " + sentence + " " + cmoney[3]);
		
		if(cmoney[3] == complete)
			b = false;
	}
}
