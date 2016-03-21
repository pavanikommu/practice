package com.scraft.jobrx.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.scraft.jobrx.domain.Skill;
import com.scraft.jobrx.domain.SkillDAOJDBCImpl;
import com.scraft.jobrx.domain.SkillDetails;

public class SkillServiceImpl implements SkillService {

	Scanner scraft = new Scanner(System.in);
	boolean skillloop;
	SkillDAOJDBCImpl skjdbc;

	@Override
	public void processSkills() throws ClassNotFoundException, SQLException {

		List<Skill> skilllist = null;

		do {
			skilllist = new ArrayList<Skill>();
			Skill skill = readSkillFromUserUsingScanner();
			skilllist.add(skill);

			System.out.println("do you want to enter skill name true/false");
			skillloop = scraft.nextBoolean();
		} while (skillloop == true);

		//
		insertAllSkillsIntoDatabse(skilllist);
		
		//
		readAllSkillsFromDabase();
	}

	private void readAllSkillsFromDabase() throws ClassNotFoundException, SQLException 
	{
		skjdbc = new SkillDAOJDBCImpl("jobdb", "root", "password");
		
		List<Skill> skilllist = skjdbc.readAllSkills();
		
		for (Skill sk1 : skilllist) 
		{
			System.out.println("///////////");
			displaySkill(sk1);
		}
	}

	private void displaySkill(Skill skill) 
	{
		System.out.println(skill.getName());
		System.out.println(skill.getSkillDescription());
		for (SkillDetails skd : skill.getSkillDetailslist()) 
		{
			System.out.println(skd.getSkDtDescription());

		}
	}

	private void insertAllSkillsIntoDatabse(List<Skill> skilllist)
			throws ClassNotFoundException, SQLException 
	{
		for (Skill sk1 : skilllist) {
			skjdbc = new SkillDAOJDBCImpl("jobdb", "root", "password");
			skjdbc.createaSkill(sk1);
		}

	}

	private Skill readSkillFromUserUsingScanner() 
	{
		boolean skillDetailloop;

		System.out.println("reading skills....");
		Skill skill = new Skill();
		System.out.println("enter skill name ");
		skill.setName(scraft.next());
		System.out.println(skill);
		System.out.println("enter skill descroption");
		skill.setSkillDescription(scraft.next());
		// System.out.println(skill);

		List<SkillDetails> skillDetailsList = new ArrayList<SkillDetails>();
		// SkillDetails skdt = new SkillDetails();
		skill.setSkillDetailslist(skillDetailsList);
		do {
			System.out.println("entr skill details for  " + skill.getName());
			SkillDetails skdt = new SkillDetails();
			skdt.setSkDtDescription(scraft.next());
			skillDetailsList.add(skdt);
			System.out.println("do you want to enter Skilldetails dscription");
			skillDetailloop = scraft.nextBoolean();

		} while (skillDetailloop == true);

		return skill;

	}

}
