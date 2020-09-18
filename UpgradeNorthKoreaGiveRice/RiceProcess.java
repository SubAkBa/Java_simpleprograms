
class RiceProcess {
	boolean b1 = false;
	int ricenum, totalricenum;

	public void setRiceNum(int ricenum) {
		this.ricenum = ricenum;
		b1 = true;
	}

	public synchronized int MinusRice() {
		if (b1 == false) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.getStackTrace();
			}
		}
		ricenum--;
		totalricenum++;

		if (ricenum == 0)
			b1 = false;

		return ricenum;
	}

	public synchronized void PlusRice(int rnum) {
		notify();
		b1 = true;
		ricenum += rnum;
	}

	public int getTotalRice() {
		return totalricenum;
	}
}
