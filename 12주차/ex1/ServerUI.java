package ex1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ServerUI extends JFrame implements ActionListener
{
	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia;
	byte[] buffer;
	ServerThread s;
	Container ct = getContentPane();
	JLabel[] lab = new JLabel[4];
	String[] str = {"My Port", "Your Port", "Your IP", ""};
	JTextField[] jtf = {new JTextField(), new JTextField(), new JTextField()};
	JButton btn = new JButton("설정");
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JLabel chatlab = new JLabel("채팅", JLabel.CENTER);
	JTextField chatfield = new JTextField();
	JButton chatbtn = new JButton("보내기");
	JPanel[] pan = {new JPanel(), new JPanel()};
	public ServerUI()
	{
		setLayout(new BorderLayout());
		setTitle("UDP 채팅 서버측");
		setSize(350, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan[0].setLayout(new GridLayout(2,4));
		for(int i=0;i<4;i++)
		{
			lab[i] = new JLabel(str[i], JLabel.CENTER);
			pan[0].add(lab[i]);
		}
		for(int i=0;i<4;i++)
		{
			if(i != 3)
				pan[0].add(jtf[i]);
			else
				pan[0].add(btn);
		}
		btn.addActionListener(this);
		
		pan[1].setLayout(new BorderLayout());
		pan[1].add(chatlab, BorderLayout.WEST);
		pan[1].add(chatfield, BorderLayout.CENTER);
		pan[1].add(chatbtn, BorderLayout.EAST);
		chatbtn.addActionListener(this);
		
		ct.add(pan[0], BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(pan[1], BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "설정":
			try {
				btn.setEnabled(false);
				ia = InetAddress.getByName(jtf[2].getText());
				ds = new DatagramSocket(Integer.parseInt(jtf[0].getText()));
				s = new ServerThread(jta, ds);
				s.start();
			} 
			catch (IOException e0) {
				e0.printStackTrace();
			}
			catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
			break;
		case "보내기":
			try {
				buffer = chatfield.getText().getBytes();
				dp = new DatagramPacket(buffer, buffer.length, ia,
						Integer.parseInt(jtf[1].getText()));
				ds.send(dp);
				jta.append("본인(나) : " + chatfield.getText() + "\n");
				chatfield.setText("");
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		}
	}
}
