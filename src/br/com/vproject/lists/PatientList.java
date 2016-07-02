package br.com.vproject.lists;

import java.util.HashMap;
import java.util.Map;

import br.com.vproject.groups.Patient;

public class PatientList {
	static Map<String, Patient> patientMapCPF = new HashMap<>();
	static Map<String, Patient> patientMapID = new HashMap<>();
	// VERIFY
	// static Map<String, List<Patient>> patientMapNAME = new HashMap<>();
	

	// GET A MAP WITH CPFs
	public static Map<String, Patient> getPatientMapCPF() {
		return patientMapCPF;
	}

	// GET A MAP WITH IDs
	public static Map<String, Patient> getPatientMapID() {
		return patientMapID;
	}

	// // VERIFY - GET A MAP WITH NAMES
	// public static Map<String, List<Patient>> getPatientMapNAME() {
	// return patientMapNAME;
	// }

	// SEARCH BY ID
	// REMOVE "NULL" RETURN
	public static Patient getPatientById(String id) {
		String idUp = id.toUpperCase();
		if (!(getPatientMapID().containsKey(idUp)))
			System.err.println("PATIENT NOT FOUND - ID: " + idUp);
		return getPatientMapID().get(idUp);
	}

	// SEARCH BY CPF
	// REMOVE "NULL" RETURN
	public static Patient getPatientByCPF(String cpf) {
		if (!(getPatientMapCPF().containsKey(cpf)))
			System.err.println("PATIENT NOT FOUND - CPF: " + cpf);
		return getPatientMapCPF().get(cpf);
	}

	// SEARCH BY NAME
	// CREATE METHOD
	// private static Patient getPatientByNAME() {
	// TODO Auto-generated method stub
	// }

}
