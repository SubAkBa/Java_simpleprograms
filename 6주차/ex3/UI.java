package ex3;


import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class UI extends JFrame implements ActionListener
{
	int avg = 0;
	String[] s = new String[5];
	Container ct = getContentPane();
	DefaultTableModel dtm = new DefaultTableModel();
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);
	JLabel[] lab = new JLabel[5];
	JTextField[] jtf = new JTextField[4];
	JButton btn = new JButton("추가");
	String[] str = {"이름", "국어", "영어", "수학", "평균"};
	JPanel pan = new JPanel();
	
	public UI()
	{
		setTitle("점수 관리 프로그램");
		setLayout(new BorderLayout());
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setLayout(new GridLayout(2,5));

		dtm.setColumnIdentifiers(str);
		str[4] = "";
		for(int i=0;i<5;i++)
		{
			lab[i] = new JLabel(str[i]);
			lab[i].setHorizontalAlignment(JLabel.CENTER);
			pan.add(lab[i]);
		}
		for(int j=0;j<4;j++)
		{
			jtf[j] = new JTextField();
			pan.add(jtf[j]);
		}
		
		pan.add(btn);
		btn.addActionListener(this);
		
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(pan, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		avg = (int)Math.round((Double.parseDouble(jtf[1].getText()) + 
				Double.parseDouble(jtf[2].getText()) + Double.parseDouble(jtf[3].getText())) / 3);
		for(int i=0;i<4;i++)
			s[i] = jtf[i].getText();
		s[4] = String.valueOf(avg);
		dtm.addRow(s);
		for(int i=0;i<4;i++)
			jtf[i].setText("");
	}
}

