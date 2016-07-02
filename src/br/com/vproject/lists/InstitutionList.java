package br.com.vproject.lists;

import java.util.HashMap;
import java.util.Map;

import br.com.vproject.groups.Institution;

public class InstitutionList {

	static Map<String, Institution> institutionMapCNPJ = new HashMap<>();
	static Map<String, Institution> institutionMapID = new HashMap<>();
	// static Map<String, List<Institution>> institutionMapNAME = new
	// HashMap<>(); // VERIFY

	// GET A MAP WITH CNPJs
	public static Map<String, Institution> getInstitutionMapCNPJ() {
		return institutionMapCNPJ;
	}

	// GET A MAP WITH IDs
	public static Map<String, Institution> getInstitutionMapID() {
		return institutionMapID;
	}

	// // VERIFY - GET A MAP WITH NAMES
	// public static Map<String, List<Institution>> getInstitutionMapNAME() {
	// return institutionMapNAME;
	// }

	// SEARCH BY CNPJ
	// REMOVE "NULL" RETURN
	public static Institution getInstitutionByCNPJ(String cnpj) {
		if (!(getInstitutionMapCNPJ().containsKey(cnpj)))
			System.err.println("INSTITUTION NOT FOUND");
		return getInstitutionMapCNPJ().get(cnpj);
	}

	// SEARCH BY ID
	// REMOVE "NULL" RETURN
	public static Institution getInstitutionByID(String id) {
		String idUp = id.toUpperCase();
		if (!(getInstitutionMapID().containsKey(idUp)))
			System.err.println("INSTITUTION NOT FOUND");
		return getInstitutionMapID().get(idUp);
	}

	// SEARCH BY NAME
	// CREATE METHOD
	// private static Patient getInstitutiontByNAME() {
	// TODO Auto-generated method stub
	// }
}
