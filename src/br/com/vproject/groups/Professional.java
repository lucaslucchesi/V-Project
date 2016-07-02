package br.com.vproject.groups;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Random;

import org.apache.commons.lang3.text.WordUtils;

import br.com.vproject.lists.InstitutionList;
import br.com.vproject.lists.ProfessionalList;

public class Professional {
	static int professionalIdGen = 1;
	String name;
	String id;
	int password;
	String cpf; // STANDARDIZE
	String occupation;
	Institution institution;
	LocalDateTime creationDate;
	Collection<Vaccine> historic = new LinkedHashSet<>();// WILL COLLECT
														// INFORMATION OF
														// VACCINES PROVIDED
														// NEXT STEP

	// CONSTRUCTOR - INCOMPLETE
	public Professional(String name, String cpf, String cnpjInstitution) {
		if (ProfessionalList.getProfessionalMapCPF().containsKey(cpf)) {
			System.err.println("ERROR - ALREADY REGISTERED CPF (" + cpf + ")\n");
			return;
		} else {

			this.name = WordUtils.capitalizeFully(name);
			this.cpf = cpf;
			this.institution = InstitutionList.getInstitutionByCNPJ(cnpjInstitution);

			// CREATION DATE
			LocalDateTime date = LocalDateTime.now();
			this.creationDate = date;

			// PASSWORD GENERATOR
			Random r = new Random();
			int Low = 100000;
			int High = 1000000;
			this.password = r.nextInt(High - Low) + Low;

			// ID GENERATOR
			this.id = professionalIdGen + "V";
			professionalIdGen += 1;

			// ADD TO PATIENTLIST
			ProfessionalList.getProfessionalMapCPF().put(this.getCpf(), this);
			ProfessionalList.getProfessionalMapID().put(this.getId(), this);
			// ProfessionalList.getProfessionalMapNAME().put(this.getName(),
			// this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = WordUtils.capitalizeFully(name);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getOccupation() {
		if (this.occupation == null)
			return "-";
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = WordUtils.capitalizeFully(occupation);
	}

	public Institution getInstitution() {
		return institution;
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

	// FIND AND SELECT INSTITUTION BY CNPJ
	public void setInstitution(String cnpjInstitution) {
		this.institution = InstitutionList.getInstitutionByCNPJ(cnpjInstitution);
	}

	@Override
	public String toString() throws NullPointerException {
		try {
			return "PROFESSIONAL INFORMATION\n" + " NAME: " + this.getName() + "\n" + " ID: " + this.getId() + "\n"
					+ " CPF: " + this.getCpf() + "\n" + " OCCUPATION: " + this.getOccupation() + "\n"
					+ "CURRENT WORK LOCATION: " + "\n" + " INSTITUTION: " + this.getInstitution().getName() + "\n"
					+ " CNPJ: " + this.getInstitution().getCnpj() + "\n" + " ID: " + this.getInstitution().getId()
					+ "\n" + " ADDRESS: " + this.getInstitution().getStreet() + ", " + this.getInstitution().getNumber()
					+ ", " + this.getInstitution().getDistrict() + " - CEP: " + this.getInstitution().getCep() + " - "
					+ this.getInstitution().getCity() + "/ " + this.getInstitution().getState() + " - "
					+ this.getInstitution().getCountry().toUpperCase() + "\n" + "SYSTEM REGISTRATION DATE: "
					+ this.getCreationDate() + "\n";
		} catch (Exception e) {
			return "ERROR: Professional not found. \nDetail: " + e + "\n";
		}
	}

}
