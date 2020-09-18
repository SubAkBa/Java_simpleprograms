import java.util.*;
import java.text.*;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

class ThreadHandler extends Thread {
	RiceProcess rp;
	JLabel lab1, lab2;
	int ricenum, totalricenum;

	public ThreadHandler(RiceProcess rp, JLabel lab1, JLabel lab2) {
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.rp = rp;
	}

	public void run() {
		while (true) {
			ricenum = rp.MinusRice();
			totalricenum = rp.getTotalRice();
			lab1.setText(Integer.toString(ricenum) + " kg");
			lab2.setText("총 소비량 : " + totalricenum + " kg");
			try {
				sleep(10);
			} catch (InterruptedException ie) {
				ie.getStackTrace();
			}
		}
	}
}