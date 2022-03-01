package org.czobot.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.czobot.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	// add a new method: findAccounts()
	public List<Account> findAccounts(boolean tripWire) {
		
		// simulate an exceptions
		if(tripWire) {
			throw new RuntimeException("Excepion message");
		}
		
		List<Account> accounts = new ArrayList<Account>() {
			{
				add(new Account("John", "Silver"));
				add(new Account("Peter", "Gold"));
				add(new Account("Susan", "Platinum"));
			}
		};
		
		return accounts;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public void doWork() {
		
		System.out.println(getClass() + ": doWork()");
		
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
