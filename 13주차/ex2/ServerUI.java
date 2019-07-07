package ex1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ServerUI extends JFrame implements ActionListener
{
	DataOutputStream dos;
	ServerSocket ss;
	Socket s1;
	ServerThread s;
	Container ct = getContentPane();
	JLabel[] lab = new JLabel[2];
	String[] str = {"Server Port", ""};
	JTextField jtf = new JTextField();
	JButton btn = new JButton("생성");
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
		for(int i=0;i<2;i++)
		{
			lab[i] = new JLabel(str[i], JLabel.CENTER);
			pan[0].add(lab[i]);
		}
		for(int i=0;i<2;i++)
		{
			if(i != 1)
				pan[0].add(jtf);
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
		case "생성":
			try {
				btn.setEnabled(false);
				ss = new ServerSocket(Integer.parseInt(jtf.getText()));
				s1 = ss.accept();
				dos = new DataOutputStream(s1.getOutputStream());
				s = new ServerThread(jta, s1);
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
