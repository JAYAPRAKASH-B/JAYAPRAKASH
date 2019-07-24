package pollingsystem;

import java.util.Scanner;
import java.sql.*;

public class Voteoperation {
	
		static Dbconnection get=new Dbconnection();
		
	public static void voterLogin() {
		try {	
		Connection con=get.connectDb();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the voterid");
		int voterid=sc.nextInt();
		System.out.println("enter the voterName");
		String voterName=sc.next();
		Statement stmt=null;
		Statement st=null;
		String query="select * from voter where voterid="+voterid;
		stmt=con.prepareStatement(query);
		ResultSet rs=stmt.executeQuery(query);
		if(rs.absolute(1))
		{
			System.out.println("You are already voted ");
			con.close();
			return;
		}
		else {
			System.out.println("enter your user name ");
			String username=sc.next();
			System.out.println("enter the password");
			String password=sc.next();
			String qry=("select * from voter where username='"+username+"' and password='"+password+"'");
			Statement sr=null;
			sr=con.createStatement();
			ResultSet r3=sr.executeQuery(qry);
			while(r3.next())
			{
				String username1=r3.getString(3);
				String password1=r3.getString(4);
				if(username1 !=null && password1 !=null)
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
					int ry=stmt.executeUpdate(sql);
					if(ry==1)
					{
						System.out.println("voted successfully thank you");
					}
					else
					{
						System.out.println("failed to voting");
					}
		}
	}
		}	
	}catch(Exception e) {
		System.out.println("no available");
	}
	}
	
	}
