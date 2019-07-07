import java.util.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class 점수관리프로그램 
{
	public static void main(String[] args) 
	{
		String[] cs = {"이름","국어","영어","수학","평균"};
		String[][] ds = null;
		
		JFrame frm = new JFrame("점수 관리 프로그램");
		frm.setSize(500, 400);
		frm.setLayout(new BorderLayout());
		
		DefaultTableModel m = new DefaultTableModel(ds,cs);
		JTable jt = new JTable(m);
		JScrollPane jsp = new JScrollPane(jt
				,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
				,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JLabel[] lab = new JLabel[4];
		JLabel labn = new JLabel("");
		JTextField[] jtf = new JTextField[4];
		JButton btn = new JButton("추가");
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(2,5));
		for(int i=0;i<4;i++)
		{
			lab[i] = new JLabel(cs[i]);
			pan.add(lab[i]);
		}
		pan.add(labn);
		for(int i=0;i<4;i++)
		{
			jtf[i] = new JTextField();
			pan.add(jtf[i]);
		}
		pan.add(btn);
		
		btn.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						int avg = (Integer.parseInt(jtf[1].getText())+
								Integer.parseInt(jtf[2].getText())+
								Integer.parseInt(jtf[3].getText()))/3;
						String[] sa = {jtf[0].getText(),jtf[1].getText()
								,jtf[2].getText(),jtf[3].getText()
								, Integer.toString(avg)};
						m.addRow(sa);
						for(int i=0;i<4;i++)
							jtf[i].setText("");
					}
				}
		);
		
		frm.add(jsp, BorderLayout.CENTER);
		frm.add(pan, BorderLayout.SOUTH);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
