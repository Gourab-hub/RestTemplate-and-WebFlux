package com.rest.call.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoResponse {
	public String _id;
	public String name;
	public String email;
	public String phone;
	public String picture;
	public String salary;
	public String position;
	public int __v;
	public Date createdAt;
}
