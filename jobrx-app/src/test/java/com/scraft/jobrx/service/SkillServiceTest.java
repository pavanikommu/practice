package com.scraft.jobrx.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.*;

import com.scraft.jobrx.domain.SkillDetails;
import com.scraft.jobrx.service.SkillServiceImpl;


public class SkillServiceTest 
{
	SkillServiceImpl skillServiceImpl=null;
	
	@Before
	public void setUp() throws Exception 
	{
		 skillServiceImpl = new SkillServiceImpl();
	}
	
	@Test
	public void testProvessSkills() throws ClassNotFoundException, SQLException {
		skillServiceImpl.processSkills();
	}

	@Test
	public void test() 
	{
		SkillDetails skd1 = new SkillDetails(101, 1, "soap");
		// assertNotNull(skill1);
		assertNotNull(skd1);
		// assertEquals(1,skill1.getSkillId());
		assertEquals(101, skd1.getSkdId());

	}

}
