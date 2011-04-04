package org.sgsdatta.panchangam.data;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Indexed;
import com.googlecode.objectify.annotation.Unindexed;

@Entity
@Cached
@Unindexed
public class Panchangam {

	@Id
	private Long id;
	@Indexed
	private String gregorianDate = null;
	@Embedded
	@Expose
	private Day day = null;
	@Expose
	@Transient
	@Embedded
	private Tithi currentTithi = null;
	@Embedded
	@Expose
	@Transient
	private Nakshatram currentNakshatram = null;
	@Embedded
	private List<Tithi> tithis = null;
	@Embedded
	private List<Nakshatram> nakshatrams = null;
	@Embedded
	@Expose
	private Lagnaantakaalam lagnantakaalamulu = null;
	@Embedded
	@Expose
	private RaasiChakram raasiChakram = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGregorianDate() {
		return gregorianDate;
	}

	public void setGregorianDate(String gregorianDate) {
		this.gregorianDate = gregorianDate;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public List<Tithi> getTithis() {
		return tithis;
	}

	public void setTithis(List<Tithi> tithis) {
		this.tithis = tithis;
	}

	public List<Nakshatram> getNakshatrams() {
		return nakshatrams;
	}

	public void setNakshatrams(List<Nakshatram> nakshatrams) {
		this.nakshatrams = nakshatrams;
	}

	public RaasiChakram getRaasiChakram() {
		return raasiChakram;
	}

	public void setRaasiChakram(RaasiChakram raasiChakram) {
		this.raasiChakram = raasiChakram;
	}

	public Tithi getCurrentTithi() {
		return currentTithi;
	}

	public void setCurrentTithi(Tithi currentTithi) {
		this.currentTithi = currentTithi;
	}

	public Nakshatram getCurrentNakshatram() {
		return currentNakshatram;
	}

	public void setCurrentNakshatram(Nakshatram currentNakshatram) {
		this.currentNakshatram = currentNakshatram;
	}

	public Lagnaantakaalam getLagnantakaalamulu() {
		return lagnantakaalamulu;
	}

	public void setLagnantakaalamulu(Lagnaantakaalam lagnantakaalamulu) {
		this.lagnantakaalamulu = lagnantakaalamulu;
	}

}
