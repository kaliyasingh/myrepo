package com.ritik.dao;

import com.ritik.Account;

public interface Accountdemo {
	
	public boolean opeanAcc(Account a);
	public boolean withdrwal(int amt ,long acc) ;
	public boolean deposite(int amt, long acc);
    public Account searchAccount(long acno);
	public boolean transaction(int amt ,long acc,long acc2);
	public void statement(long acc);

}
