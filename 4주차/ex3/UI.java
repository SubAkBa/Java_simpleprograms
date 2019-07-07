
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.text.*;

public class UI extends JFrame implements ActionListener
{
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일 a HH시 MM분 ss초");
	Calendar cal;
	Container ct = getContentPane();
	JPanel[] pan = {new JPanel(), new JPanel()};
	JButton curbtn = new JButton("현재 시간 출력");
	JTextField curjtf = new JTextField();
	JButton nbtn = new JButton("N시간 후 출력");
	JTextField[] njtf = {new JTextField(), new JTextField()};
	
	public UI()
	{
		setTitle("시간 출력 프로그램");
		setSize(800,130);
		setLayout(new GridLayout(2,1));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan[0].setLayout(new GridLayout(1,2));
		pan[1].setLayout(new GridLayout(1,3));
		
		curbtn.setHorizontalAlignment(JButton.CENTER);
		curjtf.setHorizontalAlignment(JTextField.CENTER);
		
		curbtn.addActionListener(this);
		pan[0].add(curbtn);
		pan[0].add(curjtf);
		
		nbtn.setHorizontalAlignment(JButton.CENTER);
		njtf[0].setHorizontalAlignment(JTextField.CENTER);
		njtf[1].setHorizontalAlignment(JTextField.CENTER);
		
		nbtn.addActionListener(this);
		pan[1].add(nbtn);
		pan[1].add(njtf[0]);
		pan[1].add(njtf[1]);
		
		ct.add(pan[0]);
		ct.add(pan[1]);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == curbtn)
		{
			cal = Calendar.getInstance();
			curjtf.setText(sdf.format(cal.getTime()));
		}
		else if(e.getSource() == nbtn)
		{
			if(curjtf.getText().equals(""))
				njtf[1].setText("현재 시간을 출력해주세요");
			else
			{
				if(!njtf[0].getText().equals("") && njtf[0].getText().matches("[0-9]*"))
				{
					cal.add(Calendar.HOUR, Integer.parseInt(njtf[0].getText()));
					njtf[1].setText(sdf.format(cal.getTime()));
				}
				else
					njtf[1].setText("숫자를 입력해주세요.");
			}
		}
	}
}