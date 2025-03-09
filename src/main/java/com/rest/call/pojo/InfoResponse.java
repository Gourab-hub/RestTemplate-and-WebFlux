package com.rest.call.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoResponse {
	public String name;
	public String email;
	public String city;
	public Date currentDate;
	public String id;
}
