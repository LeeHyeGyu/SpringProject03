package net.os.bear.board;

import java.io.Serializable;
import java.sql.Date;

import net.os.bear.user.UserDTO;

public class ArticleDTO implements Serializable {
	private int social_no;
	private String social_title;
	private String social_content;
	private int social_section;
	private Date social_date;
	private String user_id;
	private int social_count;
	private UserDTO userDTO;
	private Date event_date;
	private Date deadline;
	private int maxp;
	private int join_stat;
	private String join_list;
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
	public int getSocial_count() {
		return social_count;
	}
	public void setSocial_count(int social_count) {
		this.social_count = social_count;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
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
	@Override
	public String toString() {
		return  "==========================================================================================="+
				"\nArticleDTO [social_no=" + social_no + ", social_title=" + social_title + ", social_content="
				+ social_content + ",\n social_section=" + social_section + ", social_date=" + social_date + "\n, user_id="
				+ user_id + ", social_count=" + social_count + ", event_date=" + event_date
				+ "\n, deadline=" + deadline + ", maxp=" + maxp + ", join_stat=" + join_stat + ", join_list=" + join_list
				+ "\n, userDTO=" + userDTO + "]" +"\n===========================================================================================";
	}
	public ArticleDTO(int social_no, String social_title, String social_content, int social_section, Date social_date,
			String user_id, int social_count, UserDTO userDTO, Date event_date, Date deadline, int maxp, int join_stat,
			String join_list) {
		super();
		this.social_no = social_no;
		this.social_title = social_title;
		this.social_content = social_content;
		this.social_section = social_section;
		this.social_date = social_date;
		this.user_id = user_id;
		this.social_count = social_count;
		this.userDTO = userDTO;
		this.event_date = event_date;
		this.deadline = deadline;
		this.maxp = maxp;
		this.join_stat = join_stat;
		this.join_list = join_list;
	}
	
	public ArticleDTO() {}
}
