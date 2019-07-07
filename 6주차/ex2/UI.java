package ex2;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UI extends JFrame implements ActionListener
{
	Random ran = new Random();
	int index = ran.nextInt(25)+1;
	Container ct = getContentPane();
	JButton[] btn = new JButton[25];
	public UI()
	{
		for(int i=0;i<25;i++)
		{
			btn[i] = new JButton(String.valueOf(i+1));
			btn[i].setFont(new Font("±¼¸²Ã¼", Font.BOLD, 20));
			btn[i].addActionListener(this);
			ct.add(btn[i]);
		}
		setTitle("Áö·ÚÃ£±â °ÔÀÓ");
		setLayout(new GridLayout(5,5));
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		for(int i=0;i<btn.length;i++)
		{
			if(btn[i].getText().equals(ae.getActionCommand()))
			{
				btn[i].setEnabled(false);
				if(index == i)
					btn[i].setBackground(Color.BLACK);
			}
		}
			
	}
}
