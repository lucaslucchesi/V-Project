package br.com.vproject.main;

import br.com.vproject.groups.Institution;
import br.com.vproject.groups.Patient;
import br.com.vproject.groups.Professional;

public class VProject {

	public static void main(String[] args) {
		//PATIENT 1
		Patient a1 = new Patient("joão paulo Silva", "111.111.111-11", "(22)98138-9212");
		a1.setDateOfBirth(01, 07, 1992);
		a1.setCep("56.325-280");
		a1.setStreet("rua irineu Marinho");
		a1.setDistrict("liberdade");
		a1.setNumber("235");
		a1.setCity("campinas");
		a1.setState("São paulo");
		a1.setCountry("brasil");
		a1.setEmail("joaops@hotmail.com");
		System.out.println(a1);
	
		//PATIENT 2.1
		Patient a2 = new Patient("Maria souza", "222.222.222-22", "(11)98253-9200");
		a2.setDateOfBirth(22, 03, 1994);
		a2.setCep("11.555-550");
		a2.setStreet("Rua São Mateus");
		a2.setDistrict("Jardim");
		a2.setNumber("23");
		a2.setCity("Brasília");
		a2.setState("Distrito Federal");
		a2.setCountry("Brasil");
		a2.setEmail("marias@hotmail.com");
		System.out.println(a2);
		
		//PATIENT 2.2 - REPEATED PATIENT TEST
//		Patient a3 = new Patient("Maria Souza", "222.222.222-22", "(11)98253-9200");
//		a3.setDateOfBirth(22, 03, 1994);
//		a3.setCep("11.555-550");
//		a3.setStreet("Rua São Mateus");
//		a3.setDistrict("Jardim");
//		a3.setNumber("23");
//		a3.setCity("Brasília");
//		a3.setState("Distrito Federal");
//		a3.setCountry("Brasil");
//		a3.setEmail("marias@hotmail.com");
		//System.out.println(a3);
		
		//INSTITUTION 1
		Institution b1 = new Institution("monte sinai", "33.33.33-3");
		b1.setState("Amazonas");
		b1.setStreet("Av. Rio Branco");
		b1.setNumber("34");
		b1.setDistrict("Centro");
		b1.setCity("Manaus");
		b1.setPhone("(92)3212-1232");
		b1.setEmail("montesinai@hotmail.com");
		b1.setCep("23.325.211");
		b1.setCountry("Brasil");
		System.out.println(b1);
		
		//INSTITUTION 2.1
		Institution b2 = new Institution("unimed", "44.44.44-4");
		b2.setState("Ceará");
		b2.setStreet("Av. Bosque");
		b2.setNumber("13");
		b2.setDistrict("Alvorada");
		b2.setCity("Fortaleza");
		b2.setPhone("(61)2222-1244");
		b2.setEmail("unimed@hotmail.com");
		b2.setCep("23.333.01");
		b2.setCountry("Brasil");
		System.out.println(b2);
		
		//INSTITUTION 2.2 - REPEATED INSTITUTION TEST
//		Institution b3 = new Institution("unimed", "44.44.44-4");
//		b3.setState("Ceará");
//		b3.setStreet("Av. Bosque");
//		b3.setNumber("13");
//		b3.setDistrict("Alvorada");
//		b3.setCity("Fortaleza");
//		b3.setPhone("(61)2222-1244");
//		b3.setEmail("unimed@hotmail.com");
//		b3.setCep("23.333.01");
//		b3.setCountry("Brasil");
//		System.out.println(b3);
				
		//PROFESSIONAL 1
		Professional v1 = new Professional("Manoel Moreira", "555.555.555-55", "33.33.33-3");
		v1.setOccupation("medic");
		System.out.println(v1);
		
		//PROFESSIONAL 2.1
		Professional v2 = new Professional("Henrique Prado", "666.666.666-66", "44.44.44-4");
		v2.setOccupation("nurse");
		System.out.println(v2);
		
		//PROFESSIONAL 2.2 - REPEATED PROFESSIONAL TEST
//		Professional v3 = new Professional("Henrique Prado2", "666.666.666-66", "44.44.44-4");
//		v3.setOccupation("medic");
//		System.out.println(v3);
		

		

		
		

	}
}
