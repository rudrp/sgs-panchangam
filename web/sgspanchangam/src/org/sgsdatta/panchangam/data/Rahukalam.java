package org.sgsdatta.panchangam.data;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.googlecode.objectify.annotation.Unindexed;

@Unindexed
public class Rahukalam {
	@Expose
	private Date startTime = null;
	@Expose
	private Date endTime = null;

	public Rahukalam() {
		super();
	}

	public Rahukalam(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
