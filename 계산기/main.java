import java.util.*;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class main {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		StringBuffer sb = new StringBuffer();
		String[] s = { "+", "-", "*", "/", "7", "8", "9", "%", "4", "5", "6", "(", "1", "2", "3", ")", "0", ".", "=",
				"<-" };

		JFrame frm = new JFrame("계산기");
		frm.setSize(400, 500);
		frm.setLayout(new GridLayout(2, 0));

		DefaultListModel dlm = new DefaultListModel();
		JList jl = new JList(dlm);
		JScrollPane jsp = new JScrollPane(jl, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JTextField jtf = new JTextField();
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());
		pan1.add(jsp, BorderLayout.CENTER);
		pan1.add(jtf, BorderLayout.SOUTH);

		JButton[] btn = new JButton[20];
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(5, 4, 5, 5));
		for (int j = 0; j < btn.length; j++) {
			btn[j] = new JButton(s[j]);
			btn[j].setFont(new Font("���ü", Font.BOLD, 20));
			pan2.add(btn[j]);
		}

		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand() == "=") {
						cal.setCalculator(dlm, jtf.getText());
						cal.Process();
						jtf.setText("");
						sb.delete(0, sb.toString().length());
					} else if (e.getActionCommand() == "<-") {
						sb.deleteCharAt(sb.toString().length() - 1);
						jtf.setText(sb.toString());
					} else {
						sb.append(e.getActionCommand());
						jtf.setText(sb.toString());
					}
				}
			});
		}

		btn[11].setEnabled(false);
		btn[15].setEnabled(false);

		frm.add(pan1);
		frm.add(pan2);

		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}