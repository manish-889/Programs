package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("savingAccount")
public class SavingAccount implements Account{
	
	@Autowired
	@Qualifier("retail")
	User u ;

	@Override
	public void deposite() {
		System.out.println("saving");
		u.userDetail();
	}

	
	
}
