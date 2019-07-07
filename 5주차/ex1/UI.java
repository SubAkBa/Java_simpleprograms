
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.text.*;

public class UI extends JFrame implements ActionListener
{
	Container ct = getContentPane();
	JLabel lab = new JLabel("음료수를 선택해 주세요.");
	JRadioButton[] jrb = new JRadioButton[4];
	ButtonGroup bg = new ButtonGroup();
	JTextField jtf = new JTextField();
	JPanel pan = new JPanel();
	String[] str = {"콜라", "사이다", "환타", "생수"};
	String s = "";
	
	public UI()
	{
		setTitle("자판기");
		setSize(300,150);
		setLayout(new GridLayout(3,1));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setLayout(new GridLayout(1,4));
		
		for(int i=0;i<jrb.length;i++)
		{
			jrb[i] = new JRadioButton(str[i]);
			jrb[i].addActionListener(this);
			bg.add(jrb[i]);
			pan.add(jrb[i]);
		}
		lab.setHorizontalAlignment(JLabel.CENTER);
		
		ct.add(lab);
		ct.add(pan);
		ct.add(jtf);
	}
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
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
		
		jtf.setText(e.getActionCommand() + "는 " + s + "원 입니다.");
	}
}