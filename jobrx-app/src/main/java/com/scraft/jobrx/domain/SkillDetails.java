package com.scraft.jobrx.domain;

public class SkillDetails {
	int skdId;
	int skillId;
	String skDtDescription;
	public SkillDetails(){
		
	}

	public SkillDetails(int skdId, int skillId, String skDtDescription) {
		super();
		this.skdId = skdId;
		this.skillId = skillId;
		this.skDtDescription = skDtDescription;
	}
	public int getSkdId() {
		return skdId;
	}
	public void setSkdId(int skdId) {
		this.skdId = skdId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkDtDescription() {
		return skDtDescription;
	}
	public void setSkDtDescription(String skDtDescription) {
		this.skDtDescription = skDtDescription;
	}
	@Override
	public String toString() {
		return "SkillDetails [skdId=" + skdId + ", skillId=" + skillId
				+ ", skDtDescription=" + skDtDescription + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((skDtDescription == null) ? 0 : skDtDescription.hashCode());
		result = prime * result + skdId;
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
		SkillDetails other = (SkillDetails) obj;
		if (skDtDescription == null) {
			if (other.skDtDescription != null)
				return false;
		} else if (!skDtDescription.equals(other.skDtDescription))
			return false;
		if (skdId != other.skdId)
			return false;
		if (skillId != other.skillId)
			return false;
		return true;
	}

}
