package tp2TCP.model;

public class Compte {
	public User client;
	public String Nom;
	public double balance;
	public Compte() {
		// TODO Auto-generated constructor stub
	}
	public Compte(String Nom, double balance) {
		super();
		this.Nom = Nom;
		this.balance = balance;
	}
	public Compte(User client, String Nom, double balance) {
		super();
		this.client = client;
		this.Nom = Nom;
		this.balance = balance;
	}
	public User getUser() {
		return client;
	}
	public void setUser(User client) {
		this.client = client;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void addBalance(double value) {
		balance+=value;
	}
	public boolean substractBalance(double value) {
		if(value>balance) return false;
		balance-=value;
		return true;
	}

}
