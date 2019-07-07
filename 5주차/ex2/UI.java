
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.text.*;

public class UI extends JFrame implements ActionListener
{
	Container ct = getContentPane();
	JLabel lab = new JLabel("음료수 자판기");
	JComboBox jcb = new JComboBox();
	JButton btn = new JButton("선택");
	JTextField jtf = new JTextField();
	String[] str = {"콜라", "사이다", "환타", "생수"};
	String s = "";
	
	public UI()
	{
		setTitle("자판기");
		setSize(300,300);
		setLayout(new GridLayout(4,1));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lab.setHorizontalAlignment(JLabel.CENTER);
		for(String x : str)
			jcb.addItem(x);
		btn.addActionListener(this);
		
		ct.add(lab);
		ct.add(jcb);
		ct.add(btn);
		ct.add(jtf);
	}
	public void actionPerformed(ActionEvent e)
	{
		switch(jcb.getSelectedItem().toString())
		{
		case "콜라":
			s = "1200";
			break;
		case "사이다":
			s = "1000";
			break;
		case "환타":
			s = "800";
			break;
		case "생수":
			s = "500";
			break;
		}
		
		jtf.setText(jcb.getSelectedItem().toString() + "는 " + s + "원 입니다.");
	}
}