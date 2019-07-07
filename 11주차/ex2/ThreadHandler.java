package ex2;

import javax.swing.table.*;

public class ThreadHandler extends Thread
{
	DefaultTableModel dtm;
	Roulette rl;
	public ThreadHandler(Roulette rl, DefaultTableModel dtm)
	{
		this.dtm = dtm;
		this.rl = rl;
	}
	public void run()
	{
		while(true)
			dtm.addRow(rl.Process());
	}
}
