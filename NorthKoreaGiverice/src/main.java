import java.util.*;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

public class main 
{
	static boolean b1 = false;
	public static void main(String args[])
	{		
		JFrame frm = new JFrame("∫œ«— Ω“ ¡÷±‚");
		frm.setSize(300, 100);
		frm.setLayout(new GridLayout(2,0));
		
		JLabel lab1 = new JLabel("∫œ«— Ω“ : ");
		JLabel lab2 = new JLabel("0 kg");
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(0,2));
		pan1.add(lab1);
		pan1.add(lab2);
		
		JLabel lab3 = new JLabel("Ω“ ∫∏≥ª±‚ : ");
		JTextField jtf = new JTextField();
		JButton btn = new JButton("∫∏≥ª±‚");
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(0,3));
		pan2.add(lab3);
		pan2.add(jtf);
		pan2.add(btn);
		
		Riceprocess rp = new Riceprocess();
		ThreadHandler t = new ThreadHandler(rp, lab2);
		
		btn.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(b1 == false)
						{
							rp.setRiceprocess(Integer.parseInt(jtf.getText()));
							t.start();
							
							b1 = true;
						}
						else
							rp.PlusRice(Integer.parseInt(jtf.getText()));
						
						jtf.setText("");
					}
				}
		);
		
		frm.add(pan1);
		frm.add(pan2);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}