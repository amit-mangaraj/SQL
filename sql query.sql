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
                                                                                                                                  
 SELECT * FROM sqlactivity3.auction;CREATE TABLE `auction` (
  `Auctid` int NOT NULL AUTO_INCREMENT,
  `Player_id` int NOT NULL,
  `Teamid` int NOT NULL,
  `Actyear` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`Auctid`),
  KEY `Teamid` (`Teamid`),
  KEY `Player_id` (`Player_id`),
  CONSTRAINT `auction_ibfk_1` FOREIGN KEY (`Teamid`) REFERENCES `team` (`Teamid`),
  CONSTRAINT `auction_ibfk_2` FOREIGN KEY (`Player_id`) REFERENCES `player` (`Player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
                                                                                                                               
                                                                                                                                  
SELECT * FROM sqlactivity3.player;

use sqlactivity3;
CREATE TABLE `USER` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `regdate` date NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

select * from USER
  
