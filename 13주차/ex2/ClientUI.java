package ex1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ClientUI extends JFrame implements ActionListener
{
	DataOutputStream dos;
	Socket s;
	ClientThread c;
	Container ct = getContentPane();
	JLabel[] lab = new JLabel[3];
	String[] str = {"Server IP", "Server Port", ""};
	JTextField[] jtf = {new JTextField(), new JTextField()};
	JButton btn = new JButton("접속");
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JLabel chatlab = new JLabel("채팅", JLabel.CENTER);
	JTextField chatfield = new JTextField();
	JButton chatbtn = new JButton("보내기");
	JPanel[] pan = {new JPanel(), new JPanel()};
	public ClientUI()
	{
		setLayout(new BorderLayout());
		setTitle("UDP 채팅 클라이언트측");
		setSize(350, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan[0].setLayout(new GridLayout(2,4));
		for(int i=0;i<3;i++)
		{
			lab[i] = new JLabel(str[i], JLabel.CENTER);
			pan[0].add(lab[i]);
		}
		for(int i=0;i<3;i++)
		{
			if(i != 2)
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
		case "접속":
			try {
				btn.setEnabled(false);
				s = new Socket(jtf[0].getText(), Integer.parseInt(jtf[1].getText()));
				dos = new DataOutputStream(s.getOutputStream());
				c = new ClientThread(jta, s);
				c.start();
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
				dos.writeUTF(chatfield.getText());
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
