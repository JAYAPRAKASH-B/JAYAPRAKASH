package PollingSystem;
import java.sql.*;
import java.util.*;
public class VoteSystem {
	static int voterid;
	static String voterName,username,password;
	static Scanner sc=new Scanner(System.in);
public static void voter() throws SQLException {
	
		login();

}
public static void candidate() throws SQLException{
	System.out.println("enter your voter id and name");
	int voterid=sc.nextInt();
	String voterName=sc.next();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student1","root","10decoders");
	Statement stmt=con.createStatement();
	ResultSet re=stmt.executeQuery("select * from votingsystem WHERE voterid="+voterid);
	if(re.absolute(1))
	{
		System.out.println("already voted");
		con.close();
		return;
	}
	else
	{
		System.out.println("enter the username");
		username=sc.next();
		System.out.println("enter the password");
		password=sc.next();
		String query=("select * from voter where username='"+username+"' and password='"+password+"'");
		Statement sr=null;
		sr=con.createStatement();
		ResultSet r3=sr.executeQuery(query);
		while(r3.next())
		{
			String username=r3.getString(3);
			String password=r3.getString(4);
			if(username !=null && password !=null)
			{
				System.out.println("Welcome to voting");
				System.out.println("enter value to poll\n01.DK\n02.DMK\n03.ADMK");
				int votingNumber=sc.nextInt();
				System.out.println("enter the candidate id");
				int candidateid=sc.nextInt();
				System.out.println("candidate name and party name");	
				String candidatename=sc.next();
				String partyname=sc.next();
				String sql="insert into votingsystem values("+voterid+",'"+voterName+"',"+votingNumber+","+candidateid+",'"+candidatename+"','"+partyname+"')";
				
				int rs=stmt.executeUpdate(sql);
				if(rs==1)
				{
					System.out.println("voted successfully thank you");
				}
				else
				{
					System.out.println("failed to voting");
				}
			}
				else 
				{
					System.out.println("wrong username and password");
				}
		}
	}
}
public static void login() throws SQLException {
	
	
	System.out.println("enter the voter id,name");
	voterid=sc.nextInt();
	voterName=sc.next();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student1","root","10decoders");
	Statement stmt=con.createStatement();
	ResultSet rt=stmt.executeQuery("select * from votingsystem WHERE voterid="+voterid);
	if(rt.absolute(1)) {
		System.out.println("already voted");
		con.close();
		return;
	}
	else {
	System.out.println("enter the username");
	username=sc.next();
	System.out.println("enter the password");
	password=sc.next();
	String query=("select * from voter where username='"+username+"' and password='"+password+"'");
	Statement sr=null;
	sr=con.createStatement();
	ResultSet r3=sr.executeQuery(query);
	while(r3.next()) {
		String username=r3.getString(3);
		String password=r3.getString(4);
		if(username !=null && password !=null) {
			System.out.println("Welcome to voting");
			System.out.println("enter value to poll\n01.DK\n02.DMK\n03.ADMK");
			int votingNumber=sc.nextInt();
			System.out.println("enter the candidate id");
			int candidateid=sc.nextInt();
			System.out.println("candidate name and party name");	
			String candidatename=sc.next();
			String partyname=sc.next();
			String sql="insert into votingsystem values("+voterid+",'"+voterName+"',"+votingNumber+","+candidateid+",'"+candidatename+"','"+partyname+"')";
			
			int rs=stmt.executeUpdate(sql);
			if(rs==1)
			{
				System.out.println("voted successfully thank you");
			}
			else
			{
				System.out.println("failed to voting");
			}
		}
		else {
			System.out.println("wrong username and password");
		}
	}
	}
	}	



public static void main(String args[]) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student1","root","10decoders");
		Statement stmt=con.createStatement();
	System.out.println("WELCOME TO VOTING SYSTEM");
	System.out.println("enter to u are voter or candidate\n1.VOTER\n2.CANDIDATE\n");
	int n=sc.nextInt();
	switch(n) {
	case 1:
		voter();
		break;
	case 2:
		candidate();
	default:
		System.out.println("enter valid key");
		
	}
	}catch(Exception e){System.out.println(e);}
	}
}
