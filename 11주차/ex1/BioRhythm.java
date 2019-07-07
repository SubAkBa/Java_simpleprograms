package ex1;

import java.util.*;

public class BioRhythm 
{
	Calendar cal = Calendar.getInstance();
	Calendar birthcal = Calendar.getInstance();
	double[] indexnum = {0, 0, 0};
	int div = 0;
	String[] str;
	public void SetBirth(String birth)
	{
		cal.setTime(new Date());
		str = birth.split("-");
		birthcal.set(Integer.parseInt(str[0]),
				Integer.parseInt(str[1]), Integer.parseInt(str[2]));
	}
	synchronized public void process(String name)
	{
		div = 60 * 60 * 24 * 1000;
		switch(name)
		{
		case "body":
			div *= 23;
			indexnum[0] = Math.sin(2 * Math.PI * (birthcal.getTimeInMillis() -
					cal.getTimeInMillis()) / div);
			break;
		case "sense":
			div *= 28;
			indexnum[1] = Math.sin(2 * Math.PI * (birthcal.getTimeInMillis() -
					cal.getTimeInMillis()) / div);
			break;
		case "intel":
			div *= 33;
			indexnum[2] = Math.sin(2 * Math.PI * (birthcal.getTimeInMillis() -
					cal.getTimeInMillis()) / div);
			break;
		}
	}
	public double GetIndexnum(int i)
	{
		return indexnum[i];
	}
}
