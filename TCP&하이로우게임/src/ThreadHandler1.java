
import java.io.*;
import java.net.*;

class ThreadHandler1 extends Thread
{
	int count = 0;
	DataInputStream dis;
	DataOutputStream dos;
	Socket s;
	HighLow hl = new HighLow();
	int n;
	public ThreadHandler1(Socket s)
	{
		this.s = s;
		try
		{
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
	}
	public void run()
	{
		while(true)
		{
			try
			{
				String s = dis.readUTF();
				if(s.equals("시작"))
				{
					count = 0;
					hl.NewsetNum();
					dos.writeUTF("숫자가 재설정되었어요.");					
				}
				else
				{
					if(count<6)
					{
						count++;
						n = hl.process(Integer.parseInt(s));
						switch(n)
						{
						case -1:
							dos.writeUTF("정답이 " + s + "보다 커요.");
							break;
						case 0:
							dos.writeUTF("정답이에요. 축하드려요. 다시 시작 할래요?");
							count = 0;
							break;
						case 1:
							dos.writeUTF("정답이 " + s + "보다 작아요.");
							break;
						}
						dos.writeUTF("기회가 " + (6 - count) + "번 남았어요.");
					}
					if(count == 6)
						dos.writeUTF("기회를 6번 다쓰셨어요 !! 다시 할래요?");
				}
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
		}
	}
}
