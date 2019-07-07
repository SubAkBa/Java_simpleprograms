
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.event.*;
import java.io.*;
import java.text.*;

public class UI extends JFrame implements ActionListener
{
	Container ct = getContentPane();
	String[] str = {""};
	DefaultTableModel dtm = new DefaultTableModel(str, 0);
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);
	JLabel title = new JLabel("숫자 입력");
	JTextField[] jtf = {new JTextField(), new JTextField()};
	JButton[] btn = new JButton[3];
	JPanel[] pan = {new JPanel(), new JPanel()};
	String[] menu = {"PUSH", "POP", "CurrentStack"};
	
	public UI()
	{
		setTitle("자바 실습");
		setSize(300,300);
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan[0].setLayout(new GridLayout(10,0));
		pan[1].setLayout(new GridLayout(0,2));
		
		title.setHorizontalAlignment(JLabel.CENTER);
		pan[0].add(title);
		pan[0].add(jtf[0]);
		for(int i=0;i<btn.length;i++)
		{
			btn[i] = new JButton(menu[i]);
			btn[i].addActionListener(this);
			pan[0].add(btn[i]);
		}
		
		pan[1].add(jsp);
		pan[1].add(pan[0]);
		
		ct.add(pan[1], BorderLayout.CENTER);
		ct.add(jtf[1], BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(jtf[0].getText().matches("^[0-9]*$"))
		{
			switch(e.getActionCommand())
			{
			case "PUSH":
				str[0] = jtf[0].getText();
				dtm.addRow(str);
				break;
			case "POP":
				dtm.removeRow(dtm.getRowCount()-1);
				break;
			case "CurrentStack":
				jtf[1].setText("현재 스택 크기는 " + dtm.getRowCount() + "입니다.");
				break;
			}
		}
		else
			jtf[1].setText("숫자를 입력하세요.");
		
		jtf[0].setText("");
	}
}