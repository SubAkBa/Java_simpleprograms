package ex1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class UI extends JFrame implements ActionListener
{
	String msg = "";
	InetAddress ia;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	Container ct = getContentPane();
	JLabel[] lab = new JLabel[3];
	String[] str = {"Server IP", "Server Port", ""};
	JTextField[] jtf = {new JTextField("127.0.0.1"), new JTextField("7777")};
	JButton btn = new JButton("접속");
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	JLabel lab1 = new JLabel("정답", JLabel.CENTER);
	JTextField jtf1 = new JTextField();
	JButton btn1 = new JButton("보내기");
	JPanel[] pan = {new JPanel(), new JPanel()};
	public UI()
	{
		setTitle("TCP 하이로우 게임");
		setVisible(true);
		setSize(300, 500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		pan[1].add(lab1, BorderLayout.WEST);
		pan[1].add(jtf1, BorderLayout.CENTER);
		pan[1].add(btn1, BorderLayout.EAST);
		btn1.addActionListener(this);
		
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
				ia = InetAddress.getByName(jtf[0].getText());
				s = new Socket(ia, Integer.parseInt(jtf[1].getText()));
				dos = new DataOutputStream(s.getOutputStream());
				dis = new DataInputStream(s.getInputStream());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "보내기":
			try {
				dos.writeUTF(jtf1.getText());
				jta.append("본인(나) : " + jtf1.getText() + "\n");
				jtf1.setText("");
				
				msg = dis.readUTF();
				jta.append("Server : " + msg + "\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
}
