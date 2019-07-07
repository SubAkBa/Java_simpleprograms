import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ThreadHandler extends Thread
{
	Money m;
	JLabel lab;
	public ThreadHandler(Money m, JLabel lab)
	{
		this.m = m;
		this.lab = lab;
	}
	public void run()
	{
		while(true)
			m.process(lab);
	}
}
