package Model;

public class Account {

	String accName;
	String bankName;
	
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public void display() {
		System.out.println(accName+" "+bankName);
	}
}
