package net.os.bear.user;

import java.util.Date;

public class SocialDTO {
	private int social_no      ;
	private String social_title   ;
	private String social_content ;
	private int social_section ;
	private Date social_date    ;
	private String user_id        ;
	private int social_counT   ;
	private Date event_date     ;
	private Date deadline       ;
	private int maxp           ;
	private int join_stat      ;
	private String join_list      ;
	private UserDTO userdto        ;
	public int getSocial_no() {
		return social_no;
	}
	public void setSocial_no(int social_no) {
		this.social_no = social_no;
	}
	public String getSocial_title() {
		return social_title;
	}
	public void setSocial_title(String social_title) {
		this.social_title = social_title;
	}
	public String getSocial_content() {
		return social_content;
	}
	public void setSocial_content(String social_content) {
		this.social_content = social_content;
	}
	public int getSocial_section() {
		return social_section;
	}
	public void setSocial_section(int social_section) {
		this.social_section = social_section;
	}
	public Date getSocial_date() {
		return social_date;
	}
	public void setSocial_date(Date social_date) {
		this.social_date = social_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getSocial_counT() {
		return social_counT;
	}
	public void setSocial_counT(int social_counT) {
		this.social_counT = social_counT;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getMaxp() {
		return maxp;
	}
	public void setMaxp(int maxp) {
		this.maxp = maxp;
	}
	public int getJoin_stat() {
		return join_stat;
	}
	public void setJoin_stat(int join_stat) {
		this.join_stat = join_stat;
	}
	public String getJoin_list() {
		return join_list;
	}
	public void setJoin_list(String join_list) {
		this.join_list = join_list;
	}
	public UserDTO getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDTO userdto) {
		this.userdto = userdto;
	}
	@Override
	public String toString() {
		return "SocialDTO [social_no=" + social_no + ", social_title=" + social_title + ", social_content="
				+ social_content + ", social_section=" + social_section + ", social_date=" + social_date + ", user_id="
				+ user_id + ", social_counT=" + social_counT + ", event_date=" + event_date + ", deadline=" + deadline
				+ ", maxp=" + maxp + ", join_stat=" + join_stat + ", join_list=" + join_list + ", userdto=" + userdto
				+ "]";
	}
	
	
}
