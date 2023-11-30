package tp2TCP.model;

public class User {
	public static int counter = 1;
	public int id;
	public String ip;
	public int port;
	
	public User() {
		this.id=counter++;
	}
	public User(String ip,int port) {
		this.id=counter++;
		this.ip=ip;
		this.port=port;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		User.counter = counter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

}
