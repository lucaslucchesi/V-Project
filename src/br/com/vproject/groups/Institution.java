package br.com.vproject.groups;

import java.time.LocalDateTime;

import org.apache.commons.lang3.text.WordUtils;

import br.com.vproject.lists.InstitutionList;

public class Institution {
	static int institutionIdGen = 1;
	String name;
	String id;
	String cnpj; // STANDARDIZE
	String state;
	String cep; // STANDARDIZE
	String street;
	String number;
	String district;
	String city;
	String country;
	String phone; // STANDARDIZE
	String email;
	Stock stock; //NEXT STEP
	LocalDateTime creationDate;

	public Institution(String name, String cnpj) {
		if (InstitutionList.getInstitutionMapCNPJ().containsKey(cnpj)) {
			System.err.println("ERROR - ALREADY REGISTERED CNPJ (" + cnpj + ")\n");
			return;
		} else {
			// TERMINAR CONSTRUTOR
			this.name = WordUtils.capitalizeFully(name);
			this.cnpj = cnpj;

			// CREATION DATE
			LocalDateTime date = LocalDateTime.now();
			this.creationDate = date;

			// ID GENERATOR
			this.id = institutionIdGen + "I";
			institutionIdGen += 1;

			// ADD TO INSTITUTIONLIST
			InstitutionList.getInstitutionMapCNPJ().put(this.getCnpj(), this);
			InstitutionList.getInstitutionMapID().put(this.getId(), this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = WordUtils.capitalizeFully(name);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getState() {
		if (this.state == null)
			return "-";
		return state;
	}

	public void setState(String state) {
		this.state = WordUtils.capitalizeFully(state);
	}

	public String getStreet() {
		if (this.street == null)
			return "-";
		return street;
	}

	public void setStreet(String street) {
		this.street = WordUtils.capitalizeFully(street);
	}

	public String getNumber() {
		if (this.number == null)
			return "-";
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		if (this.district == null)
			return "-";
		return district;
	}

	public void setDistrict(String district) {
		this.district = WordUtils.capitalizeFully(district);
	}

	public String getCity() {
		if (this.city == null)
			return "-";
		return city;
	}

	public void setCity(String city) {
		this.city = WordUtils.capitalizeFully(city);
	}

	public String getPhone() {
		if (this.phone == null)
			return "-";
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		if (this.email == null)
			return "-";
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getCep() {
		if (this.cep == null)
			return "-";
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCountry() {
		if (this.country == null)
			return "-";
		return country;
	}

	public void setCountry(String country) {
		this.country = WordUtils.capitalizeFully(country);
	}

	// FORMATED
	public String getCreationDate() {
		return creationDate.getDayOfMonth() + "/" + creationDate.getMonthValue() + "/" + creationDate.getYear() + " - "
				+ creationDate.getHour() + "h" + creationDate.getMinute() + "min";
	}

	// UNFORMATED
	public LocalDateTime getCreationDate2() {
		return creationDate;
	}

	// EXCEPTION HANDLING IS OK?
	@Override
	public String toString() throws NullPointerException {
		try {
			return "INSTITUTION INFORMATION" + "\n" + " NAME: " + this.getName() + "\n" + " ID: " + this.getId() + "\n" + " CNPJ: " + this.getCnpj() + "\n"
					+ " ADDRESS: " + this.getStreet() + ", " + this.getNumber() + ", " + this.getDistrict() + " - CEP: "
					+ this.getCep() + " - " + this.getCity() + "/ " + this.getState() + " - "
					+ this.getCountry().toUpperCase() + "\n" + " PHONE: " + this.getPhone() + "\n" + " EMAIL: "
					+ this.getEmail() + "\n" + "SYSTEM REGISTRATION DATE: " + this.getCreationDate() + "\n";
		} catch (Exception e) {

			return "ERROR: Institution not found. \nDetail: " + e + "\n";
		}
	}
}
