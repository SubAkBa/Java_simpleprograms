
import java.util.*;

import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

class ThreadHandler extends Thread {
	DefaultListModel dlm;
	DatagramSocket ds;
	DatagramPacket dp;
	byte[] buffer = new byte[30];

	public ThreadHandler(DefaultListModel dlm, int port) {
		this.dlm = dlm;
		try {
			ds = new DatagramSocket(port);
			dp = new DatagramPacket(buffer, buffer.length);
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}

	public void run() {
		String s;
		while (true) {
			try {
				ds.receive(dp);
				s = new String(dp.getData());
				dlm.addElement("���� : " + s);
			} catch (Exception ex) {
				ex.getStackTrace();
			}
		}
	}
}
