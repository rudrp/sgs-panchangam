package org.sgsdatta.panchangam.data;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.googlecode.objectify.annotation.Unindexed;

@Unindexed
public class Varjyam {

	@Expose
	private Date varjyamStartTime = null;
	@Expose
	private Date varjyamEndTime = null;

	public Date getVarjyamStartTime() {
		return varjyamStartTime;
	}

	public void setVarjyamStartTime(Date varjyamStartTime) {
		this.varjyamStartTime = varjyamStartTime;
	}

	public Date getVarjyamEndTime() {
		return varjyamEndTime;
	}

	public void setVarjyamEndTime(Date varjyamEndTime) {
		this.varjyamEndTime = varjyamEndTime;
	}

}
