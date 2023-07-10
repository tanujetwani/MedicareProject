package org.simplilearn.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	private String uname;
	private String upasswd;
	private String uphone;
	private String uaddress;
	private String userType;
	
	public Users() {}
	
	public Users(String uname , String upasswd, String uphone, String uaddress, String userType) {
		this.uname=uname;
		this.upasswd=upasswd;
		this.uphone=uphone;
		this.uaddress=uaddress;
		this.userType=userType;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	
	public String getUpasswd() {
		return upasswd;
	}

	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}	

}
