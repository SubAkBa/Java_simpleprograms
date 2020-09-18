import java.util.*;
import java.text.*;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

public class main {
	static boolean b1 = false;

	public static void main(String[] args) {
		JFrame frm = new JFrame("북한 쌀 주기");
		frm.setSize(400, 100);
		frm.setLayout(new GridLayout(2, 0));

		JLabel lab1 = new JLabel("북한  쌀 : ");
		JLabel lab2 = new JLabel("0kg");
		JLabel lab3 = new JLabel("총 소비량 : ");
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(0, 3));
		pan1.add(lab1);
		pan1.add(lab2);
		pan1.add(lab3);

		JLabel lab4 = new JLabel("쌀 보내기 : ");
		JTextField jtf = new JTextField();
		JButton btn = new JButton("보내기");
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(0, 3));
		pan2.add(lab4);
		pan2.add(jtf);
		pan2.add(btn);

		RiceProcess rp = new RiceProcess();
		ThreadHandler t = new ThreadHandler(rp, lab2, lab3);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (b1 == false) {
					b1 = true;
					rp.setRiceNum(Integer.parseInt(jtf.getText()));
					t.start();
				} else
					rp.PlusRice(Integer.parseInt(jtf.getText()));
				jtf.setText("");
			}
		});

		frm.add(pan1);
		frm.add(pan2);

		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
