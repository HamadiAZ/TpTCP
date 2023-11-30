package server;

import java.io.*;
import java.net.*;

import tp2TCP.model.Compte;

public class Handler extends Thread {
	Socket s;
	Boolean test = false;
	Compte compte;

	public Handler(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			while (true) {
				String msg = in.readLine();
				if (msg.startsWith("CREATION")) {
					String nom = msg.substring(9);
					if (!isCompteExist(nom)) {
						handleConnectedClient(in, out, nom);
					} else {
						out.println("Compte already exist, change the name");
					}
				} else {
					out.println("Unknown message type");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isCompteExist(String nom) {
		for (Compte c : Server.lc) {
			if (c.getNom().equals(nom)) {
				return true;
			}
		}
		return false;
	}

	public void handleConnectedClient(BufferedReader in, PrintWriter out, String nom) throws IOException {
		compte = new Compte(nom, 0);
		out.println("Le compte est créé avec succès");
		while (true) {
			String msg1 = in.readLine();
			
			if (msg1.startsWith("CREDIT")) {
				double montant = Double.parseDouble(msg1.substring(7));
				compte.addBalance(montant);
				out.println("Compte balance increased by " + montant +  " new balance " + compte.getBalance());
			}

			else if (msg1.startsWith("DEBIT")) {
				double montant = Double.parseDouble(msg1.substring(6));
				if (compte.substractBalance(montant)) {
					out.println("Operation Done : retrait " + montant + " new balance " + compte.getBalance());
				} else {
					out.println("balance is insufficient , cant substract " + montant +" from an account with balance " + compte.getBalance());
				}
			}

			else if (msg1.startsWith("SOLDE")) {
				out.println("your account balance is :" + compte.getBalance());
			}
			
			else {
				out.println("Unknown message type");
			}
		}
	}
}
