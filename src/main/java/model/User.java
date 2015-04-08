package model;

import java.io.Serializable;

/**
 * @author Zu
 *
 */
public class User implements Serializable {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public String toString() {
		return "p: " + password + " " + "l: " + login + " " + "n: " + name + " " + "s: " + surname + " " + "e: "
				+ email;
	}
}
