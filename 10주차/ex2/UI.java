package ex2;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UI extends JFrame implements ActionListener
{
	boolean a = false;
	Container ct = getContentPane();
	JButton[] btn = new JButton[3];
	JLabel lab = new JLabel();
	JPanel pan = new JPanel();
	StopWatch sw = new StopWatch(lab);
	ThreadHandler t = new ThreadHandler(sw);
	String[] str = {"시작", "정지", "리셋"};
	public UI()
	{
		setTitle("스톱 워치");
		setSize(250, 150);
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lab.setHorizontalAlignment(JLabel.CENTER);
		lab.setFont(new Font("굴림체", Font.BOLD, 25));
		
		pan.setLayout(new GridLayout(1,3));
		for(int i=0;i<3;i++)
		{
			btn[i] = new JButton(str[i]);
			pan.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		ct.add(lab, BorderLayout.CENTER);
		ct.add(pan, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "시작":
			btn[0].setEnabled(false);
			if(a == false)
			{
				t.start();
				a = true;
			}
			sw.StartTimer();
			break;
		case "정지":
			btn[0].setEnabled(true);
			sw.StopTimer();
			break;
		case "리셋":
			sw.ResetTimer();
			break;
		}
	}
}
