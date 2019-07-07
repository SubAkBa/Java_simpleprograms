
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.util.Arrays;

public class UI extends JFrame
{
	final int Ucount = 3;
	Container ct = getContentPane();
	JPanel[] pan = {new JPanel(),new JPanel(),new JPanel()};
	JButton[] btn = new JButton[9];
	int bcount = 0;
	
	public UI()
	{
		setTitle("자바 실습");
		setSize(300,300);
		setLayout(new GridLayout(3,1));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan[0].setLayout(new FlowLayout());
		pan[1].setLayout(new GridLayout(1,3));
		pan[2].setLayout(new BorderLayout());
		
		for(int i=0;i<Ucount;i++)
		{
			for(int j=0;j<Ucount;j++)
			{
				btn[bcount++] = new JButton(String.valueOf(bcount));
				if(i != Ucount-1)
					pan[i].add(btn[bcount-1]);
			}
		}
		pan[2].add(btn[6], BorderLayout.WEST);
		pan[2].add(btn[7], BorderLayout.CENTER);
		pan[2].add(btn[8], BorderLayout.EAST);

		for(int i=0;i<3;i++)
			ct.add(pan[i]);
	}
}
