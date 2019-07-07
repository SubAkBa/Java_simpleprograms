package ex1;

import java.awt.*;
import javax.swing.*;

public class ThreadHandler extends Thread
{
	HighLow hl;
	int result;
	JTextArea jta;
	JLabel count;
	
	public ThreadHandler(HighLow hl, JTextArea jta, JLabel count)
	{
		this.jta = jta;
		this.count = count;
		this.hl = hl;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ie)
			{
				ie.getStackTrace();
			}
			result = hl.GameProcess();
			jta.append(hl.ResultFunc() + "\n");
			count.setText("½Ãµµ È½¼ö : " + hl.Counting());
			if(result == 0)
				break;
		}
	}
}
