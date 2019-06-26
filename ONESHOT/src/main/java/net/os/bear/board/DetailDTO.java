package net.os.bear.board;

import java.sql.Date;

public class DetailDTO {
	private int social_no;
	private String host_id;
	private Date event_date;
	private Date deadline;
	private int maxp;
	private String join_status;
	private String join_list;
	
	public int getSocial_no() {
		return social_no;
	}
	public void setSocial_no(int social_no) {
		this.social_no = social_no;
	}
	public String getHost_id() {
		return host_id;
	}
	public void setHost_id(String host_id) {
		this.host_id = host_id;
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
	public String getJoin_status() {
		return join_status;
	}
	public void setJoin_status(String join_status) {
		this.join_status = join_status;
	}
	public String getJoin_list() {
		return join_list;
	}
	public void setJoin_list(String join_list) {
		this.join_list = join_list;
	}
	
	public DetailDTO(int social_no, String host_id, Date event_date, Date deadline, int maxp, String join_status,
			String join_list) {
		super();
		this.social_no = social_no;
		this.host_id = host_id;
		this.event_date = event_date;
		this.deadline = deadline;
		this.maxp = maxp;
		this.join_status = join_status;
		this.join_list = join_list;
	}
	public DetailDTO() {}
	
	@Override
	public String toString() {
		return "DetailDTO [social_no=" + social_no + ", host_id=" + host_id + ", event_date=" + event_date
				+ ", deadline=" + deadline + ", maxp=" + maxp + ", join_status=" + join_status + ", join_list="
				+ join_list + "]";
	}
}
