the command to login and it will ask for password 

enter password as passpwrd

mysql -u root -p






create table skill
( 
Skill_Id int not null Auto_Increment,
Name varchar(55),
Description varchar(255),
primary key (Skill_Id)
);


create table SKILL_DETAILS
(
Skd_Id int not null Auto_Increment,
Skill_Id int not null,
Description varchar(255),
primary key (Skd_Id),
foreign key (Skill_Id)
references skill(Skill_Id)
)

insert into Skill

values(1,j2ee,'java2 platform enterprise edition ');


select * from Skill
inner join Skill_Details
on (Skill.ID=Skill_Details.ID)
where skill.name='j2ee';

select s.* from Skill s ,Skill_Details sd
where (s.Skill_Id=sd.Skill_Id) and
 (s.Name='java');


 select s.* from Skill s ,Skill_Details sd
where (s.Skill_Id=sd.Skill_Id) and
where (s.Name='java');


select s.* from Skill s ,Skill_Details sd
where s.Skill_Id=sd.Skd_Id;

