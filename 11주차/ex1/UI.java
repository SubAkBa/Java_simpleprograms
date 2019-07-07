package ex1;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class UI extends JFrame implements ActionListener
{
	DecimalFormat f = new DecimalFormat("#.###");
	Container ct = getContentPane();
	JLabel birth = new JLabel("생년월일");
	JLabel[] per = {new JLabel("신체지수"), new JLabel("감성지수"), new JLabel("지성지수")};
	JTextField jtf = new JTextField();
	JButton btn = new JButton("실행");
	JLabel[] lab = new JLabel[3];
	BioRhythm br = new BioRhythm();
	ThreadHandler[] t = {new ThreadHandler(br, "body"), 
			new ThreadHandler(br, "sense"), new ThreadHandler(br, "intel")};
	public UI()
	{
		setTitle("바이오리듬 : 멀티 스레드");
		setLayout(new GridLayout(3,3));
		setSize(300, 120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.add(birth);
		birth.setHorizontalAlignment(JLabel.CENTER);
		ct.add(jtf);
		ct.add(btn);
		btn.addActionListener(this);
		for(int i=0;i<3;i++)
		{
			per[i].setHorizontalAlignment(JLabel.CENTER);
			ct.add(per[i]);
		}
		for(int i=0;i<3;i++)
		{
			lab[i] = new JLabel();
			ct.add(lab[i]);
			lab[i].setHorizontalAlignment(JLabel.CENTER);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		br.SetBirth(jtf.getText());
		for(int i=0;i<3;i++)
			t[i].start();
		
		for(int i=0;i<3;i++)
		{
			try 
			{
				t[i].join();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		for(int i=0;i<3;i++)
			lab[i].setText(f.format(br.GetIndexnum(i)));
		
	}
}
