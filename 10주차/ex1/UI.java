package ex1;

import java.awt.*;

import javax.swing.*;

public class UI extends JFrame
{
	Container ct = getContentPane();
	JLabel lab = new JLabel();
	ThreadHandler t = new ThreadHandler(lab);
	public UI()
	{
		setTitle("µðÁöÅÐ ½Ã°è");
		setLayout(new FlowLayout());
		setSize(300, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lab.setHorizontalAlignment(JLabel.CENTER);
		lab.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 20));
		
		ct.add(lab, BorderLayout.SOUTH);
		t.start();
	}
}
