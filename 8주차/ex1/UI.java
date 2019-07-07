package ex1;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class UI extends JFrame implements ActionListener
{
	int answer = 0;
	Container ct = getContentPane();
	JButton fbtn = new JButton("새 게임");
	JButton sbtn = new JButton("확인 ");
	JLabel title = new JLabel("1 ~ 100 사이의 숫자를 입력하세요!");
	JLabel con = new JLabel("입력내용");
	JLabel lcount = new JLabel("시도 횟수 : ");
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	JTextField jtf = new JTextField();
	HighLow hl = new HighLow();
	ThreadHandler t1 = new ThreadHandler(hl, jta, lcount);
	public UI()
	{
		setTitle("하이 로우 게임");
		setVisible(true);
		setSize(500,400);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fbtn.setBounds(205, 140, 80, 30);
		sbtn.setBounds(205, 180, 80, 30);
		title.setBounds(5, 140, 200, 30);
		jtf.setBounds(50, 170, 110, 30);
		con.setBounds(360, 15, 60, 30);
		jsp.setBounds(290, 50, 190, 250);
		lcount.setBounds(340, 300, 150, 30);
		jsp.setBorder(new LineBorder(Color.BLACK, 1));
		fbtn.addActionListener(this);
		sbtn.addActionListener(this);
		
		ct.add(fbtn);
		ct.add(sbtn);
		ct.add(title);
		ct.add(con);
		ct.add(lcount);
		ct.add(jsp);
		ct.add(jtf);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == fbtn)
		{
			t1 = new ThreadHandler(hl, jta, lcount);
			jta.setText("");
			jtf.setText("");
		}
		else if(e.getSource() == sbtn)
		{
			if(jtf.getText().matches("^[0-9]*$"))
			{
				answer = Integer.parseInt(jtf.getText());
				hl.SetAnswer(answer);
				t1.start();
			}
			else
				jtf.setText("숫자 입력 필요 !");
		}
	}
}
