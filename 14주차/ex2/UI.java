package ex2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class UI extends JFrame implements ActionListener
{
	InetAddress ia;
	StringBuffer sb = new StringBuffer();
	String msg;
	byte[] buffer, buffer1;
	DatagramPacket dp, dp1;
	DatagramSocket ds;
	Container ct = getContentPane();
	JLabel[] lab = new JLabel[3];
	String[] str = {"Server IP", "Server Port", ""};
	JTextField[] jtf = {new JTextField("127.0.0.1"), new JTextField("7777")};
	JButton btn = new JButton("접속");
	DefaultListModel dlm = new DefaultListModel();
	JList jl = new JList(dlm);
	JTextField jtf1 = new JTextField();
	JButton[] btn1 = new JButton[20];
	String[] btns = {"+", "-", "*", "/", "7", "8", "9", "%", "4", "5", "6", "(", "1", "2", "3", ")", "0", ".", "=", "<-"};
	JPanel[] pan = {new JPanel(), new JPanel(), new JPanel()};
	public UI() 
	{
		setTitle("계산기");
		setLayout(new BorderLayout());
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		pan[0].setLayout(new GridLayout(2,3));
		for(int i=0;i<3;i++)
		{
			lab[i] = new JLabel(str[i], JLabel.CENTER);
			pan[0].add(lab[i]);
		}
		pan[0].add(jtf[0]);
		pan[0].add(jtf[1]);
		pan[0].add(btn);
		btn.addActionListener(this);
		
		pan[1].setLayout(new BorderLayout());
		pan[1].add(jl, BorderLayout.CENTER);
		pan[1].add(jtf1, BorderLayout.SOUTH);
		
		pan[2].setLayout(new GridLayout(5, 4, 5, 5));
		for(int i=0;i<btns.length;i++)
		{
			btn1[i] = new JButton(btns[i]);
			pan[2].add(btn1[i]);
			btn1[i].addActionListener(this);
		}
		btn1[11].setEnabled(false);
		btn1[15].setEnabled(false);
		
		ct.add(pan[0], BorderLayout.NORTH);
		ct.add(pan[1], BorderLayout.CENTER);
		ct.add(pan[2], BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case "접속":
			try {
				ds = new DatagramSocket(8888);
				ia = InetAddress.getByName(jtf[0].getText());
			} catch (SocketException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "=":
			try {
				buffer = jtf1.getText().getBytes();
				dp = new DatagramPacket(buffer, buffer.length, ia, Integer.parseInt(jtf[1].getText()));
				ds.send(dp);
				dlm.addElement("본인(나) : " + jtf1.getText() + "\n");
				
				buffer1 = new byte[100];
				dp1 = new DatagramPacket(buffer1, buffer1.length);
				ds.receive(dp1);
				msg = new String(dp1.getData());
				dlm.addElement("Server : " + msg + "\n");

				sb.delete(0, sb.length());
				jtf1.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "<-":
			if(sb.length() > 0)
			{
				sb.deleteCharAt(sb.length()-1);
				jtf1.setText(sb.toString());
			}
			break;
		default:
			sb.append(e.getActionCommand());
			jtf1.setText(sb.toString());
		}
	}
}
