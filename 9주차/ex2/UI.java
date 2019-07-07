package ex2;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UI extends JFrame implements ActionListener
{
	boolean first = false;
	Container ct = getContentPane();
	JPanel[] pan = {new JPanel(), new JPanel()};
	JLabel nrice = new JLabel("북한 쌀 : ");
	JLabel kg = new JLabel("0 kg");
	JLabel throwrice = new JLabel("쌀 보내기 : ");
	JTextField jtf = new JTextField();
	JButton btn = new JButton("보내기");
	NorthRiceProject nrp = new NorthRiceProject();
	ThreadHandler t = new ThreadHandler(nrp);
	
	public UI()
	{
		setTitle("배경 색상 변화");
		setSize(300, 100);
		setLayout(new GridLayout(2,1));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan[0].setLayout(new GridLayout(1,2));
		pan[1].setLayout(new GridLayout(1,3));
		
		pan[0].add(nrice);
		pan[0].add(kg);
		nrice.setHorizontalAlignment(JLabel.CENTER);
		kg.setHorizontalAlignment(JLabel.CENTER);
		
		pan[1].add(throwrice);
		pan[1].add(jtf);
		pan[1].add(btn);
		throwrice.setHorizontalAlignment(JLabel.RIGHT);
		
		btn.addActionListener(this);
		
		ct.add(pan[0]);
		ct.add(pan[1]);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(!jtf.getText().equals("") && jtf.getText().matches("^[0-9]*$"))
		{
			if(first == false)
			{
				t.start();
				nrp.SettingRice(jtf.getText(), kg);
				first = true;
			}
			else
				nrp.SettingRice(jtf.getText(), kg);
		}
		else
			jtf.setText("숫자 입력 !");
	}
}
