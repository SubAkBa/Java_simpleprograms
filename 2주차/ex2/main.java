import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) 
	{
		final int Tcount = 5;
		String[] temp = new String[4];
		double[] winrate = new double[Tcount];
		int[] rank = {1,1,1,1,1};
		String s = "";
		StringBuffer sb = new StringBuffer();
		String[] team = new String[Tcount];
		try(BufferedReader br = new BufferedReader(new FileReader("Baseball.txt")))
		{
			while((s = br.readLine()) != null)
				sb.append(s + "\n");
		}
		catch(IOException ie)
		{
			ie.getStackTrace();
		}
		System.out.println("### ¾ß±¸ÆÀ ½Â·ü/¼øÀ§ ±¸ÇÏ±â ###\n" + sb.toString());
		
		for(int i=0;i<Tcount;i++)
		{
			team[i] = sb.toString().split("\n")[i+2];
			temp = team[i].split("\t");
			winrate[i] = (Double.parseDouble(temp[1]) / (Double.parseDouble(temp[1])
					+ Double.parseDouble(temp[2]) + Double.parseDouble(temp[3]))) * 100;
		}
		
		for(int i=0;i<Tcount;i++)
		{
			for(int j=i+1;j<Tcount;j++)
			{
				if(winrate[i] > winrate[j])
					rank[j]++;
				else
					rank[i]++;
			}
		}
		sb.delete(0, sb.length());
		
		sb.append("ÆÀ\t½Â\t¹«\tÆÐ\t½Â·ü\t¼øÀ§\n"
				+ "-------------------------------------------\n");
		for(int i=0;i<Tcount;i++)
			sb.append(team[i] + "\t" + String.format("%.2f", winrate[i]) + 
					"%\t"+ rank[i] + "µî\n");
		
		System.out.println(sb.toString());
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt")))
		{
			bw.write(sb.toString());
		}
		catch(IOException ie)
		{
			ie.getStackTrace();
		}
	}
}
