import java.util.*;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ������ȯ�� {

	public static void main(String[] args)
	{
		String[] s = {"����", "��ġ", "��Ʈ", "�ߵ�"};
		
		JFrame frm = new JFrame("���� ��ȯ��");
		frm.setSize(300, 100);
		frm.setLayout(new BorderLayout());
		
		JButton btn = new JButton("��ȯ");
		
		JComboBox[] box = new JComboBox[2];
		JTextField[] jtf = new JTextField[2];
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(2,2));
		for(int i=0;i<2;i++)
		{
			box[i] = new JComboBox();
			jtf[i] = new JTextField();
			for(int j=0;j<4;j++)
				box[i].addItem(s[j]);
			pan.add(box[i]);
			pan.add(jtf[i]);
		}
		
		btn.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						Change c = new Change(box,jtf[0].getText());
						double d = (double)(Math.round(c.changeFunc()*1000))/1000;
						jtf[1].setText(Double.toString(d));
					}
				}
		);
		
		frm.add(pan, BorderLayout.CENTER);
		frm.add(btn, BorderLayout.EAST);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Change
{
	JComboBox[] jcb;
	String s;
	public Change(JComboBox[] jcb, String s)
	{
		this.jcb = jcb;
		this.s = s;
	}
	double changeFunc()
	{
		double result = 0.0;
		double num = Double.parseDouble(s);
		switch(jcb[0].getSelectedItem().toString())
		{
		case "����":
			switch(jcb[1].getSelectedItem().toString())
			{
			case "����":
				result = num;
				break;
			case "��ġ":
				result = num * 39.370079;
				break;
			case "��Ʈ":
				result = num * 3.28084;
				break;
			case "�ߵ�":
				result = num * 1.093613;
				break;
			}
			break;
		case "��ġ":
			switch(jcb[1].getSelectedItem().toString())
			{
			case "����":
				result = num / 29.370079;
				break;
			case "��ġ":
				result = num;
				break;
			case "��Ʈ":
				result = num / 39.370079 * 3.28084;
				break;
			case "�ߵ�":
				result = num / 39.370079 * 1.093613;
				break;
			}
			break;
		case "��Ʈ":
			switch(jcb[1].getSelectedItem().toString())
			{
			case "����":
				result = num / 3.28084;
				break;
			case "��ġ":
				result = num / 3.28084 * 39.370079;
				break;
			case "��Ʈ":
				result = num;
				break;
			case "�ߵ�":
				result = num / 3.28084 * 1.093613;
				break;
			}
			break;
		case "�ߵ�":
			switch(jcb[1].getSelectedItem().toString())
			{
			case "����":
				result = num / 1.093613;
				break;
			case "��ġ":
				result = num / 1.093613 * 39.370079;
				break;
			case "��Ʈ":
				result = num / 1.093613 * 3.28084;
				break;
			case "�ߵ�":
				result = num;
				break;
			}
			break;
		}
		
		return result;
	}
}