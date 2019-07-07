package ex2;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Roulette 
{
	boolean b = true;
	JLabel totaljl, getjl;
	int count = 1;
	int[] answer;
	int change = 0, total = 0;
	int[] num = {0, 0, 0, 0};
	String[] row = new String[6];
	Random ran = new Random();
	synchronized public void Settings(int[] answer, JLabel totaljl, JLabel getjl, String input)
	{
		b = true;
		notify();
		this.answer = answer;
		this.totaljl = totaljl;
		this.getjl = getjl;
		change = Integer.parseInt(input);
		total += change;
	}
	synchronized public String[] Process()
	{
		if(b == false)
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
		change -= 100;
		total -= 100;
		row[0] = String.valueOf(count++);
		for(int i=0;i<4;i++)
		{
			num[i] = ran.nextInt(10) + 1;
			row[i+1] = String.valueOf(num[i]);
		}
		row[5] = String.valueOf(total);
		
		Confirm();
		
		return row;
	}
	private void Confirm()
	{
		if(Arrays.equals(answer, num))
		{
			b = false;
			total += 1000000;
			totaljl.setText(change + "¿øÀÌ ³²À½");
			getjl.setText(total + "¿øÀ» È¹µæ ÇÏ¼Ì½À´Ï´Ù.");
		}
		if(change == 0)
		{
			b = false;
			totaljl.setText(change + "¿øÀÌ ³²À½");
			getjl.setText(total + "¿øÀ» È¹µæ ÇÏ¼Ì½À´Ï´Ù.");
		}
	}
}
