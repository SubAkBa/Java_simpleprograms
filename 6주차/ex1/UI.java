package ex1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UI extends JFrame
{
	Container ct = getContentPane();
	JList jl = new JList();
	JTextField jtf = new JTextField();
	JPanel[] pan = new JPanel[2];
	JButton[] btn = new JButton[20];
	String[] str = {"+", "-", "*", "/", "7", "8", "9", "%", "4", "5", "6", "(",
			"1", "2", "3", ")", "0", ".", "=", "<-"};
	public UI()
	{
		for(int i=0;i<pan.length;i++)
			pan[i] = new JPanel();
		pan[0].setLayout(new BorderLayout());
		pan[1].setLayout(new GridLayout(5,4,5,5));
		
		pan[0].add(jl, BorderLayout.CENTER);
		pan[0].add(jtf, BorderLayout.SOUTH);
		
		for(int i=0;i<btn.length;i++)
		{
			btn[i] = new JButton(str[i]);
			btn[i].setFont(new Font("굴림체", Font.BOLD, 20));
			pan[1].add(btn[i]);
		}
		
		ct.add(pan[0]);
		ct.add(pan[1]);
		setTitle("계산기");
		setLayout(new GridLayout(2,1));
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
