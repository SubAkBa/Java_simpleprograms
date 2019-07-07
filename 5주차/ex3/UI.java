
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.event.*;
import java.io.*;
import java.text.*;

public class UI extends JFrame implements ActionListener
{
	int comnum = 0, usernum = 0;
	Random ran = new Random();
	StringBuffer sb = new StringBuffer();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	Calendar cal;
	Container ct = getContentPane();
	JLabel[] lab = new JLabel[6];
	JComboBox jcb = new JComboBox();
	JButton btn = new JButton("Play Game");
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	String[] str = {"Com", "User", "", "", "Play Game", "°ÿ Game Result"};
	
	public UI()
	{
		setTitle("∞°¿ßπŸ¿ß∫∏ ∞‘¿”");
		setSize(400,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(this);
		for(int i=0;i<lab.length;i++)
		{
			lab[i] = new JLabel(str[i]);
			if(i == 2 || i == 3)
				lab[i].setFont(new Font("±√º≠√º", Font.BOLD, 40));
			ct.add(lab[i]);
		}
		jcb.addItem("∞°¿ß");
		jcb.addItem("πŸ¿ß");
		jcb.addItem("∫∏");
		
		jsp.setBorder(new LineBorder(Color.BLACK, 1));
		jsp.setBounds(2, 220, 380, 240);
		lab[0].setBounds(70, 20, 40, 10);
		lab[1].setBounds(280, 20, 40, 10);
		lab[2].setBounds(65, 40, 100, 50);
		lab[3].setBounds(260, 40, 100, 50);
		lab[4].setBounds(50, 130, 60, 10);
		jcb.setBounds(135, 125, 90, 20);
		btn.setBounds(250, 125, 100, 20);
		lab[5].setBounds(15, 200, 120, 20);
		
		
		ct.add(jcb);
		ct.add(btn);
		ct.add(jsp);
	}
	public void actionPerformed(ActionEvent e)
	{
		cal = Calendar.getInstance();
		comnum = ran.nextInt(3);
		usernum = jcb.getSelectedIndex();
		lab[2].setText(jcb.getItemAt(comnum).toString());
		lab[3].setText(jcb.getItemAt(usernum).toString());
		
		switch(comnum - usernum)
		{
		case 0:
			sb.append(sdf.format(cal.getTime()) + "\tπ´Ω¬∫Œ (Com : " + lab[2].getText() +
					", User : " + lab[3].getText() + ")\n");
			break;
		case 1:
		case -2:
			sb.append(sdf.format(cal.getTime()) + "\tCom Ω¬ (Com : " + lab[2].getText() +
					", User : " + lab[3].getText() + ")\n");
			break;
		case -1:
		case 2:
			sb.append(sdf.format(cal.getTime()) + "\tUser Ω¬ (Com : " + lab[2].getText() +
					", User : " + lab[3].getText() + ")\n");
			break;
		}
		
		jta.setText(sb.toString());
	}
}