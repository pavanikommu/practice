package com.scraft.jobrx.domain;

import java.util.ArrayList;
import java.util.List;

import com.scraft.jobrx.exceptions.ScraftException;
import static org.junit.Assert.*;

import org.junit.*;


public class SkillDAOTest 
{
	SkillDAO skilldao;
	List<SkillDetails> skillDetailslist;

	@Before
	public void setUp() throws Exception 
	{
		skilldao = new SkillDAOJDBCImpl("jobdb", "root", " password");

	}

	@Test
	public void testCreateaSkill() throws ScraftException 
	{

		Skill skill1;
		SkillDetails skd;
		SkillDetails skd2;
		
		skill1 = new Skill();

		skd = new SkillDetails();
		skd2 = new SkillDetails();

		skillDetailslist = new ArrayList<SkillDetails>();

		skill1.setName("php");
		skill1.setSkillDescription("front ");

		skd.setSkDtDescription("netscape");
		skd2.setSkDtDescription("netscape2");

		skillDetailslist.add(skd);
		skillDetailslist.add(skd2);

		skill1.setSkillDetailslist(skillDetailslist);

		Skill insertedskill = skilldao.createaSkill(skill1);

		assertEquals("dotnet",skill1.getName());

	}

	@Test
	public void testReadAllSkills() throws ScraftException 
	{
		assertNotNull(skilldao.readAllSkills());
		assertEquals(14,skilldao.readAllSkills().size());
	}

}
