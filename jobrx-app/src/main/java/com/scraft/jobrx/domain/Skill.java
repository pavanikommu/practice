package com.scraft.jobrx.domain;

import java.util.List;

public class Skill 
{
	int skillId;
	String name;
	String skillDescription;
	List<SkillDetails> skillDetailslist;
	
	public List<SkillDetails> getSkillDetailslist() {
		return skillDetailslist;
	}
	public void setSkillDetailslist(List<SkillDetails> skillDetailslist) {
		this.skillDetailslist = skillDetailslist;
	}
	public Skill(){
		
	}
	public Skill(int skillId, String name, String skillDescription,List<SkillDetails
			> skillDetailslist) {
		super();
		this.skillId = skillId;
		this.name = name;
		this.skillDescription = skillDescription;
		this.skillDetailslist=skillDetailslist;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkillDescription() {
		return skillDescription;
	}
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", name=" + name
				+ ", skillDescription=" + skillDescription + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((skillDescription == null) ? 0 : skillDescription.hashCode());
		result = prime * result + skillId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skillDescription == null) {
			if (other.skillDescription != null)
				return false;
		} else if (!skillDescription.equals(other.skillDescription))
			return false;
		if (skillId != other.skillId)
			return false;
		return true;
	}
	

}
