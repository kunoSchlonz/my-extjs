package de.petri.homeoffice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NamedQueries({ @NamedQuery(name = User.findByEmail, query = "SELECT o FROM User o WHERE o.email = :email") })
@Entity
public class User {
	public static final String findByEmail = "User.findByEmail";

	@NotNull
	@Size(min = 3, max = 20, message = "Der Vorname eines Users muss min. 3 und darf max. 20 Zeichen lang sein.")
	private String vorname;
	@NotNull
	@Size(min = 3, max = 30, message = "Der Nachname eines Users muss min. 3 und darf max. 30 Zeichen lang sein.")
	private String nachname;
	@Id
	@Pattern(regexp = ".+@.+", message = "Bitte eine valide E-Mail-Adresse angeben.")
	private String email;
	@NotNull
	private String passwort;

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
}
