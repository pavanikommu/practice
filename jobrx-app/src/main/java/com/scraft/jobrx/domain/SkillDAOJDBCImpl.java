package com.scraft.jobrx.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scraft.jobrx.exceptions.ScraftException;

public class SkillDAOJDBCImpl implements SkillDAO 
{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jobdb";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs;


	public SkillDAOJDBCImpl(String dbName, String userName, String password)
			throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}

	@Override
	public Skill createaSkill(Skill skill) throws ScraftException 
	{
		insertSkill(skill);
		String name = skill.getName();
		int skillIds = readSkillIdByName(name);
		insertSkillDetails(skillIds, skill.getSkillDetailslist());
		return skill;
	}

	@Override
	public List<Skill> readAllSkills() throws ScraftException 
	{
		String skillDescription = null;
		int skillId;
		int skdId;
		String skdDescription;
		
		List<Skill> skillslist = new ArrayList<Skill>();
		String readAllSkills = ("select s.* ,sd.skd_Id , skd_Description from Skill s ,Skill_Details sd where (s.Skill_Id=sd.Skill_Id)");
		
		try {
			
			stmt = this.conn.prepareStatement(readAllSkills);
			rs = stmt.executeQuery();
			Skill skill=null;
			int currentSkillId=0;
			int previousSkillId=-1;
			
			while (rs.next()) 
			{
				currentSkillId = rs.getInt("Skill_Id");

				if (currentSkillId == previousSkillId) {
					SkillDetails skd = new SkillDetails();
					skdId = rs.getInt("skd_Id");
					skdDescription = rs.getString("skd_Description");
					skillId = rs.getInt("skill_Id");
					skd.setSkdId(skdId);
					skd.setSkDtDescription(skdDescription);
					skd.setSkdId(skdId);
					skill.getSkillDetailslist().add(skd);
				} else {
					skill = new Skill();
					SkillDetails sd = new SkillDetails();
					List<SkillDetails> sdlist = new ArrayList<SkillDetails>();

					String name = rs.getString("name");
					skillDescription = rs.getString("Skill_Description");
					skdId = rs.getInt("skd_Id");
					skdDescription = rs.getString("skd_Description");
					sd.setSkdId(skdId);
					sd.setSkillId(currentSkillId);
					sd.setSkDtDescription(skdDescription);
					sdlist.add(sd);
					skill.setName(name);
					skill.setSkillId(currentSkillId);
					skill.setSkillDescription(skillDescription);
					skill.setSkillDetailslist(sdlist);
					skillslist.add(skill);
					previousSkillId = currentSkillId;
				}

				//

			}
		} catch (SQLException e) {
			throw new ScraftException(e.getMessage());
		}

		return skillslist;

	}

	private void insertSkillDetails(int skillIds,
			List<SkillDetails> skillDetailslist) throws ScraftException 
	{
		for (SkillDetails skd : skillDetailslist) {
			try {
				String insertSkillDetails = "insert into Skill_Details(skill_Id,skd_description) values(?,?)";
				stmt = this.conn.prepareStatement(insertSkillDetails);
				stmt.setInt(1, skillIds);
				stmt.setString(2, skd.getSkDtDescription());
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new ScraftException(e.getMessage());
			}
		}

	}

	private int readSkillIdByName(String name) throws ScraftException 
	{
		int skillId = 0;
		try {
			String readSkill = "select Skill_Id from Skill where name = '"
					+ name + "'";
			stmt = this.conn.prepareStatement(readSkill);
			rs = stmt.executeQuery();
			while (rs.next()) {
				skillId = rs.getInt(1);
			}

			stmt.close();

		} catch (SQLException e) 
		{
			throw new ScraftException(e.getMessage());
		}

		return skillId;
	}

	private Skill insertSkill(Skill skill) throws ScraftException 
	{
		try 
		{
			
			String insertSkill = "insert into Skill (Name,Skill_Description) values(?,?)";

			stmt = this.conn.prepareStatement(insertSkill);
			stmt.setString(1, skill.getName());
			stmt.setString(2, skill.getSkillDescription());
			stmt.execute();
			stmt.close();

		} 
		catch (SQLException e) 
		{
			throw new ScraftException(e.getMessage());
		}

		return skill;

	}



}