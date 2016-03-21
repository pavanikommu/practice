package com.scraft.jobrx.domain;

import java.util.List;

import com.scraft.jobrx.exceptions.ScraftException;

public interface SkillDAO {

	public Skill createaSkill(Skill skill) throws ScraftException;

	public List<Skill> readAllSkills() throws ScraftException;

}
