
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

public class UI extends JFrame
{
	Container ct = getContentPane();
	JPanel[][] pan = null;
	
	public UI(int num)
	{
		setTitle("별찍기 응용");
		setSize(300,400);
		setLayout(new GridLayout(num,2*num-1,5,5));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan = new JPanel[num][2*num-1];
		
		for(int i=0;i<pan.length;i++)
		{
			for(int j=0;j<pan[0].length;j++)
			{
				pan[i][j] = new JPanel();
				pan[i][j].setBackground(Color.WHITE);
				ct.add(pan[i][j]);
			}
			for(int k=i;k<2*pan.length-i-1;k++)
				pan[i][k].setBackground(Color.BLACK);
		}
		
	}
}