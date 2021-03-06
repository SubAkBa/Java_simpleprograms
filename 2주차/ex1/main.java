import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) 
	{
		StringBuffer sb = new StringBuffer();
		int[] arr = {0, 0, 0, 0};
		String[] str;
		
		System.out.println(" ### WordCounter ###");
		System.out.println("문자열을 입력하시오...");
		str = (new Scanner(System.in).nextLine()).split("");
		
		for(String s : str)
		{
			if(s.matches("[ㄱ-ㅎ가-힣]"))
				arr[0]++;
			else if(s.matches("[a-zA-Z]"))
				arr[1]++;
			else if(s.matches("[0-9]"))
				arr[2]++;
			else
				arr[3]++;
		}
		
		sb.append(" ### 카운트 결과 ###\n한글 : " + arr[0] + "\n영어 : " + arr[1] +
				"\n숫자 : " + arr[2] + "\n기타 : " + arr[3]);
		System.out.println(sb.toString());
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt")))
		{
			bw.write(sb.toString());
			System.out.println("파일저장완료");
		}
		catch(IOException ie)
		{
			ie.getStackTrace();
		}
	}

}
