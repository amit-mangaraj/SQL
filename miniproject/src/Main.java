import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.sql.Date;

import DAO.PlayerDao;
import DAO.TeamDao;
import Model.Player;
import Model.Team;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the operation number");
System.out.println("1: Insert Team And Player Details");
System.out.println("2:Update the Player Details");
System.out.println("3: View All Players");
System.out.println("4: Players based on Team");
System.out.println("5: Players based on Team and Skills");
System.out.println("6: Update the Team Details");
System.out.println("7: Delete the Player");
System.out.println("8: Delete the Team");
int n=Integer.parseInt(br.readLine());
switch(n)
{
case 1:
	System.out.println("Select table for insertion:");
	System.out.println("Enter the Team Id: "); 
	int tid=Integer.parseInt(br.readLine());
	System.out.println("Enter the Team Name: ");
    String tname=br.readLine();
    
    System.out.println("Enter the Owner Name: ");
    String oname=br.readLine();
    
    System.out.println("Enter the coach Name: ");
    String cname=br.readLine();
    
    Team t= new Team(tid,tname,oname,cname);
    TeamDao td=new TeamDao();
    td.insertTeam(t);
	
    System.out.println("\n");
    System.out.println("Enter the Player Details");
    System.out.println("Enter the Player Id: "); 
	int pid=Integer.parseInt(br.readLine());
	System.out.println("Enter the Player Name: ");
    String pname=br.readLine();
    System.out.println("Enter the Player Skills: ");
    String pskills=br.readLine();
    System.out.println("Enter the date of birth");
   Date dt = Date.valueOf(br.readLine());;
    System.out.println("Enter the Player runs: ");
    int pruns=Integer.parseInt(br.readLine());
    System.out.println("Enter the Player Wickets: ");
    int pwic=Integer.parseInt(br.readLine());
    System.out.println("Enter the Player Number of Matches: ");
    int pnum=Integer.parseInt(br.readLine());
    System.out.println("Enter the Nationality: ");
    String national=br.readLine();
    System.out.println("Enter Player Team Id: ");
    int pteam=Integer.parseInt(br.readLine());
    
  
    Player p=new Player(pid,pname,pskills,dt,pruns,pwic,pnum,national,pteam);
    PlayerDao pd=new PlayerDao();
    pd.insertPlayer(p);
    System.out.println("Team and Player added Successfully");
    break;
case 2:
	  System.out.println("Update the Player Details");
      System.out.println("Enter the Player Id: "); 
    	int playerid=Integer.parseInt(br.readLine());
    	System.out.println("Enter the Player Name: ");
        String playername=br.readLine();
        System.out.println("List of all players ");
        System.out.println("Enter the Player Skills: ");
        String pskills1=br.readLine();
        System.out.println("Enter the date of birth");
        Date dt1 = Date.valueOf(br.readLine());;
         System.out.println("Enter the Player runs: ");
         int pruns1=Integer.parseInt(br.readLine());
         System.out.println("Enter the Player Wickets: ");
         int pwic1=Integer.parseInt(br.readLine());
         System.out.println("Enter the Player Number of Matches: ");
         int pnum1=Integer.parseInt(br.readLine());
         System.out.println("Enter the Nationality: ");
         String national1=br.readLine();
         System.out.println("Enter Player Team Id: ");
         int pteam1=Integer.parseInt(br.readLine());
        Player p1=new Player(playerid,playername,pskills1,dt1,pruns1,pwic1,pnum1,national1,pteam1);
        PlayerDao pd1=new PlayerDao();
        pd1.updatePlayer(playerid,playername);
        System.out.println("Updated .........");
    	   break;
case 3:
	System.out.println("View all Players:");
	 Player p2=new Player();
     PlayerDao pd2=new PlayerDao();
     pd2.viewAll(p2);
	break;
case 4:
	System.out.println("Players based on Team");
	System.out.println("Enter team name ");
	Player p3=new Player();
	 PlayerDao pd4=new PlayerDao();
	 String Teamname=br.readLine();
	 pd4.viewTeamPlayer(Teamname);
	 break;
case 5:
	System.out.println("Enter the team you want to search:");
	String name=br.readLine();
	System.out.println("Enter the skill");
	String sk=br.readLine();
	Player p4=new Player();
	 PlayerDao pd5=new PlayerDao();
	 pd5.getPlayerst(sk, name);
	 break;
case 6:
	System.out.println("update the team Details");
	System.out.println("Enter the Team Id: "); 
	int tid1=Integer.parseInt(br.readLine());
	System.out.println("Enter the Team Name: ");
    String tname1=br.readLine();
    
    TeamDao td1=new TeamDao();
    Boolean bo=td1.updateTeam(tid1,tname1);
	if(bo==true)
	{
		System.out.println("Not updated....");
	}
	else
		System.out.println("Updated Successfully...");
  	   break;
case 7:
	System.out.println("ENTER PLAYER ID TO DELETE");
   int id=Integer.parseInt(br.readLine());
   PlayerDao pd6=new PlayerDao();
   pd6.deletePlayer(id);
   break;
case 8:
   System.out.println("Enter the Team ID to Delete");
   System.out.println("ENTER Team ID TO DELETE");
   id=Integer.parseInt(br.readLine());
   TeamDao td2=new TeamDao();
   td2.deleteTeam(id);
   break;
default:
	System.out.println("Nothing to select");

}

	}

}
