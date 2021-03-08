package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Player;
import configuration.Myconfiguration;

public class PlayerDao extends TeamDao {
	public List<Player> getAllPlayers(){
		List<Player> li=new ArrayList<Player>();
		
		return li;
		}
	
	public Player getPlayerById(int id) {
		Player p = new Player();
			
		return p;
	}
	
	  ResultSet resultSet = null;

	public boolean insertPlayer(Player p) throws Exception
	{
		Connection c= Myconfiguration.getConnection();
		PreparedStatement ps= c.prepareStatement("insert into player values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, p.getPlayer_id());
		ps.setString(2, p.getPname());
		
		ps.setString(3, p.getSkills());
		ps.setDate(4,p.getDateofBirth());
		ps.setInt(5, p.getRuns());
		ps.setInt(6,p.getWickets());
		ps.setInt(7, p.getNoOfMatches());
		ps.setString(8, p.getNationality());
		
		ps.setInt(9, p.getTeamid());
		return ps.execute();
	}
	
	public boolean updatePlayer(int id,String name) throws Exception
	{
		Connection c= Myconfiguration.getConnection();
		PreparedStatement ps= c.prepareStatement("UPDATE Player SET Pname=? WHERE Player_id=?");
		ps.setString(1, name);
		ps.setInt(2, id);
		return ps.execute();
	}
	
	
	public boolean viewAll(Player p) throws Exception
	{
		Connection c= Myconfiguration.getConnection();
		PreparedStatement ps= c.prepareStatement("Select* from Player");
		 resultSet = ps.executeQuery();
		 while(resultSet.next()) {
             System.out.println(resultSet.getInt(1)+":"+resultSet.getString(2)+" "+resultSet.getString(3)+" "+
            		 resultSet.getDate(4)+" "+resultSet.getInt(5)+" "+resultSet.getInt(6)+" "+resultSet.getInt(7));
         }
		return false;
	}
	
	public boolean viewTeamPlayer(String teamname) throws Exception
	{
		Connection c= Myconfiguration.getConnection();
		PreparedStatement ps= c.prepareStatement(" Select p.Player_id,p.Pname,p.runs,p.wickets,p.noOfMatches,p.nationality from Player as p left join Team as t on t.Teamid=p.Teamid where t.Teamname=?");
		ps.setString(1, teamname);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int n=rs.getInt(1);
			String name=rs.getString(2);
			int Runs = rs.getInt(3);
			int Wick = rs.getInt(4);
			int nom=rs.getInt(5);
			String sk=rs.getString(6);
			
			System.out.println(n+" "+name+" "+Runs+" "+Wick+" "+nom+""+sk);
		}
		return ps.execute();
	}
	
	public void getPlayerst(String sk1,String name1) throws Exception
	{
		Connection con=Myconfiguration.getConnection();
		PreparedStatement ps=con.prepareStatement("Select p.Player_id,p.Pname,p.runs,p.wickets,p.noOfMatches,p.nationality from Player as p left join Team as t on t.Teamid=p.Teamid where t.Teamname=? && p.skills=?");
		ps.setString(1, name1);
		ps.setString(2, sk1);
	
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int n=rs.getInt(1);
			String name=rs.getString(2);
			int Runs = rs.getInt(3);
			int Wick = rs.getInt(4);
			int nom=rs.getInt(5);
			String sk=rs.getString(6);
			System.out.println(n+" "+name+" "+Runs+" "+Wick+" "+nom+" "+sk);
		}
	}
	
	   public  void deletePlayer(Integer id) throws Exception{
		      String SQL = "delete from Player where Player_id = "+id;
		      Connection c= Myconfiguration.getConnection();
		      Statement stmt = c.createStatement();
		      stmt.executeUpdate(SQL);
		      System.out.println("Deleted Record with ID = " + id );
		      return;
	}
	   
	   public void getAll( int id) throws Exception
		{

			Connection con=Myconfiguration.getConnection();
			PreparedStatement ps=con.prepareStatement("Select p.Pname,t.Teamname,t.coachname,TIMESTAMPDIFF(YEAR, DateofBirth, CURDATE()) AS age from Player as p Right join Team as t on p.Teamid=t.Teamid where p.Player_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String name=rs.getNString(1);
				String n=rs.getString(2);
				String cn=rs.getString(3);
				String dob=rs.getString(4);
				System.out.println(name+" "+n+" "+cn+" "+dob+"\n");
				
			}
		}
	   
	   public void getAllPlayers(String name) throws Exception
		{
			Connection con=Myconfiguration.getConnection();
			PreparedStatement ps=con.prepareStatement("Select p.Pname,t.Teamname,t.coachname,TIMESTAMPDIFF(YEAR, DateofBirth, CURDATE()) AS age from Player as p Right join Team as t on p.Teamid=t.Teamid where p.Pname=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String name1=rs.getNString(1);
				String n=rs.getString(2);
				String cn=rs.getString(3);
				String dob=rs.getString(4);
				System.out.println(name1+" "+n+" "+cn+" "+dob+"\n");
				
			}
		}
}
