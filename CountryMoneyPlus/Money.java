import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Money {
	boolean b = false;
	JLabel lab1;
	String s;
	int km = 0, jm = 0, cm = 0, tm = 0;

	public synchronized void setMoney(JLabel lab1, String s) {
		km = 0;
		jm = 0;
		cm = 0;
		tm = 0;
		notifyAll();
		b = true;
		this.s = s;
		this.lab1 = lab1;
	}

	public synchronized void process(JLabel lab) {
		if (b == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		switch (lab.getText().charAt(0)) {
		case 'K':
			KoreaMoney();
			lab.setText("Korea money : " + km);
			break;
		case 'J':
			JapanMoney();
			lab.setText("Japan money : " + jm);
			break;
		case 'C':
			ChinaMoney();
			lab.setText("China money : " + cm);
			break;
		}
		lab1.setText("Total money : " + tm);

		if (tm >= Integer.parseInt(s))
			b = false;
	}

	public synchronized void KoreaMoney() {
		km++;
		tm++;
	}

	public synchronized void JapanMoney() {
		jm++;
		tm++;
	}

	public synchronized void ChinaMoney() {
		cm++;
		tm++;
	}
}
