package de.petri.homeoffice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@NamedQueries({ @NamedQuery(name = Contact.findByUser, query = "SELECT a FROM Contact a"),
				@NamedQuery(name = Contact.findActiveByUser, query = "SELECT a FROM Contact a WHERE inactiveFromDate is null OR inactiveFromDate > now()")
})
@Entity
public class Contact {

	public static final String findByUser = "Contact.findByUser";
	public static final String findActiveByUser = "Contact.findActiveByUser";

	@GeneratedValue
	@Id
	private Long id;

	@NotNull(message = "Bitte eine Kurzbezeichnung angeben.")
	private String shortName;

	@NotNull(message = "Bitte ein ContactTyp angeben.")
	private ContactType contactType;

	private Date createDate = new Date();
	private Date modifyDate = null;
	private Date inactiveFromDate = null;

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getInactiveFromDate() {
		return inactiveFromDate;
	}

	public void setInactiveFromDate(Date inactiveFromDate) {
		this.inactiveFromDate = inactiveFromDate;
	}

	/*
	 * @ManyToOne private User user;
	 */
	public Contact() {

	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	/*
	 * public void setUser(User user) { this.user = user; }
	 */
	/**
	 * @return the user
	 */
	/*
	 * public User getUser() { return user; }
	 */
	public enum ContactType {
		FIRMA, PRIVATPERSON

	}
}
