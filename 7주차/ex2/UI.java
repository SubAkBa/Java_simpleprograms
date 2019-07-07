package ex2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame implements ActionListener
{
	FileManager fm = new FileManager();
	Container ct = getContentPane();
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	JPanel pan = new JPanel();
	JButton[] btn = new JButton[3];
	String[] str = {"����", "����", "�����"};
	public UI()
	{
		setTitle("�����Ѹ޸���");
		setLayout(new BorderLayout());
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pan.setLayout(new GridLayout(1,3));
		for(int i=0;i<btn.length;i++)
		{
			btn[i] = new JButton(str[i]);
			btn[i].addActionListener(this);
			pan.add(btn[i]);
		}
		
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(pan, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "����":
			fm.WriteFunc(jta.getText());
			break;
		case "����":
			jta.setText(fm.ReadFunc());
			break;
		case "�����":
			jta.setText("");
			break;
		}
	}
}

