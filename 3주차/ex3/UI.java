
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

public class UI extends JFrame
{
	Container ct = getContentPane();
	JTextField[] jtf = {new JTextField("���� �ݾ�"),new JTextField("��ȯ �ݾ�")};
	JButton[] btn = new JButton[4];
	String[] str = {"�ݶ�(1000)", "���̴�(800)", "ȯŸ(700)", ""};
	JPanel pan = new JPanel();
	
	public UI()
	{
		setTitle("���Ǳ� UI �����");
		setSize(300,200);
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setLayout(new GridLayout(2,2));
		
		for(int i=0;i<btn.length;i++)
		{
			btn[i] = new JButton(str[i]);
			pan.add(btn[i]);
		}
		
		ct.add(jtf[0], BorderLayout.NORTH);
		ct.add(pan, BorderLayout.CENTER);
		ct.add(jtf[1], BorderLayout.SOUTH);
	}
}