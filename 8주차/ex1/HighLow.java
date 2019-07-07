package ex1;

import java.util.*;

public class HighLow 
{
	int count = 0;
	String result = "";
	Random ran = new Random();
	int answer, comnum;
	int maxnum = 100, minnum = 1;
	
	public void SetAnswer(int answer)
	{
		count = 0;
		this.answer = answer;
	}
	public int GameProcess()
	{
		comnum = ran.nextInt(maxnum-minnum+1) + minnum;
		count++;
		if(answer < comnum)
		{
			maxnum = comnum;
			result = comnum + "��(��) ���亸�� Ů�ϴ�.";
			return 1;
		}
		else if(answer > comnum)
		{
			minnum = comnum;
			result = comnum + "��(��) ���亸�� �۽��ϴ�.";
			return 1;
		}
		else
		{
			result = comnum + "��(��) �����Դϴ�.";
			return 0;
		}
	}
	public int Counting()
	{
		return count;
	}
	public String ResultFunc()
	{
		return result;
	}
}
