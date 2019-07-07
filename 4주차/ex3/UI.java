
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.text.*;

public class UI extends JFrame implements ActionListener
{
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY�� MM�� dd�� a HH�� MM�� ss��");
	Calendar cal;
	Container ct = getContentPane();
	JPanel[] pan = {new JPanel(), new JPanel()};
	JButton curbtn = new JButton("���� �ð� ���");
	JTextField curjtf = new JTextField();
	JButton nbtn = new JButton("N�ð� �� ���");
	JTextField[] njtf = {new JTextField(), new JTextField()};
	
	public UI()
	{
		setTitle("�ð� ��� ���α׷�");
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
				njtf[1].setText("���� �ð��� ������ּ���");
			else
			{
				if(!njtf[0].getText().equals("") && njtf[0].getText().matches("[0-9]*"))
				{
					cal.add(Calendar.HOUR, Integer.parseInt(njtf[0].getText()));
					njtf[1].setText(sdf.format(cal.getTime()));
				}
				else
					njtf[1].setText("���ڸ� �Է����ּ���.");
			}
		}
	}
}