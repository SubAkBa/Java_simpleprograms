import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;

public class 주사위게임 
{
	static int num;
	static int count = 0;
	static int[] numcount = {0,0,0,0,0,0};
	public static void main(String[] args) 
	{
		String[] s = new String[7];
		Random ran = new Random();
		
		JFrame frm = new JFrame("주사윅 게임");
		frm.setSize(250, 250);
		frm.setLayout(new BorderLayout());
		
		JLabel lab = new JLabel();
		lab.setHorizontalAlignment(JLabel.CENTER);
		lab.setFont(new Font("굴림체", Font.BOLD, 60));
		JButton btn = new JButton("던지기");
		btn.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{ 
						count++;
						num = ran.nextInt(6)+1;
						lab.setText(Integer.toString(num));
						switch(num)
						{
						case 1:
							numcount[0]++;
							break;
						case 2:
							numcount[1]++;
							break;
						case 3:
							numcount[2]++;
							break;
						case 4:
							numcount[3]++;
							break;
						case 5:
							numcount[4]++;
							break;
						case 6:
							numcount[5]++;
							break;
						}
						s[0] = "던진 횟수 : " + count + "\n";
						for(int i=0;i<6;i++)
							s[i+1] = (i+1) + " 나온 횟수 : " + numcount[i] + "\n";
						try
						{
							BufferedWriter bw = new BufferedWriter(new FileWriter("메모장.txt"));
							bw.write(s[0]+s[1]+s[2]+s[3]+s[4]+s[5]+s[6]);
							bw.close();
						}
						catch(IOException ie)
						{
							ie.getStackTrace();
						}
					}
				}
		);
		
		frm.add(lab, BorderLayout.CENTER);
		frm.add(btn, BorderLayout.SOUTH);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
