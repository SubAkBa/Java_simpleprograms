

import java.io.*;

import java.net.*;

import java.util.Scanner;

class stopwaitsender
{
	public static void main(String args[]) throws Exception
	{
		stopwaitsender sws = new stopwaitsender();
		sws.run();
	}
	
	public void run() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �������� ������ �Է� �� �ּ��� !! : ");
		int n = sc.nextInt();
		
		Socket myskt = new Socket("localhost",9999);
		PrintStream myps = new PrintStream(myskt.getOutputStream());
		
		for(int i = 0;i <= n;)
		{
			if(i == n)
			{
				myps.println("������� !!");
				break;
			}
			
			System.out.println("������ �ѹ� " + i + " �� �۽ŵƾ�� !!");
			myps.println(i);
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(myskt.getInputStream()));
			String ack = bf.readLine();
			
			if(ack != null)
			{
				System.out.println("���ù��κ��� ���������� �Ծ�� !!");
				i++;
				Thread.sleep(4000);
			}
			else
				myps.println(i);
		}
	}
}
