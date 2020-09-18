
class CountDown {
	boolean b = true;
	int Count;

	public CountDown(int Count) {
		this.Count = Count;
	}

	public synchronized void Down(String name) {
		if (b == true) {
			System.out.println(name + " : " + --Count);
			if (Count == 0) {
				b = false;
				System.out.println("Winner Thread ----> " + name);
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				ie.getStackTrace();
			}

		}
	}
}