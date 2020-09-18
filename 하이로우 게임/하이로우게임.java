import java.util.*;

import java.io.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class 하이로우게임 {
	static int rannum, i = 0;

	public static void main(String[] args) throws Exception {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		rannum = ran.nextInt(100) + 1;
		JFrame frm = new JFrame("하이로우 게임");
		frm.setSize(300, 300);
		frm.setLayout(new GridLayout(0, 1));

		JTextField jtf = new JTextField();
		JLabel lab1 = new JLabel("사용자 : ");
		JLabel lab2 = new JLabel("정답 유무 : ");
		JLabel lab3 = new JLabel();
		JButton btn = new JButton("확인");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					i++;
					lab1.setText("사용자 : " + jtf.getText());

					if (rannum > Integer.parseInt(jtf.getText())) {
						lab2.setText("정답보다 작습니다.");
						sb.append(jtf.getText() + " ");
						lab3.setText(sb.toString());
					} else if (rannum < Integer.parseInt(jtf.getText())) {
						lab2.setText("정답보다 큽니다");
						sb.append(jtf.getText() + " ");
						lab3.setText(sb.toString());
					} else {
						lab2.setText("정답입니다.");
						sb.append(jtf.getText() + " ");
						lab3.setText(sb.toString());
						rannum = ran.nextInt(100) + 1;
						sb.delete(0, sb.toString().length());
						i = 0;
					}

					if (i == 10)
						System.exit(0);

					jtf.setText("");
				} catch (NumberFormatException nfe) {
					jtf.setText("");
					lab2.setText("숫자만 입력가능합니다.");
				}
			}
		});

		frm.add(jtf);
		frm.add(lab1);
		frm.add(lab2);
		frm.add(lab3);
		frm.add(btn);

		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}