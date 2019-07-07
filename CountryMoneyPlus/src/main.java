import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main 
{
	static boolean b = false;
	public static void main(String[] args) 
	{		
		Money m = new Money();
		
		JFrame frm = new JFrame("멀티 스레딩");
		frm.setSize(300, 200);
		frm.setLayout(new BorderLayout());
		
		JLabel[] lab = new JLabel[4];
		lab[0] = new JLabel("Korea money : 0");
		lab[1] = new JLabel("Japan money : 0");
		lab[2] = new JLabel("China money : 0");
		lab[3] = new JLabel("Total money : 0");
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(4,0));
		for(int i=0;i<lab.length;i++)
			pan1.add(lab[i]);
		
		JLabel lab1 = new JLabel("총 금액:");
		JTextField jtf = new JTextField();
		JButton btn1 = new JButton("시작");
		JButton btn2 = new JButton("리셋");
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(0,4));
		pan2.add(lab1);
		pan2.add(jtf);
		pan2.add(btn1);
		pan2.add(btn2);
		
		btn1.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						btn1.setEnabled(false);
						m.setMoney(lab[3], jtf.getText());

						if(b == false)
						{
							b = true;
							ThreadHandler t1 = new ThreadHandler(m,lab[0]);
							ThreadHandler t2 = new ThreadHandler(m,lab[1]);
							ThreadHandler t3 = new ThreadHandler(m,lab[2]);
							
							t1.start();
							t2.start();
							t3.start();
						}
					}
				}
		);
		
		btn2.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						btn1.setEnabled(true);
						lab[0].setText("Korea money : 0");
						lab[1].setText("Japan money : 0");
						lab[2].setText("China money : 0");
						lab[3].setText("Total money : 0");
						jtf.setText("");
					}
				}
		);
		
		frm.add(pan1, BorderLayout.CENTER);
		frm.add(pan2, BorderLayout.SOUTH);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
