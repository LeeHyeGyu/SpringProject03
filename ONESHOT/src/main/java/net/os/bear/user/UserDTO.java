package net.os.bear.user;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;

public class UserDTO implements Serializable {
	private String user_id    ;
	private String user_pw    ;
	private String user_adr   ;
	private int user_level ;
	private int user_warn  ;
	private String user_jumin ;
	private String user_taste ;
	private String user_taste2;
	private String user_taste3;
	private String user_flavor;
	private String user_type  ;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
//		this.user_pw = DigestUtils.sha512Hex(user_pw);
	}
	public String getUser_adr() {
		return user_adr;
	}
	public void setUser_adr(String user_adr) {
		this.user_adr = user_adr;
	}
	public int getUser_level() {
		return user_level;
	}
	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}
	public int getUser_warn() {
		return user_warn;
	}
	public void setUser_warn(int user_warn) {
		this.user_warn = user_warn;
	}
	public String getUser_jumin() {
		return user_jumin;
	}
	public void setUser_jumin(String user_jumin) {
		this.user_jumin = user_jumin;
	}
	public String getUser_taste() {
		return user_taste;
	}
	public void setUser_taste(String user_taste) {
		this.user_taste = user_taste;
	}
	public String getUser_taste2() {
		return user_taste2;
	}
	public void setUser_taste2(String user_taste2) {
		this.user_taste2 = user_taste2;
	}
	public String getUser_taste3() {
		return user_taste3;
	}
	public void setUser_taste3(String user_taste3) {
		this.user_taste3 = user_taste3;
	}
	public String getUser_flavor() {
		return user_flavor;
	}
	public void setUser_flavor(String user_flavor) {
		this.user_flavor = user_flavor;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_adr=" + user_adr + ", user_level="
				+ user_level + ", user_warn=" + user_warn + ", user_jumin=" + user_jumin + ", user_taste=" + user_taste
				+ ", user_taste2=" + user_taste2 + ", user_taste3=" + user_taste3 + ", user_flavor=" + user_flavor
				+ ", user_type=" + user_type + "]";
	}
	
	
	
}
