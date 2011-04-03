package org.sgsdatta.panchangam.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;

import com.google.gson.annotations.Expose;
import com.googlecode.objectify.annotation.Unindexed;

@Unindexed
public class Day {

	@Expose
	private String year = null;
	@Expose
	private String month = null;
	@Expose
	private String date = null;
	@Expose
	private String dayOfTheWeek = null;
	@Expose
	private String aayanam = null;
	@Expose
	private String rahukalam = null;
	@Expose
	private Date sunrise = null;
	@Expose
	private Date sunset = null;
	@Expose
	private String visesham = null;
	@Expose
	private String yogam = null;
	@Expose
	private String karanam = null;
	@Expose
	@Embedded
	private List<Varjyam> varjyamulu = null;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public String getRahukalam() {
		return rahukalam;
	}

	public void setRahukalam(String rahukalam) {
		this.rahukalam = rahukalam;
	}

	public Date getSunrise() {
		return sunrise;
	}

	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}

	public Date getSunset() {
		return sunset;
	}

	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

	public String getVisesham() {
		return visesham;
	}

	public void setVisesham(String visesham) {
		this.visesham = visesham;
	}

	public String getAayanam() {
		return aayanam;
	}

	public void setAayanam(String aayanam) {
		this.aayanam = aayanam;
	}

	public String getYogam() {
		return yogam;
	}

	public void setYogam(String yogam) {
		this.yogam = yogam;
	}

	public String getKaranam() {
		return karanam;
	}

	public void setKaranam(String karanam) {
		this.karanam = karanam;
	}

	public List<Varjyam> getVarjyamulu() {
		return varjyamulu;
	}

	public void setVarjyamulu(List<Varjyam> varjyamulu) {
		this.varjyamulu = varjyamulu;
	}
}
