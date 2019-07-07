
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

public class UI extends JFrame implements ActionListener
{
	int num = 0;
	Container ct = getContentPane();
	JTextField jtf = new JTextField();
	JButton btn = new JButton("판별");
	JPanel pan = new JPanel();
	JLabel lab = new JLabel();
	
	public UI()
	{
		setTitle("홀짝판별");
		setSize(250,100);
		setLayout(new GridLayout(2,1));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setLayout(new GridLayout(1,2));
		pan.add(jtf);
		pan.add(btn);
		btn.addActionListener(this);
		ct.add(pan);
		ct.add(lab);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(jtf.getText().matches("[0-9]*"))
		{
			num = Integer.parseInt(jtf.getText());
			if(num % 2 == 0)
				lab.setText("짝수 입니다.");
			else
				lab.setText("홀수 입니다.");
		}
		else
			lab.setText("숫자를 입력하세요.");
		jtf.setText("");
	}
}