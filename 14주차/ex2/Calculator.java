package ex2;

import java.util.*;

public class Calculator 
{
	int count = 0, n1 = 0, n2 = 0;
	double res = 0;
	StringTokenizer st;
	String[] nums;
	String msg = "";
	public String Process(String msg)
	{
		count = 0;
		st = new StringTokenizer(msg, "+-*/%", true);
		nums = new String[st.countTokens()];
		
		while(st.hasMoreTokens())
			nums[count++] = st.nextToken();
		
		n1 = Integer.parseInt(nums[0]);
		n2 = Integer.parseInt(nums[2]);
		
		switch(nums[1])
		{
		case "+":
			res = n1 + n2;
			break;
		case "-":
			res = n1 - n2;
			break;
		case "*":
			res = n1 * n2;
			break;
		case "/":
			res = n1 / (double)n2;
			break;
		case "%":
			res = n1 % (double)n2;
			break;
		}
		
		msg = n1 + " " + nums[1] + " " + n2 + " = " + res;
		
		return msg;
	}
}
