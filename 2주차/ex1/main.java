import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) 
	{
		StringBuffer sb = new StringBuffer();
		int[] arr = {0, 0, 0, 0};
		String[] str;
		
		System.out.println(" ### WordCounter ###");
		System.out.println("���ڿ��� �Է��Ͻÿ�...");
		str = (new Scanner(System.in).nextLine()).split("");
		
		for(String s : str)
		{
			if(s.matches("[��-����-�R]"))
				arr[0]++;
			else if(s.matches("[a-zA-Z]"))
				arr[1]++;
			else if(s.matches("[0-9]"))
				arr[2]++;
			else
				arr[3]++;
		}
		
		sb.append(" ### ī��Ʈ ��� ###\n�ѱ� : " + arr[0] + "\n���� : " + arr[1] +
				"\n���� : " + arr[2] + "\n��Ÿ : " + arr[3]);
		System.out.println(sb.toString());
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt")))
		{
			bw.write(sb.toString());
			System.out.println("��������Ϸ�");
		}
		catch(IOException ie)
		{
			ie.getStackTrace();
		}
	}

}
