package com.coll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Friend {

	@Id
	@SequenceGenerator(name="myFriendSeq", sequenceName="friendSeq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myFriendSeq")
	int friendId;
	String loginname;
	String friendloginname;
	String status;
	
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getLoginName() {
		return loginname;
	}
	public void setLoginName(String loginName) {
		this.loginname = loginName;
	}
	public String getFriendLoginName() {
		return friendloginname;
	}
	public void setFriendLoginName(String friendLoginName) {
		this.friendloginname = friendLoginName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
