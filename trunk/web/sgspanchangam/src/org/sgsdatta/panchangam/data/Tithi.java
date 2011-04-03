package org.sgsdatta.panchangam.data;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.googlecode.objectify.annotation.Unindexed;

@Unindexed
public class Tithi implements Cloneable {
	@Expose
	private String rutuvu = null;
	@Expose
	private String maasam = null;
	@Expose
	private String paksham=null;
	@Expose
	private String tithiName=null;
	@Expose
	private Date tithiTime=null;

	public String getRutuvu() {
		return rutuvu;
	}

	public void setRutuvu(String rutuvu) {
		this.rutuvu = rutuvu;
	}

	public String getMaasam() {
		return maasam;
	}

	public void setMaasam(String maasam) {
		this.maasam = maasam;
	}

	public String getPaksham() {
		return paksham;
	}

	public void setPaksham(String paksham) {
		this.paksham = paksham;
	}

	public String getTithiName() {
		return tithiName;
	}

	public void setTithiName(String tithiName) {
		this.tithiName = tithiName;
	}

	public Date getTithiTime() {
		return tithiTime;
	}

	public void setTithiTime(Date tithiTime) {
		this.tithiTime = tithiTime;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Tithi newTithi = new Tithi();
		newTithi.setMaasam(this.maasam);
		newTithi.setPaksham(this.paksham);
		newTithi.setRutuvu(this.rutuvu);
		return newTithi;
	}
}
