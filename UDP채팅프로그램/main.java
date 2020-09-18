import java.util.*;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

public class main {
	static InetAddress mia;

	public static void main(String args[]) {
		JFrame frm = new JFrame("UDP 채팅 프로그램");
		frm.setSize(400, 600);
		frm.setLayout(new BorderLayout());

		JLabel[] lab = new JLabel[4];
		lab[0] = new JLabel("My Port");
		lab[1] = new JLabel("Your Port");
		lab[2] = new JLabel("Your IP");
		lab[3] = new JLabel();
		JTextField[] jtf = new JTextField[3];
		for (int i = 0; i < jtf.length; i++)
			jtf[i] = new JTextField();
		JButton btn1 = new JButton("설정");
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2, 4));
		for (int i = 0; i < lab.length; i++)
			pan1.add(lab[i]);
		for (int i = 0; i < jtf.length; i++)
			pan1.add(jtf[i]);
		pan1.add(btn1);

		DefaultListModel dlm = new DefaultListModel();
		JList jl = new JList(dlm);
		JScrollPane jsp = new JScrollPane(jl, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JLabel lab1 = new JLabel("채팅");
		JTextField jtf1 = new JTextField();
		JButton btn2 = new JButton("보내기");
		btn2.setEnabled(false);
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(0, 3));
		pan2.add(lab1);
		pan2.add(jtf1);
		pan2.add(btn2);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setEnabled(true);
				btn1.setEnabled(false);
				try {
					int mport = Integer.parseInt(jtf[0].getText());
					InetAddress ia = InetAddress.getByName(jtf[2].getText());
					mia = ia;
					ThreadHandler t = new ThreadHandler(dlm, mport);
					t.start();
				} catch (Exception ex) {
					ex.getStackTrace();
				}
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					byte[] buffer = jtf1.getText().getBytes();
					int yport = Integer.parseInt(jtf[1].getText());
					DatagramSocket ds = new DatagramSocket();
					DatagramPacket dp = new DatagramPacket(buffer, buffer.length, mia, yport);
					ds.send(dp);

					dlm.addElement("본인 : " + jtf1.getText());
				} catch (Exception ex) {
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