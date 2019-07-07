
public class ThreadHandler extends Thread
{
	CountryMoney cm;
	public ThreadHandler(String name, CountryMoney cm)
	{
		setName(name);
		this.cm = cm;
	}
	public void run() 
	{
		while(true)
			cm.Process(getName());
	}
}
