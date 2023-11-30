package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;

public class Client {

	public static void main(String args[]) {
		try {
			Socket s = new Socket("127.0.0.1", 4000);
			BufferedReader ServerReceive = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter ServerSend = new PrintWriter(s.getOutputStream(), true);

			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				String msg = clavier.readLine();
				ServerSend.println(msg);
				System.out.println(ServerReceive.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}