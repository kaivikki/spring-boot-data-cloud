package com.kaivikki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kaivikki.entities.compositekey.Patient;
import com.kaivikki.entities.compositekey.PatientId;

public interface PatientRepository extends CrudRepository<Patient, PatientId> {

}
