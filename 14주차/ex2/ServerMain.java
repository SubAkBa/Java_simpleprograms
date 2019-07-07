package ex2;

public class ServerMain {

	public static void main(String[] args) {
		Server s = new Server("127.0.0.1", "7777");
		s.start();
	}

}
