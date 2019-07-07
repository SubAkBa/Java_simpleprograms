package ex2;

public class ThreadHandler extends Thread
{
	StopWatch sw;
	public ThreadHandler(StopWatch sw)
	{
		this.sw = sw;
	}
	public void run()
	{
		while(true)
			sw.Process();
	}
}
