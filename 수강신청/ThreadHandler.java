package 수강신청;

class ThreadHandler extends Thread {
	SugangApply sa;
	int ID;

	public ThreadHandler(SugangApply sa, int ID) {
		this.sa = sa;
		this.ID = ID;
	}

	public void run() {
		sa.IngSugang(ID);
	}
}
