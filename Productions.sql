create database SQLActivity2;
use SQLActivity2;
create Table productions(Productionid int not null ,Productionname varchar(30),Address varchar(40),
Dateofstarted varchar(4), Ownername varchar(20),primary key(Productionid));

 drop table productions;

ALTER TABLE productions
add COLUMN Dateofstarted varchar(5);

ALTER TABLE productions
drop COLUMN Dateofstarted;

select * from productions;

 Insert into productions values(8892,"Lyca Production","Chennai","2014","Subaskaran");
Insert into productions values (1010,"Hari Om Entertainment","Mumbai","2008","Akshay Kuma");
Insert into productions values (9091,"Arkamediaworks","Hyderabad","2001","Shobu Yarlagadda");
Insert into productions values (1988,"Red Chillies Entertainment","Mumbai","2003","Shah Ruck");
Insert into productions values (1899,"Viacom18 Studios","Hyderabad","1993","DVV Danayya");
Insert into productions values (6773,"Hombale Flims","Bangalore","1995","Vijay");
Insert into productions values (1111,"STP","Chennai","2018","Sree");
Insert into productions values (2341,"CRM","Bangalore","2017","Manohar");
Insert into productions values (1153,"RRRW","Chennai","2018","swami");


 
 create table movie(Movieid integer not null UNIQUE check (Movieid between 0 and 100000),Moviename varchar(30),Heroname varchar(30),Heroine varchar(30),Releaseddate Date,Language varchar(15),
 Length integer not null check (Length between 9 and 100),Movietype varchar(25),
 Productionid int, primary key (Movieid),FOREIGN KEY (Productionid) REFERENCES productions(Productionid));
 
 drop table movie;
 
 select * from movie;
 
 SHOW KEYS FROM productions WHERE Key_name = 'PRIMARY';
 
ALTER TABLE movie
ADD CONSTRAINT FK_ProductionId
FOREIGN KEY (Productionid) REFERENCES productions(Productionid);

ALTER TABLE movie
ADD FOREIGN KEY (Productionid) REFERENCES productions(Productionid);

insert into movie values(201,'Bahubali – The Beginning','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',8892);

insert into movie values(146,'Andhadhun ','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',1010);
insert into movie values(231,'Bharath Ane nenu ','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',1111);
insert into movie values(244,'Gruham ','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',1899);
insert into movie values(337,'K G F chapter 1','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',6773);
insert into movie values(224,'Rangasthalam ','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',7682);
insert into movie values(136,'Badhaai Ho ','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',1854);
insert into movie values(441,'The Villain ','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',2341);
insert into movie values(206,'Maryada Ramanna ','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',9091);
insert into movie values(211,'Khaidi No. 150 ','Prabhas','Tamannah',STR_TO_DATE('06-01-2019', '%m-%d-%Y'),'Telugu',21,'Drama Fantasy',8892);
insert into movie values(189,'The House Next Door','Siddharth','Andrea',STR_TO_DATE('10-11-2017', '%m-%d-%Y'),'Hindi',14,'Horror',1899);
insert into movie values(267,'Anaganaga O Dheerudu ','Siddharth','Shruthi',STR_TO_DATE('12-01-2014', '%m-%d-%Y'),'Telugu',16,'Fantasy',9091);
 insert into movie values(441,'The Villain','Sudeep','Amy',STR_TO_DATE('12-01-2014', '%m-%d-%Y'),'Kannada',16,'Drama',2341);
 insert into movie values(445,'The khiladi','Prabhas','Rohini',STR_TO_DATE('12-01-2014', '%m-%d-%Y'),'Kannada',16,'Drama',1153);
 
 
 
 =========================================================================================
 /*1 Question*/
  select * from productions;
    select * from movie;
  
 select moviename  from movie where Movietype like "Drama%";
 
   /*2 Question*/
 select moviename  from movie where Heroname like "Heroname%";
    /*3 Question*/
 select count(moviename) from movie where Length>18;
 
  select moviename from movie where length = (select min(Length) from movie );
  
   select moviename  from movie where Language like "T%";
  
   select moviename,Heroname,Heroine from movie where length=(Select Max(Length) );
   
   
   select moviename,Heroname,Heroine from movie where Releaseddate = STR_TO_DATE('15-03-2018', '%m-%d-%Y');
   
   select count(moviename) from movie where  Movietype like "thriller%";
   
	select count(moviename) from movie where Releaseddate = STR_TO_DATE('15-03-2018', '%m-%d-%Y');
    
    select Releaseddate from movie where moviename like "Zero%";
    
    select Heroname from movie where Heroine like "Amy%" ;
   
   select moviename,Productionid  from movie ;
   
  select moviename,  Productionid,count(Language) from movie group by(Language) ;
   
   select moviename,Productionid,count(Language) from movie group by(Language);
   /*1 question*/
   select p.productionid ,p.Productionname, count(m.moviename) from productions as p left join movie as m ON p.productionid = m.productionid group by p.productionid;
   
   /* 2nd question*/
   
   select p.Ownername ,p.Productionname, count(m.moviename) from productions as p left join movie as m ON p.productionid = m.productionid group by p.productionid Having count(m.moviename)>=2 ;
   
     /* 3nd question*/
     
   select p.productionid ,p.Productionname, count(m.moviename) from productions as p left join movie as m ON p.productionid = m.productionid group by p.productionid ORDER BY `productionid` DESC LIMIT 1;
   
   
     /* 4nd question*/
     
     select p.Productionname,m.moviename,m.Heroname from productions as p left join movie as m ON p.productionid = m.productionid where p.Ownername="Subaskaran" ;
     
        /* 5nd question*/
        
      select moviename,Heroname from movie  where productionid like "%82" ;  
      
         /* 6nd question*/
         
           select p.Ownername ,p.Productionname, count(m.moviename) from productions as p left join movie as m ON p.productionid = m.productionid group by p.productionid Having count(m.moviename)=0 ; 
       
        /* 7nd question*/
          select p.Ownername ,p.Productionname from  movie as m right join productions as p ON  m.productionid =p.productionid where m.Language!="Hindi" ;
          
		/* 9 question*/    
         select distinct Heroname ,Language , count(Heroname) as result from  movie group by(Language) order by (result) desc limit 1   ;
         
         /*10*/
         
	 select Distinct p.Productionname,p.Ownername ,count(p.Productionname) as counter  from  movie as m right join productions as p ON  m.productionid =p.productionid  group by(m.language) order by(counter) desc limit 1;
     
     /*11*/ 
      select p.Ownername ,p.Productionname from  movie as m right join productions as p ON  m.productionid =p.productionid where m.moviename is  null ;
      