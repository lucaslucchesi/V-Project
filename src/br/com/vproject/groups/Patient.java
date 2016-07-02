package br.com.vproject.groups;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Random;

import org.apache.commons.lang3.text.WordUtils;

import br.com.vproject.lists.PatientList;

public class Patient {

	static int patientIdGen = 1;
	String name;
	String id;
	int password;
	String cpf; // STANDARDIZE
	long age;
	LocalDate dateOfBirth;
	LocalDateTime creationDate;
	String cep; // STANDARDIZE
	String street;
	String district;
	String number;
	String complement;
	String city;
	String state;
	String country;
	String cellphone; // STANDARDIZE
	String email;
	Collection<Vaccine> vaccines = new LinkedHashSet<>(); // LINKEDHASHSET OR
														// OTHER?
														// NEXT STEP

	// CONSTRUCTOR
	public Patient(String name, String cpf, String cellphone) {
		if (PatientList.getPatientMapCPF().containsKey(cpf)) {
			System.err.println("ERROR - ALREADY REGISTERED CPF (" + cpf + ")\n");
			return;
		} else {

			this.name = WordUtils.capitalizeFully(name);
			this.cpf = cpf;
			this.cellphone = cellphone;

			// CREATION DATE
			LocalDateTime date = LocalDateTime.now();
			this.creationDate = date;

			// PASSWORD GENERATOR
			Random r = new Random();
			int Low = 100000;
			int High = 1000000;
			this.password = r.nextInt(High - Low) + Low;

			// ID GENERATOR
			this.id = patientIdGen + "P";
			patientIdGen += 1;

			// ADD TO PATIENTLIST
			PatientList.getPatientMapCPF().put(this.getCpf(), this);
			PatientList.getPatientMapID().put(this.getId(), this);
			// PatientList.getPatientMapNAME().put(this.getName(), this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = WordUtils.capitalizeFully(name);
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getCpf() {
		if (this.cpf == null)
			return "-";
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		if (this.cep == null)
			return "-";
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		if (this.street == null)
			return "-";
		return street;
	}

	public void setStreet(String street) {
		this.street = WordUtils.capitalizeFully(street);
	}

	public String getDistrict() {
		if (this.district == null)
			return "-";
		return district;
	}

	public void setDistrict(String district) {
		this.district = WordUtils.capitalizeFully(district);
	}

	public String getNumber() {
		if (this.number == null)
			return "-";
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		if (this.complement == null)
			return "-";
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = WordUtils.capitalizeFully(complement);
	}

	public String getCity() {
		if (this.city == null)
			return "-";
		return city;
	}

	public void setCity(String city) {
		this.city = WordUtils.capitalizeFully(city);
	}

	public String getState() {
		if (this.state == null)
			return "-";
		return state;
	}

	public void setState(String state) {
		this.state = WordUtils.capitalizeFully(state);
	}

	public String getCountry() {
		if (this.country == null)
			return "-";
		return country;
	}

	public void setCountry(String country) {
		this.country = WordUtils.capitalizeFully(country);
	}

	public String getCellphone() {
		if (this.cellphone == null)
			return "-";
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		if (this.email == null)
			return "-";
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Vaccine> getVaccines() {
		return vaccines;
	}

	public String getId() {
		return id;
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

	// FIX EXCEPTION java.time.DateTimeException
	public void setDateOfBirth(int day, int month, int year) {
		LocalDate a = LocalDate.of(year, month, day);
		this.dateOfBirth = a;

		// NEED TO FIND A METHOD TO UPDATE THE AGE AUTOMATICALLY
		LocalDateTime b = LocalDateTime.now();
		this.age = ChronoUnit.YEARS.between(this.dateOfBirth, b);
	}

	// FORMATED
	public String getDateOfBirth() {
		return dateOfBirth.getDayOfMonth() + "/" + dateOfBirth.getMonthValue() + "/" + dateOfBirth.getYear();
	}

	// UNFORMATED
	public LocalDate getDateOfBirth2() {
		return dateOfBirth;
	}

	public long getAge() {
		return age;
	}

	// EXCEPTION HANDLING IS OK?
	@Override
	public String toString() throws NullPointerException {
		try {
			return "PATIENT INFORMATION\n" + " NAME: " + this.getName() + "\n" + " ID: " + this.getId() + "\n"
					+ " CPF: " + this.getCpf() + "\n" + " AGE: " + this.getAge() + "\n" + " DATE OF BIRTH: "
					+ this.getDateOfBirth() + "\n" + " ADDRESS: " + this.getStreet() + ", " + this.getNumber() + ", "
					+ this.getDistrict() + " - CEP: " + this.getCep() + " - " + this.getCity() + "/ " + this.getState()
					+ " - " + this.getCountry().toUpperCase() + "\n" + " CELLPHONE: " + this.getCellphone() + "\n"
					+ " EMAIL: " + this.getEmail() + "\n" + "VACINES: " + this.getVaccines().size() + "\n"
					+ "SYSTEM REGISTRATION DATE: " + this.getCreationDate() + "\n";
		} catch (Exception e) {
			return "ERROR: Patient not found. \nDetail: " + e + "\n";
		}
	}
}
