package com.ritik.daoimp;

import java.util.ArrayList;

import com.ritik.Account;
import com.ritik.Statement;
import com.ritik.dao.Accountdemo;

public class Accountdemoimpl implements Accountdemo {

    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Statement>statements = new ArrayList<>();
    Account a = new Account();
    
    @Override
	public boolean opeanAcc(Account acc) {
		 boolean flag =  accounts.add(acc);
		  if(flag)	
			return true;
		 else
			 return false;
	}
	
    @Override
	public boolean deposite(int amt, long acc) {
	 for (Account account : accounts) {
		  if(account.getAccount_no() == acc) {
			  if(amt>0) {
			  account.setBalance(account.getBalance()+amt);
			  Statement s = new Statement(account);
			  s.setDeposite(amt);
			  s.setWithdrwal(0);
			  statements.add(s);
		      return true;    
			  }
			 }
	      }
	        return false; 
	}

	@Override
	public boolean withdrwal(int amt,long acc) {
		 for (Account account : accounts) {
			  if(account.getAccount_no() == acc) {
				  if(amt>0 && account.getBalance()>=amt) {
				  account.setBalance(account.getBalance()-amt);
				  Statement s = new Statement(account);
				  s.setWithdrwal(amt);
				  s.setDeposite(0);
				  statements.add(s);
			      return true;    
				  }
				}
		      }
		        return false; 
	  }
	
	  @Override
	  public Account searchAccount(long acno) {
	        for (Account account : accounts) {
	            if (account.getAccount_no() == acno) {
	                return account;
	            }
	        }
			return null;
	    }

	@Override
	public boolean transaction(int amt,long accno1,long accno2) {
		if(accno1 != accno2) {
		boolean flag = withdrwal(amt, accno1);
		boolean flag1 = deposite(amt, accno2);
		return flag && flag1;
		}else
		   return false;		
	}
	
	@Override
	public void statement(long acc) {
		boolean flag = false;
		for (Statement statement : statements) {
			if(statement.getAccount_no() == acc) {
				if(!flag) {
				statement.showdetails();
				flag=true;
				}
			System.out.println(statement);
			}
		}
		
	}
	
	
	


}
