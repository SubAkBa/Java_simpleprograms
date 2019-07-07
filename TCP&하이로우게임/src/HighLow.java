import java.util.Random;

class HighLow 
{	
	Random ran = new Random();
	int answer = ran.nextInt(100) + 1;
	public int process(int num)
	{
		if(answer > num)
			return -1;
		else if(answer < num)
			return 1;
		else
			return 0;
	}
	public void NewsetNum()
	{
		answer = ran.nextInt(100)+1;
	}
}
