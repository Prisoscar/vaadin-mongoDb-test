package com.example.application.data.abstractDocument;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;

public class AbstractDocument implements Persistable<String> {

	public enum STATUS {
		CREATED, LOCKED, DELETED
	}

	@Version
	private Long version;

	@Id
	private String uuid = null;

	private STATUS recordStatus = STATUS.CREATED;

	private Date createdDate = null;

	public Date getCreatedDate() {
		return createdDate;
	}

	@LastModifiedDate
	private Date lastModifiedDate;

	public String getUuid() {
		return uuid;
	}

	public STATUS getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(STATUS recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	@Override
	public String getId() {
		return getUuid();
	}

	@Override
	public boolean isNew() {
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
			version = 0L;
			createdDate = new Date();
			return true;
		}
		return false;
	}

	public void cloneObject() {
		uuid = null;
	}

}
