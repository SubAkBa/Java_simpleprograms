package ex2;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class UI extends JFrame implements ActionListener
{
	boolean b = false;
	Container ct = getContentPane();
	JPanel[] pan = {new JPanel(), new JPanel(), new JPanel()};
	JLabel[] numjl = new JLabel[4];
	JTextField[] numjtf = new JTextField[4];
	String[] numstr = {"ȸ��", "1�� ����", "2�� ����", "3�� ����", "4�� ����", "��÷ �ݾ�"};
	DefaultTableModel dtm = new DefaultTableModel(numstr, 0);
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);
	JLabel inputjl = new JLabel("�ݾ� ���� : ", JLabel.CENTER);
	JTextField inputjtf = new JTextField();
	JButton btn = new JButton("����");
	JLabel inputjl1 = new JLabel("���� �ݾ� > ", JLabel.CENTER);
	JLabel totaljl = new JLabel("", JLabel.CENTER);
	JLabel getjl = new JLabel("", JLabel.CENTER);
	Roulette rl = new Roulette();
	ThreadHandler t = new ThreadHandler(rl, dtm);
	int[] answer = new int[4];
	public UI()
	{
		setTitle("�귿 ���α׷�");
		setSize(600, 800);
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan[0].setLayout(new GridLayout(2,4));
		for(int i=1;i<5;i++)
		{
			numjl[i-1] = new JLabel(numstr[i], JLabel.CENTER);
			pan[0].add(numjl[i-1]);
		}
		for(int i=0;i<4;i++)
		{
			numjtf[i] = new JTextField();
			pan[0].add(numjtf[i]);
		}
		pan[2].setLayout(new GridLayout(1,5));
		pan[2].add(inputjl);
		pan[2].add(inputjtf);
		pan[2].add(btn);
		pan[2].add(inputjl1);
		pan[2].add(totaljl);
		
		pan[1].setLayout(new GridLayout(2,1));
		pan[1].add(pan[2]);
		pan[1].add(getjl);
		
		btn.addActionListener(this);
		ct.add(pan[0], BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(pan[1], BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<4;i++)
			answer[i] = Integer.parseInt(numjtf[i].getText());
		rl.Settings(answer, totaljl, getjl, inputjtf.getText());
		if(b == false)
		{
			t.start();
			b = true;
		}
		
	}
}
