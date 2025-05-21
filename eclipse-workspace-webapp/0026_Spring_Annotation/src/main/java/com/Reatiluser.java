package com;

import org.springframework.stereotype.Component;

@Component
public class Reatiluser implements User {

	@Override
	public void userDetail() {
		System.out.println("Reatil");
	}

}
