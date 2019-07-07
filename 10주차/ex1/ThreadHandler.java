package ex1;

import java.util.*;
import java.awt.*;
import java.text.*;
import javax.swing.*;

public class ThreadHandler extends Thread
{
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS");
	JLabel lab;
	public ThreadHandler(JLabel lab)
	{
		this.lab = lab;
	}
	public void run()
	{
		while(true)
			lab.setText(sdf.format(new Date()));
	}
}
