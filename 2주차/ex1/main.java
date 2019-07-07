import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) 
	{
		StringBuffer sb = new StringBuffer();
		int[] arr = {0, 0, 0, 0};
		String[] str;
		
		System.out.println(" ### WordCounter ###");
		System.out.println("¹®ÀÚ¿­À» ÀÔ·ÂÇÏ½Ã¿À...");
		str = (new Scanner(System.in).nextLine()).split("");
		
		for(String s : str)
		{
			if(s.matches("[¤¡-¤¾°¡-ÆR]"))
				arr[0]++;
			else if(s.matches("[a-zA-Z]"))
				arr[1]++;
			else if(s.matches("[0-9]"))
				arr[2]++;
			else
				arr[3]++;
		}
		
		sb.append(" ### Ä«¿îÆ® °á°ú ###\nÇÑ±Û : " + arr[0] + "\n¿µ¾î : " + arr[1] +
				"\n¼ıÀÚ : " + arr[2] + "\n±âÅ¸ : " + arr[3]);
		System.out.println(sb.toString());
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt")))
		{
			bw.write(sb.toString());
			System.out.println("ÆÄÀÏÀúÀå¿Ï·á");
		}
		catch(IOException ie)
		{
			ie.getStackTrace();
		}
	}

}
