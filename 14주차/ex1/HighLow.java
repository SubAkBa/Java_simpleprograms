package ex1;

import java.util.*;

public class HighLow 
{
	String result = "";
	Random ran = new Random();
	int answer = ran.nextInt(100) + 1, user = 0, count = 6;
	public String Process(String usernum) {

		if(usernum.equals("����"))
		{
			SetAnswer();
			result = "���ڰ� �缳���Ǿ����ϴ�.";
			return result;
		}
		
		if(count != 0)
		{
			user = Integer.parseInt(usernum);
			
			if(answer > user)
				result = "������ " + usernum + "���� Ů�ϴ�.";
			else if(answer < user)
				result = "������ " + usernum + "���� �۽��ϴ�.";
			else
				result = "�����Դϴ�. ���ϵ帳�ϴ�.\nServer : �ٽ� ���� �Ͻðڽ��ϱ�?";
			
			count--;
		}
		else
			result = "��ȸ�� ��� �����Ͽ����ϴ�.\nServer : �ٽý������ּ���.";
		
		return result;
	}
	private void SetAnswer()
	{
		count = 6;
		answer = ran.nextInt(100) + 1;
	}
}
