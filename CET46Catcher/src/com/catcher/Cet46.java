package com.catcher;

public class Cet46 {
	private String name;
	private String school;
	private String type;
	private String listenScore;
	private String readingScore;
	private String writtingAndTranslatingScore;
	private String certificateNumber;
	private String result;

	public String toString() {
		return "{name='" + this.name + '\'' + ", school='" + this.school + '\'' + ", type='" + this.type + '\''
				+ ", listenScore='" + this.listenScore + '\'' + ", readingScore='" + this.readingScore + '\''
				+ ", writtingAndTranslatingScore='" + this.writtingAndTranslatingScore + '\'' + ", certificateNumber='"
				+ this.certificateNumber + '\'' + ", result='" + this.result + '\'' + '}';
	}

	public String getListenScore() {
		return this.listenScore;
	}

	public void setListenScore(String listenScore) {
		this.listenScore = listenScore;
	}

	public String getReadingScore() {
		return this.readingScore;
	}

	public void setReadingScore(String readingScore) {
		this.readingScore = readingScore;
	}

	public String getWrittingAndTranslatingScore() {
		return this.writtingAndTranslatingScore;
	}

	public void setWrittingAndTranslatingScore(String writtingAndTranslatingScore) {
		this.writtingAndTranslatingScore = writtingAndTranslatingScore;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCertificateNumber() {
		return this.certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
