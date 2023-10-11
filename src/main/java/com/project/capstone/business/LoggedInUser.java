package com.project.capstone.business;

import com.project.capstone.Entity.User;

import lombok.Data;

@Data
public class LoggedInUser {
    private User loggedInUser;

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	}