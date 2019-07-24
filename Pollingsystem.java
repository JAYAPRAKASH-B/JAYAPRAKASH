package pollingsystem;

import java.util.Scanner;

public class Pollingsystem {
	public static void pollLogin() {
		Voteoperation vo=new Voteoperation();
		Candidateoperation co=new Candidateoperation();
		Scanner sc=new Scanner(System.in);
		System.out.println("\n1.VOTER\n2.CANDIDATE\n enter the value");
		switch(sc.nextInt())
		{
		case 1:
			vo.voterLogin();
			break;
		case 2:
			co.candidateLogin();
			break;
		default:
			System.out.println("Enter the valid key");
		}
	}
	public static void main(String args[]) {
		pollLogin();
	}
}
