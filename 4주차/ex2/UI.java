
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
	JTextArea jta = new JTextArea("금액을 투입 후, 음료수를 구매");
	JTextField[] jtf = {new JTextField("투입 금액"), new JTextField("반환 금액")};
	JPanel[] pan = {new JPanel(), new JPanel()};
	JButton[] btn = new JButton[4];
	String[] str = {"콜라(1000)", "사이다(800)", "환타(700)", "구매"};
	
	public UI()
	{
		setTitle("간단한 자판기");
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
			case "콜라(1000)":
				dcount[0]++;
				break;
			case "사이다(800)":
				dcount[1]++;
				break;
			case "환타(700)":
				dcount[2]++;
				break;
			case "구매":
				jtf[0].setText("");
				buy = dcount[0]*1000 + dcount[1]*800 + dcount[2]*700;
				if(money >= buy)
				{
					jta.setText("콜라 : " + dcount[0] + "개 / 사이다 : " + dcount[1]
							+ "개 / 환타 : " + dcount[2] + "개 / 총액 : " + buy);
					jtf[1].setText("잔돈 : " + (money-buy));
				}
				else
				{
					jta.setText("잔액이 부족합니다.");
					jtf[1].setText("반환 금액");
				}
				break;
			}
		}
		else
			jtf[0].setText("숫자를 입력하세요.");
	}
}