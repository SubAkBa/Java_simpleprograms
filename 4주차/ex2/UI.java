
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

public class UI extends JFrame implements ActionListener
{
	int buy = 0;
	int money = 0;
	int[] dcount = {0,0,0};
	Container ct = getContentPane();
	JTextArea jta = new JTextArea("�ݾ��� ���� ��, ������� ����");
	JTextField[] jtf = {new JTextField("���� �ݾ�"), new JTextField("��ȯ �ݾ�")};
	JPanel[] pan = {new JPanel(), new JPanel()};
	JButton[] btn = new JButton[4];
	String[] str = {"�ݶ�(1000)", "���̴�(800)", "ȯŸ(700)", "����"};
	
	public UI()
	{
		setTitle("������ ���Ǳ�");
		setSize(400,300);
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan[0].setLayout(new GridLayout(2,2));
		pan[1].setLayout(new GridLayout(2,1));
		
		for(int i=0;i<btn.length;i++)
		{
			btn[i] = new JButton(str[i]);
			btn[i].addActionListener(this);
			pan[0].add(btn[i]);
		}
		
		pan[1].add(jtf[0]);
		pan[1].add(jtf[1]);
		
		ct.add(jta, BorderLayout.NORTH);
		ct.add(pan[0], BorderLayout.CENTER);
		ct.add(pan[1], BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(jtf[0].getText().matches("[0-9]*"))
		{
			money = Integer.parseInt(jtf[0].getText());
			switch(e.getActionCommand())
			{
			case "�ݶ�(1000)":
				dcount[0]++;
				break;
			case "���̴�(800)":
				dcount[1]++;
				break;
			case "ȯŸ(700)":
				dcount[2]++;
				break;
			case "����":
				jtf[0].setText("");
				buy = dcount[0]*1000 + dcount[1]*800 + dcount[2]*700;
				if(money >= buy)
				{
					jta.setText("�ݶ� : " + dcount[0] + "�� / ���̴� : " + dcount[1]
							+ "�� / ȯŸ : " + dcount[2] + "�� / �Ѿ� : " + buy);
					jtf[1].setText("�ܵ� : " + (money-buy));
				}
				else
				{
					jta.setText("�ܾ��� �����մϴ�.");
					jtf[1].setText("��ȯ �ݾ�");
				}
				break;
			}
		}
		else
			jtf[0].setText("���ڸ� �Է��ϼ���.");
	}
}