import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class Server {
	static Socket s1 = new Socket();

	public static void main(String[] args) {
		JFrame frm = new JFrame("TCP 채팅 Server 측");
		frm.setSize(400, 600);
		frm.setLayout(new BorderLayout());

		JLabel lab = new JLabel("Server Port");
		JLabel lab1 = new JLabel();
		JTextField jtf1 = new JTextField();
		JButton btn1 = new JButton("생성");
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2, 2));
		pan1.add(lab);
		pan1.add(lab1);
		pan1.add(jtf1);
		pan1.add(btn1);

		DefaultListModel dlm = new DefaultListModel();
		JList jl = new JList(dlm);
		JScrollPane jsp = new JScrollPane(jl, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JLabel lab2 = new JLabel("채팅");
		JTextField jtf2 = new JTextField();
		JButton btn2 = new JButton("보내기");
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(0, 3));
		pan2.add(lab2);
		pan2.add(jtf2);
		pan2.add(btn2);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int port = Integer.parseInt(jtf1.getText());
					ServerSocket ss = new ServerSocket(port);
					Socket s = ss.accept();
					s1 = s;

					DataInputStream dis = new DataInputStream(s.getInputStream());

					ThreadHandler t = new ThreadHandler(dis, dlm);
					t.start();
				} catch (Exception ex) {
					ex.getStackTrace();
				}
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
					dos.writeUTF(jtf2.getText());

					dlm.addElement("본인(나) : " + jtf2.getText() + "\n");
					jtf2.setText("");
				} catch (Exception ex) {
					ex.getStackTrace();
				}
			}
		});

		frm.add(pan1, BorderLayout.NORTH);
		frm.add(jsp, BorderLayout.CENTER);
		frm.add(pan2, BorderLayout.SOUTH);

		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}