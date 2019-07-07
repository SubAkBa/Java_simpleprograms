

class ThreadHandler extends Thread
{
	CountDown cd;
	String name;
	public ThreadHandler(CountDown cd, String name)
	{
		this.name = name;
		this.cd = cd;
	}
	public void run()
	{
		while(true)
			cd.Down(name);
	}
}