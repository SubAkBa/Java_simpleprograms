package ex1;

public class ThreadHandler extends Thread
{
	BioRhythm br;
	public ThreadHandler(BioRhythm br, String name)
	{
		this.br = br;
		setName(name);
	}
	public void run()
	{
		br.process(getName());
	}
}
