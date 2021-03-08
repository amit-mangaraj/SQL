package Model;

public class Team {
	private int team_id;
	private String Teamname;
	private String ownername;
	private String coachname;
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeamname() {
		return Teamname;
	}
	public void setTeamname(String teamname) {
		Teamname = teamname;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getCoachname() {
		return coachname;
	}
	public void setCoachname(String coachname) {
		this.coachname = coachname;
	}
	public Team(int team_id, String teamname, String ownername, String coachname) {
		super();
		this.team_id = team_id;
		Teamname = teamname;
		this.ownername = ownername;
		this.coachname = coachname;
	}
	public Team() {
		super();
	}
	
	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", Teamname=" + Teamname + ", ownername=" + ownername + ", coachname="
				+ coachname + "]";
	}
	

}
