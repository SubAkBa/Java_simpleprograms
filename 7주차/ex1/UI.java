
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.event.*;
import java.io.*;
import java.text.*;

public class UI extends JFrame implements KeyListener
{
	Container ct = getContentPane();
	JLabel[] lab = new JLabel[3];
	JComboBox jcb = new JComboBox();
	JTextField[] jtf = {new JTextField(), new JTextField()};
	JPanel[] pan = {new JPanel(), new JPanel()};
	String[] str = {"2����", "8����", "10����", "16����"};
	String[] title = {"���� ����", "�Է� ����", "��� ���"};
	
	public UI()
	{
		setTitle("���� ��ȯ��");
		setSize(200,200);
		setLayout(new GridLayout(1,2));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan[0].setLayout(new GridLayout(3,1));
		pan[1].setLayout(new GridLayout(3,1));
		for(String s : str)
			jcb.addItem(s);
		pan[1].add(jcb);
		for(int i=0;i<3;i++)
		{
			lab[i] = new JLabel(title[i]);
			lab[i].setHorizontalAlignment(JLabel.CENTER);
			pan[0].add(lab[i]);
			if(i != 2)
				pan[1].add(jtf[i]);
		}
		jtf[0].addKeyListener(this);
		
		ct.add(pan[0]);
		ct.add(pan[1]);
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if(!jtf[0].getText().equals("") && jtf[0].getText().matches("^[0-9]*$"))
			{
				switch(jcb.getSelectedIndex())
				{
				case 0:
					jtf[1].setText(Integer.toBinaryString(Integer.parseInt(jtf[0].getText())));
					break;
				case 1:
					jtf[1].setText(Integer.toOctalString(Integer.parseInt(jtf[0].getText())));
					break;
				case 2:
					jtf[1].setText(Integer.toString(Integer.parseInt(jtf[0].getText())));
					break;
				case 3:
					jtf[1].setText(Integer.toHexString(Integer.parseInt(jtf[0].getText())));
					break;
				}
			}
			else
				jtf[1].setText("���ڸ� \n�Է��ϼ���.");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}