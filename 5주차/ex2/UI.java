
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.text.*;

public class UI extends JFrame implements ActionListener
{
	Container ct = getContentPane();
	JLabel lab = new JLabel("����� ���Ǳ�");
	JComboBox jcb = new JComboBox();
	JButton btn = new JButton("����");
	JTextField jtf = new JTextField();
	String[] str = {"�ݶ�", "���̴�", "ȯŸ", "����"};
	String s = "";
	
	public UI()
	{
		setTitle("���Ǳ�");
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
		case "�ݶ�":
			s = "1200";
			break;
		case "���̴�":
			s = "1000";
			break;
		case "ȯŸ":
			s = "800";
			break;
		case "����":
			s = "500";
			break;
		}
		
		jtf.setText(jcb.getSelectedItem().toString() + "�� " + s + "�� �Դϴ�.");
	}
}