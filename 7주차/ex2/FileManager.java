package ex2;

import java.io.*;

public class FileManager
{
	BufferedWriter bw;
	BufferedReader br;
	String s = "";
	StringBuffer sb = new StringBuffer();
	public FileManager()
	{
		try
		{
			bw = new BufferedWriter(new FileWriter("memo.txt"));
			br = new BufferedReader(new FileReader("memo.txt"));
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
	}
	public void WriteFunc(String memo)
	{
		try
		{
			bw.write(memo);
			bw.close();
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
	}
	public String ReadFunc()
	{
		try
		{
			while((s = br.readLine()) != null)
				sb.append(s + "\n");
			br.close();
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
		return sb.toString();
	}
}
