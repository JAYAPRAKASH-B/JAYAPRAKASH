package pollingsystem;
public class Voter{
	private int voterid;
	private String username,password;
	public int getVoterid() {
		return voterid;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setVoterid(int voterid) {
		this.voterid=voterid;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	Voter(){}
	public Voter(int voterid, String username, String password) {
		super();
		this.voterid=voterid;
		this.username=username;
		this.password=password;
		
	}
}


