package org.sgsdatta.panchangam.data;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.googlecode.objectify.annotation.Unindexed;

@Unindexed
public class Nakshatram {
	@Expose
	private String nakshatram;
	@Expose
	private Date nakshatramTime;

	public String getNakshatram() {
		return nakshatram;
	}

	public void setNakshatram(String nakshatram) {
		this.nakshatram = nakshatram;
	}

	public Date getNakshatramTime() {
		return nakshatramTime;
	}

	public void setNakshatramTime(Date nakshatramTime) {
		this.nakshatramTime = nakshatramTime;
	}
}
