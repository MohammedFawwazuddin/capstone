package com.project.capstone.business;


import lombok.Data;

@Data
public class LoginBody {
    private String username;
    private String password;
	public String getUsername(String string, String string2) {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
    
    
}