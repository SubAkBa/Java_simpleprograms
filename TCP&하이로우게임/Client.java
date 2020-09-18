import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Client 
{
	static Socket s1;
	public static void main(String[] args) 
	{
		JFrame frm = new JFrame("TCP 하이로우 게임");
		frm.setSize(400, 600);
		frm.setLayout(new BorderLayout());
		
		JLabel[] lab = new JLabel[3];
		lab[0] = new JLabel("Server IP");
		lab[1] = new JLabel("Server Port");
		lab[2] = new JLabel();
		JTextField[] jtf = new JTextField[2];
		jtf[0] = new JTextField();
		jtf[1] = new JTextField();
		JButton btn = new JButton("접속");
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2,3));
		for(int i=0;i<lab.length;i++)
			pan1.add(lab[i]);
		pan1.add(jtf[0]);
		pan1.add(jtf[1]);
		pan1.add(btn);
		
		DefaultListModel dlm = new DefaultListModel();
		JList jl = new JList(dlm);
		JScrollPane jsp = new JScrollPane(jl,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JLabel lab1 = new JLabel("정답");
		JTextField jtf1 = new JTextField();
		JButton btn1 = new JButton("보내기");
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(0,3));
		pan2.add(lab1);
		pan2.add(jtf1);
		pan2.add(btn1);
		
		btn.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							int port = Integer.parseInt(jtf[1].getText());
							String ip = jtf[0].getText();
							
							Socket s = new Socket(ip, port);
							s1 = s;
							
							DataInputStream dis = new DataInputStream(s.getInputStream());
							ThreadHandler t = new ThreadHandler(dis, dlm);
							t.start();
						}
						catch(Exception ex)
						{
							ex.getStackTrace();
						}
					}
				}
		);
		
		btn1.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
							dos.writeUTF(jtf1.getText());
							dlm.addElement("본인(나) : " + jtf1.getText());
							jtf1.setText("");
						}
						catch(Exception ex)
						{
							ex.getStackTrace();
						}
					}
				}
		);
		
		frm.add(pan1, BorderLayout.NORTH);
		frm.add(jsp, BorderLayout.CENTER);
		frm.add(pan2, BorderLayout.SOUTH);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
