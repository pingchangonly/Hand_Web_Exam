package cn.web.hand.entity;

import java.sql.Timestamp;

public class Language {
	private int languageId;
	private String name;
	private Timestamp last_update;

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languangeId) {
		this.languageId = languangeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

}
