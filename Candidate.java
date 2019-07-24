package pollingsystem;

public class Candidate {
 private int voterid;
 private String username;
 private String password;
 private String partyname;
 Candidate(){}
 public int getVoterid() {
	 return voterid;
 }
 public String getUsername() {
	 return username;
 }
 public String getPassword() {
	 return password;
 }
 public String getPartyname() {
	 return partyname;
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
 public void setPartyname(String partyname) {
	 this.partyname=partyname;
 }
 public Candidate(int voterid,String username,String password, String partyname) {
	 super();
	 this.voterid=voterid;
	 this.username=username;
	 this.password=password;
	 this.partyname=partyname;
 }
}
