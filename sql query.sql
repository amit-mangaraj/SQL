create Table Player(Player_id INT NOT NULL AUTO_INCREMENT ,Pname varchar(30),skills varchar(40),
DateofBirth Date,runs int (10),wickets int(5),noOfMatches int(5),nationality varchar(10),
Teamid int,primary key(Player_id),FOREIGN KEY (Teamid) REFERENCES Team(Teamid)); 

create Table Team(Teamid INT NOT NULL AUTO_INCREMENT,Teamname varchar(30),ownername varchar(20),coachname varchar(10),primary key(Teamid)); 

 Insert into Team values(1,"kkr","srk","Subaskaran");
 Insert into Team values(2,"mi","ambani","sangakara");
  Insert into Team values(3,"csk","bajaj","dhoni");
  Insert into Team values(4,"di","Ak groups","sridhar");
    Insert into Team values(5,"srh","hydrabad Asc","shaym");
  select * from Player ;
 select * from Team ;
  drop table Team;
  use SQLActivity3;
  
  
delete from Team 


  create database SQLActivity3;
  
  Select p.Player_id,p.Pname,p.runs,p.wickets,p.noOfMatches,p.nationality from Player as p left join Team as t on t.Teamid=p.Teamid where t.Teamname like "csk";
  
  
   Select p.Player_id,p.Pname from Player as p left join Team as t on t.Teamid=p.Teamid where p.skills like "ss%" and t.Teamname like "kkr%";
  