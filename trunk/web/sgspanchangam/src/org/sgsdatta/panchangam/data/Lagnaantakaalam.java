package org.sgsdatta.panchangam.data;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.googlecode.objectify.annotation.Unindexed;

@Unindexed
public class Lagnaantakaalam {
	@Expose
	private String raasi = null;
	@Expose
	private Date time = null;

	public Lagnaantakaalam() {
		super();
	}

	public Lagnaantakaalam(String raasi, Date time) {
		this.raasi = raasi;
		this.time = time;
	}

	public String getRaasi() {
		return raasi;
	}

	public void setRaasi(String raasi) {
		this.raasi = raasi;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
