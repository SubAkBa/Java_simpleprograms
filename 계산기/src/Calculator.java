import java.util.*;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Calculator 
{
	int n1, n2, pr;
	double result = 0;
	String[] sa;
	String s, s1;
	DefaultListModel dlm;
	public void setCalculator(DefaultListModel dlm, String s)
	{
		this.dlm = dlm;
		this.s = s;
	}
	public void Process()
	{
		StringTokenizer st = new StringTokenizer(s, "+-*/%", true);
		sa = new String[st.countTokens()];
		for(int i=0;i<sa.length;i++)
			sa[i] = st.nextToken();
		
		switch(sa.length)
		{
		case 5:
			n1 = Priority(sa[1]);
			n2 = Priority(sa[3]);
			if(n1 < n2)
			{
				switch(sa[3])
				{
				case "+":
					result = Double.parseDouble(sa[2]) + Double.parseDouble(sa[4]);
					break;
				case "-":
					result = Double.parseDouble(sa[2]) - Double.parseDouble(sa[4]);
					break;
				case "*":
					result = Double.parseDouble(sa[2]) * Double.parseDouble(sa[4]);
					break;
				case "/":
					result = Double.parseDouble(sa[2]) / Double.parseDouble(sa[4]);
					break;
				}
				double temp = Double.parseDouble(sa[0]);
				switch(sa[1])
				{
				case "+":
					temp += result;
					result = temp;
					break;
				case "-":
					temp -= result;
					result = temp;
					break;
				case "*":
					temp *= result;
					result = temp;
					break;
				case "/":
					temp /= result;
					result = temp;
					break;
				}
			}
			else
			{
				switch(sa[1])
				{
				case "+":
					result = Double.parseDouble(sa[0]) + Double.parseDouble(sa[2]);
					break;
				case "-":
					result = Double.parseDouble(sa[0]) - Double.parseDouble(sa[2]);
					break;
				case "*":
					result = Double.parseDouble(sa[0]) * Double.parseDouble(sa[2]);
					break;
				case "/":
					result = Double.parseDouble(sa[0]) / Double.parseDouble(sa[2]);
					break;
				}
				switch(sa[3])
				{
				case "+":
					result += Double.parseDouble(sa[4]);
					break;
				case "-":
					result -= Double.parseDouble(sa[4]);
					break;
				case "*":
					result *= Double.parseDouble(sa[4]);
					break;
				case "/":
					result /= Double.parseDouble(sa[4]);
					break;
				}
			}
			break;
		case 3:
			switch(sa[1])
			{
			case "+":
				result = Double.parseDouble(sa[0]) + Double.parseDouble(sa[2]);
				break;
			case "-":
				result = Double.parseDouble(sa[0]) - Double.parseDouble(sa[2]);
				break;
			case "*":
				result = Double.parseDouble(sa[0]) * Double.parseDouble(sa[2]);
				break;
			case "/":
				result = Double.parseDouble(sa[0]) / Double.parseDouble(sa[2]);
				break;
			}
			break;
		}
		
		dlm.addElement(s + " : " + result);
	}
	public int Priority(String op)
	{
		switch(op)
		{
		case "+":
		case "-":
			pr = 1;
			break;
		case "*":
		case "/":
			pr = 2;
			break;
		}
		
		return pr;
	}
}
