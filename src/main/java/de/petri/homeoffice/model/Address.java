package de.petri.homeoffice.model;

public class Address {
	private Contact contact;
	private String addressType;
	private String title;
	private String addressPart1;
	private String addressPart2;
	private String addressPart3;
	private String salutation1;
	private String salutation2;
	private String salutation3;
	private String salutation4;
	private String street;
	private String plz;
	private String city;
	private String country;
	private String fax;
	private String phone;
	private String email;

	public Address(Contact contact, String addressType, String title,
			String addressPart1, String salutation1, String street, String plz,
			String city) {
		super();
		this.contact = contact;
		this.addressType = addressType;
		this.title = title;
		this.addressPart1 = addressPart1;
		this.salutation1 = salutation1;
		this.street = street;
		this.plz = plz;
		this.city = city;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddressPart1() {
		return addressPart1;
	}

	public void setAddressPart1(String addressPart1) {
		this.addressPart1 = addressPart1;
	}

	public String getAddressPart2() {
		return addressPart2;
	}

	public void setAddressPart2(String addressPart2) {
		this.addressPart2 = addressPart2;
	}

	public String getAddressPart3() {
		return addressPart3;
	}

	public void setAddressPart3(String addressPart3) {
		this.addressPart3 = addressPart3;
	}

	public String getSalutation1() {
		return salutation1;
	}

	public void setSalutation1(String salutation1) {
		this.salutation1 = salutation1;
	}

	public String getSalutation2() {
		return salutation2;
	}

	public void setSalutation2(String salutation2) {
		this.salutation2 = salutation2;
	}

	public String getSalutation3() {
		return salutation3;
	}

	public void setSalutation3(String salutation3) {
		this.salutation3 = salutation3;
	}

	public String getSalutation4() {
		return salutation4;
	}

	public void setSalutation4(String salutation4) {
		this.salutation4 = salutation4;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
