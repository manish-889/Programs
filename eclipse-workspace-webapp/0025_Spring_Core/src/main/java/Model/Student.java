package Model;

import java.util.List;

public class Student {

	private int id;
	private String name;
	List<String> language;
	Address adr;
	List<Account> acc;
	
	
	public void display() {
		System.out.println(id+" "+name);
		adr.display();
		for (String s : language) {
			System.out.println(s);
		}
		for (Account a : acc) {
			a.display();
		}
	}

	
	public List<Account> getAcc() {
		return acc;
	}


	public void setAcc(List<Account> acc) {
		this.acc = acc;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getLanguage() {
		return language;
	}

	public void setLanguage(List<String> language) {
		this.language = language;
	}

	public Address getAdr() {
		return adr;
	}

	public void setAdr(Address adr) {
		this.adr = adr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

