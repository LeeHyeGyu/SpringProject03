package net.os.bear.user;

import java.util.Date;

public class MsgDTO {
	
	private String msg_no1;
	private int msg_no         ;
	private String msg_content    ;
	private Date msg_send_date  ;
	private Date msg_recv_date  ;
	private String msg_recv_id    ;
	private String user_id;
	private int msg_recv_delete;
	private int msg_send_delete;
	private String msg_status;
	private UserDTO userDTO        ;
	
	
	public String getMsg_status() {
		return msg_status;
	}
	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}
	public String getMsg_no1() {
		return msg_no1;
	}
	public void setMsg_no1(String msg_no1) {
		this.msg_no1 = msg_no1;
	}
	public int getMsg_no() {
		return msg_no;
	}
	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Date getMsg_send_date() {
		return msg_send_date;
	}
	public void setMsg_send_date(Date msg_send_date) {
		this.msg_send_date = msg_send_date;
	}
	public Date getMsg_recv_date() {
		return msg_recv_date;
	}
	public void setMsg_recv_date(Date msg_recv_date) {
		this.msg_recv_date = msg_recv_date;
	}
	public String getMsg_recv_id() {
		return msg_recv_id;
	}
	public void setMsg_recv_id(String msg_recv_id) {
		this.msg_recv_id = msg_recv_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getMsg_recv_delete() {
		return msg_recv_delete;
	}
	public void setMsg_recv_delete(int msg_recv_delete) {
		this.msg_recv_delete = msg_recv_delete;
	}
	public int getMsg_send_delete() {
		return msg_send_delete;
	}
	public void setMsg_send_delete(int msg_send_delete) {
		this.msg_send_delete = msg_send_delete;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	@Override
	public String toString() {
		return "MsgDTO [msg_no1=" + msg_no1 + ", msg_no=" + msg_no + ", msg_content=" + msg_content + ", msg_send_date="
				+ msg_send_date + ", msg_recv_date=" + msg_recv_date + ", msg_recv_id=" + msg_recv_id + ", user_id="
				+ user_id + ", msg_recv_delete=" + msg_recv_delete + ", msg_send_delete=" + msg_send_delete
				+ ", msg_status=" + msg_status + ", userDTO=" + userDTO + "]";
	}
	
	
	
}
