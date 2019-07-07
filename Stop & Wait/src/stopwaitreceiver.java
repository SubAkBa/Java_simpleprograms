

import java.io.*;

import java.net.*;

class stopwaitreceiver
{
	public static void main(String args[]) throws Exception
	{
		stopwaitreceiver swr = new stopwaitreceiver();
		swr.run();
	}
	
	public void run() throws Exception
	{
		String temp = "";
		String str = "끝났어요 !!";
		ServerSocket myss = new ServerSocket(9999);
		Socket ss_accept = myss.accept();
		BufferedReader ss_bf = new BufferedReader(new InputStreamReader(ss_accept.getInputStream()));
		PrintStream myps = new PrintStream(ss_accept.getOutputStream());
		
		while(temp.compareTo(str) != 0)
		{
			Thread.sleep(1000); 
			temp = ss_bf.readLine();
			if(temp.compareTo(str) == 0)
				break;
			System.out.println("프레임 " + temp + " 이 수신됐어요 !!");
			Thread.sleep(500);
			myps.println("수신됐어요 !!");
		}
		
		System.out.println("모든 프레임이 성공적으로 수신됐어요 !!\n");
	}
}