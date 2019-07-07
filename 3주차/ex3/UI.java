
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

public class UI extends JFrame
{
	Container ct = getContentPane();
	JTextField[] jtf = {new JTextField("투입 금액"),new JTextField("반환 금액")};
	JButton[] btn = new JButton[4];
	String[] str = {"콜라(1000)", "사이다(800)", "환타(700)", ""};
	JPanel pan = new JPanel();
	
	public UI()
	{
		setTitle("자판기 UI 만들기");
		setSize(300,200);
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setLayout(new GridLayout(2,2));
		
		for(int i=0;i<btn.length;i++)
		{
			btn[i] = new JButton(str[i]);
			pan.add(btn[i]);
		}
		
		ct.add(jtf[0], BorderLayout.NORTH);
		ct.add(pan, BorderLayout.CENTER);
		ct.add(jtf[1], BorderLayout.SOUTH);
	}
}