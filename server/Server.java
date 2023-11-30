package server;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

import tp2TCP.model.Compte;

public class Server {
	public static List<Compte> lc = new ArrayList<Compte>();

	public Server() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		try {

			ServerSocket sc = new ServerSocket(4000);
			while (true) {
				Socket s = sc.accept();
				Handler h = new Handler(s);
				h.start();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
