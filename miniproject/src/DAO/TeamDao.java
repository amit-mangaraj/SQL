package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Team;
import configuration.Myconfiguration;

public class TeamDao {

	public List<Team> getAllTeams(){
		List<Team> li=new ArrayList<Team >();
		
		return li;
		}
	public Team getTeamById(int id) {
		Team t = new Team();
			
		return t;
	}
	
	public boolean insertTeam(Team t) throws Exception
	{
		Connection c= Myconfiguration.getConnection();
		
		PreparedStatement ps= c.prepareStatement("insert into team values(?,?,?,?)");
		ps.setInt(1,t.getTeam_id());
		ps.setString(2, t.getTeamname());
		ps.setString(3, t.getOwnername());
		ps.setString(4,t.getCoachname());
		return ps.execute();
}
	public Boolean updateTeam(int tid1, String tname1) throws Exception {
		Connection c= Myconfiguration.getConnection();
		PreparedStatement ps= c.prepareStatement("UPDATE Team SET Teamname=? WHERE Teamid=?");
		ps.setInt(2, tid1);
		ps.setString(1, tname1);
		return ps.execute();
	}
	
	  public  void deleteTeam(Integer id) throws Exception{
	      String SQL = "delete from Player where Teamid = "+id;
	      String SQL1 = "delete from Team where Teamid = "+id;
	      String Sql="SET FOREIGN_KEY_CHECKS=0";
	      String Sql1="SET FOREIGN_KEY_CHECKS=1";
	      Connection c= Myconfiguration.getConnection();
	      
	      Statement stmt = c.createStatement();
	      stmt.execute(Sql);
	      stmt.executeUpdate(SQL1);
	      stmt.executeUpdate(SQL);
	      stmt.execute(Sql1);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }
	
}
