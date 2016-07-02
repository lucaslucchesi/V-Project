package br.com.vproject.lists;

import java.util.HashMap;
import java.util.Map;

import br.com.vproject.groups.Professional;

public class ProfessionalList {
	static Map<String, Professional> professinalMapCPF = new HashMap<>();
	static Map<String, Professional> professionalMapID = new HashMap<>();
	// VERIFY
	// static Map<String, List<Professional>> professionalMapNAME = new HashMap<>();

	// GET A MAP WITH CPFs
	public static Map<String, Professional> getProfessionalMapCPF() {
		return professinalMapCPF;
	}

	// GET A MAP WITH IDs
	public static Map<String, Professional> getProfessionalMapID() {
		return professionalMapID;
	}

	// // VERIFY - GET A MAP WITH NAMES
	// public static Map<String, List<Professional>> getProfessionalMapNAME() {
	// return professionalMapNAME;
	// }

	// SEARCH BY ID
	// REMOVE "NULL" RETURN
	public static Professional getProfessionalById(String id) {
		String idUp = id.toUpperCase();
		if (!(getProfessionalMapID().containsKey(idUp)))
			System.err.println("PROFESSIONAL NOT FOUND - ID: " + idUp);
		return getProfessionalMapID().get(idUp);
	}

	// SEARCH BY CPF
	// REMOVE "NULL" RETURN
	public static Professional getProfessionalByCPF(String cpf) {
		if (!(getProfessionalMapCPF().containsKey(cpf)))
			System.err.println("PROFESSIONAL NOT FOUND - CPF: " + cpf);
		return getProfessionalMapCPF().get(cpf);
	}

	// SEARCH BY NAME
	// CREATE METHOD
	// private static Professional getProfessionalByNAME() {
	// TODO Auto-generated method stub
	// }
}
