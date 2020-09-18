
import java.io.*;
import javax.swing.*;

class ThreadHandler extends Thread {
	DataInputStream dis;
	DefaultListModel dlm;

	public ThreadHandler(DataInputStream dis, DefaultListModel dlm) {
		this.dis = dis;
		this.dlm = dlm;
	}

	public void run() {
		while (true) {
			try {
				String s1 = dis.readUTF();
				dlm.addElement("서버 : " + s1);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}