package ex1;

import java.util.*;

public class HighLow 
{
	String result = "";
	Random ran = new Random();
	int answer = ran.nextInt(100) + 1, user = 0, count = 6;
	public String Process(String usernum) {

		if(usernum.equals("시작"))
		{
			SetAnswer();
			result = "숫자가 재설정되었습니다.";
			return result;
		}
		
		if(count != 0)
		{
			user = Integer.parseInt(usernum);
			
			if(answer > user)
				result = "정답이 " + usernum + "보다 큽니다.";
			else if(answer < user)
				result = "정답이 " + usernum + "보다 작습니다.";
			else
				result = "정답입니다. 축하드립니다.\nServer : 다시 시작 하시겠습니까?";
			
			count--;
		}
		else
			result = "기회를 모두 소진하였습니다.\nServer : 다시시작해주세요.";
		
		return result;
	}
	private void SetAnswer()
	{
		count = 6;
		answer = ran.nextInt(100) + 1;
	}
}
