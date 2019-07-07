

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
		
		System.out.print("보낼 프레임의 갯수를 입력 해 주세요 !! : ");
		int n = sc.nextInt();
		
		Socket myskt = new Socket("localhost",9999);
		PrintStream myps = new PrintStream(myskt.getOutputStream());
		
		for(int i = 0;i <= n;)
		{
			if(i == n)
			{
				myps.println("끝났어요 !!");
				break;
			}
			
			System.out.println("프레임 넘버 " + i + " 가 송신됐어요 !!");
			myps.println(i);
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(myskt.getInputStream()));
			String ack = bf.readLine();
			
			if(ack != null)
			{
				System.out.println("리시버로부터 수신응답이 왔어요 !!");
				i++;
				Thread.sleep(4000);
			}
			else
				myps.println(i);
		}
	}
}
