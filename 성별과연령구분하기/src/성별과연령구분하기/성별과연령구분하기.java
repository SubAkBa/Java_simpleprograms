package ���������ɱ����ϱ�;

import java.util.*;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ���������ɱ����ϱ� 
{
	public static void main(String[] args) 
	{
		StringBuffer sb = new StringBuffer();
		
		JFrame frm = new JFrame("����/���� �����ϱ�");
		frm.setSize(400, 300);
		frm.setLayout(new BorderLayout());
		
		JTextArea jta = new JTextArea();
		JButton btn = new JButton("����");
		
		btn.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						StringTokenizer stk = new StringTokenizer(jta.getText(),",\n ");
						String[] sa = new String[stk.countTokens()];
						int num = 0;
						for(int i=0;i<sa.length;i++)
						{
							sa[i] = stk.nextToken();
							sb.append(sa[i]+"\t");
							if(sa[i].charAt(7) == '1')
								sb.append("����\t");
							else
								sb.append("����\t");
							
							num = Integer.parseInt(sa[i].substring(0, 2));
							sb.append((116-num) + "\n");
						}
						
						jta.setText(sb.toString());
						
						try
						{
							BufferedWriter bw = new BufferedWriter(new FileWriter("�޸���.txt"));
							bw.write(sb.toString());
							bw.close();
						}
						catch(IOException ie)
						{
							ie.getStackTrace();
						}
					}
				}
		);
		
		frm.add(jta, BorderLayout.CENTER);
		frm.add(btn, BorderLayout.SOUTH);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
