class Riceprocess 
{
	boolean b1 = false;
	int ricenum;
	public void setRiceprocess(int ricenum)
	{
		this.ricenum = ricenum;
		b1 = true;
	}
	public synchronized int Minusrice()
	{
		if(b1 == false)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ie)
			{
				ie.getStackTrace();
			}
		}
		if(ricenum <= 1)
			b1 = false;
		ricenum--;
		
		return ricenum;
	}
	public synchronized void PlusRice(int ricenum)
	{
		if(b1 == false)
		{
			notify();
			b1 = true;
		}
		this.ricenum += ricenum;
	}
}