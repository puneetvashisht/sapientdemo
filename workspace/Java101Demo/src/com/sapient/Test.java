package com.sapient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	private static Map<Integer, Bank> bankMap= new HashMap<>();

	public static void main(String[] args) {
		Atm atm1 = new Atm(1, "Marathalli");
		Atm atm2 = new Atm(2, "KRP");
		Atm atm3 = new Atm(3, "Whitefield");
		
		Branch branch1 = new Branch(1, "Marathalli");
		Branch branch2 = new Branch(11, "GK");
		Branch branch3 = new Branch(2, "CP");
		
		List<Branch> citiBranches = new ArrayList<>();
		citiBranches.add(branch1);
		citiBranches.add(branch2);
		List<Atm> citiAtms = new ArrayList<>();
		citiAtms.add(atm1);
		citiAtms.add(atm3);
		
		Bank citiBank = new Bank(1, "CITIBANK",citiBranches, citiAtms);
		bankMap.put(1, citiBank);
		System.out.println(bankMap);
		
		printBranches(1);

	}
	
	public static void printBranches(int bankId){
		System.out.println(bankMap.get(bankId).branches);
	}

}
