package 야구게임;

import java.util.*;

import java.io.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class 야구게임 {
	static int rannum;
	static char[] inputnum = new char[4];
	static int strikenum = 0, ballnum = 0;

	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		Random ran = new Random();
		rannum = ran.nextInt(10);
		String[] answernum = new String[4];
		JFrame frm = new JFrame("야구 게임");
		frm.setLayout(null);
		frm.setSize(400, 400);

		JLabel jlnum = new JLabel("숫자 생성 ==============>");
		frm.add(jlnum);
		jlnum.setBounds(70, 30, 200, 25);

		JLabel answer = new JLabel("정답 : xxxx");
		frm.add(answer);
		answer.setBounds(150, 60, 200, 20);

		JLabel play = new JLabel("※Play Game");
		frm.add(play);
		play.setBounds(30, 90, 120, 30);

		JTextField input = new JTextField();
		frm.add(input);
		input.setBounds(140, 90, 80, 28);

		JLabel jlresult = new JLabel("※Game Result");
		frm.add(jlresult);
		jlresult.setBounds(20, 130, 100, 28);

		JTextArea resultarea = new JTextArea();
		JScrollPane js = new JScrollPane(resultarea);
		frm.add(js);
		js.setBounds(5, 153, 375, 200);

		JButton game = new JButton("Play Game");
		frm.add(game);
		game.setBounds(250, 90, 100, 28);
		game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				for (int i = 0; i < 4; i++)
					inputnum[i] = input.getText().charAt(i);

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (inputnum[i] == answernum[j].charAt(0)) {
							if (i == j)
								strikenum++;
							else
								ballnum++;
						}
					}
				}

				sb.append("스트라이크 : " + strikenum + "\t볼 : " + ballnum + "\t입력숫자 : " + input.getText() + "\n");
				resultarea.setText(sb.toString());
				input.setText("");

				if (strikenum == 4) {
					String s = "";
					for (int i = 0; i < 4; i++)
						s += answernum[i];
					answer.setText("정답 : " + s);
					resultarea.setText(sb.toString() + "정답입니다." + "\n");
				}
				strikenum = 0;
				ballnum = 0;

				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("야구게임.txt"));
					bw.write(sb.toString());
					bw.close();
				} catch (IOException ie) {
					ie.getStackTrace();
				}
			}
		});

		JButton insert = new JButton("숫자 생성");
		frm.add(insert);
		insert.setBounds(240, 25, 90, 25);
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				for (int i = 0; i < 4; i++)
					answernum[i] = Integer.toString(rannum);

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (i == j)
							continue;
						else if (!answernum[i].equals(answernum[j]))
							continue;
						else {
							while (Integer.toString(rannum).equals(answernum[0])
									|| Integer.toString(rannum).equals(answernum[1])
									|| Integer.toString(rannum).equals(answernum[2])
									|| Integer.toString(rannum).equals(answernum[3]))
								rannum = ran.nextInt(10);
							answernum[j] = Integer.toString(rannum);
						}
					}
				}
				sb.delete(0, sb.toString().length());
				resultarea.setText(sb.toString());
//				for (int i = 0; i < 4; i++)
//					System.out.print(answernum[i]);
//				System.out.println();
			}
		});

		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}