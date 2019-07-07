import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UI extends JFrame implements ActionListener
{
	boolean first = false;
	Container ct = getContentPane();
	JLabel[] lab = new JLabel[5];
	String[] str = {"Korea money : 0", "Japan money : 0", "China money : 0", "Total money : 0", ""};
	JLabel lab1 = new JLabel("총 금액: ");
	JTextField jtf = new JTextField();
	JButton start = new JButton("시작");
	JButton reset = new JButton("리셋");
	JPanel[] pan = {new JPanel(), new JPanel()};
	CountryMoney cm = new CountryMoney(lab);
	ThreadHandler[] t = {new ThreadHandler("Korea", cm), new ThreadHandler("Japan", cm)
			, new ThreadHandler("China", cm)};
	public UI()
	{
		setTitle("멀티 스레딩");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(300, 150);
		
		pan[0].setLayout(new GridLayout(5,1));
		for(int i=0;i<5;i++)
		{
			lab[i] = new JLabel(str[i]);
			pan[0].add(lab[i]);
		}
		
		pan[1].setLayout(new GridLayout(1,4));
		pan[1].add(lab1);
		pan[1].add(jtf);
		pan[1].add(start);
		pan[1].add(reset);
		start.addActionListener(this);
		reset.addActionListener(this);
		
		ct.add(pan[0], BorderLayout.CENTER);
		ct.add(pan[1], BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "시작":
			start.setEnabled(false);
			cm.SetStatement(jtf.getText());
			if(first == false)
			{
				for(int i=0;i<3;i++)
					t[i].start();
				first = true;
			}
			break;
		case "리셋":
			start.setEnabled(true);
			for(int i=0;i<4;i++)
				lab[i].setText(str[i]);
			break;
		}
	}
}
