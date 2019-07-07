
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
				if(s.equals("����"))
				{
					count = 0;
					hl.NewsetNum();
					dos.writeUTF("���ڰ� �缳���Ǿ����.");					
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
							dos.writeUTF("������ " + s + "���� Ŀ��.");
							break;
						case 0:
							dos.writeUTF("�����̿���. ���ϵ����. �ٽ� ���� �ҷ���?");
							count = 0;
							break;
						case 1:
							dos.writeUTF("������ " + s + "���� �۾ƿ�.");
							break;
						}
						dos.writeUTF("��ȸ�� " + (6 - count) + "�� ���Ҿ��.");
					}
					if(count == 6)
						dos.writeUTF("��ȸ�� 6�� �پ��̾�� !! �ٽ� �ҷ���?");
				}
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
		}
	}
}
