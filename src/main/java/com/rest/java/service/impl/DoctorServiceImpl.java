package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.DoctorDao;
import com.rest.java.dao.PatientDao;
import com.rest.java.dto.DoctorDto;
import com.rest.java.dto.PatientDto;
import com.rest.java.entity.Doctor;
import com.rest.java.entity.Patient;
import com.rest.java.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao dao;
	
	@Autowired
	private PatientDao patientDao;

	@Override
	public DoctorDto addDoctor(DoctorDto dto) {

		Doctor dr = mapDtoToEntity(dto);
		dr = dao.addDoctor(dr);
		return mapEntityToDto(dr);
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto dto) {

		Doctor dr = mapDtoToEntity(dto);
		dr = dao.updateDoctor(dr);
		dto = mapEntityToDto(dr);
		return dto;
	}

	@Override
	public DoctorDto getOneDoctorById(Integer id) {

		Doctor dr = dao.getOneDoctorById(id);

		DoctorDto dto = mapEntityToDto(dr);

		return dto;
	}

	@Override
	public DoctorDto deleteDoctor(Integer id) {
		Doctor dr = dao.deleteDoctorById(id);
		DoctorDto dto = mapEntityToDto(dr);
		return dto;
	}

	@Override
	public List<DoctorDto> getAllDoctors() {

		List<Doctor> drs = dao.getAllDoctors();

		List<DoctorDto> dtos = mapEntitiesToDto(drs.iterator());

		for (int i = 0; i < drs.size(); i++) {

			DoctorDto dto = new DoctorDto();

			BeanUtils.copyProperties(drs.get(i), dto);

			// dtos.add(dto);
		}
		return dtos;
	}

	public List<DoctorDto> mapEntitiesToDto(Iterator<Doctor> doctorsList) {
		List<DoctorDto> doctordtos = null;

		if (doctorsList != null) {
			doctordtos = new ArrayList<DoctorDto>();
			while (doctorsList.hasNext()) {
				doctordtos.add(mapEntityToDto(doctorsList.next()));
			}
		}

		return doctordtos;
	}

	@Override
	public Doctor mapDtoToEntity(DoctorDto dto) {

		Doctor entity = new Doctor();
		entity.setDrId(dto.getDrId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setDeparment(dto.getDeparment());
		entity.setAddress(dto.getAddress());

		List<PatientDto> patientDtos = dto.getPntDtos();

		if (patientDtos != null && patientDtos.size() > 0) {
			List<Patient> patient = new ArrayList<Patient>();
			for (PatientDto patientDto : patientDtos) {
				patient.add(mapDtoToEntity(patientDto));
			}
			entity.setPatientsList(patient);
		}
		return entity;
	}

	@Override
	public DoctorDto mapEntityToDto(Doctor entity) {

		DoctorDto dto = new DoctorDto();
		dto.setDrId(entity.getDrId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setDeparment(entity.getDeparment());
		dto.setAddress(entity.getAddress());
		
		List<Patient> patient = entity.getPatientsList();

		if (patient != null && patient.size() > 0) {
			List<PatientDto> patientDto = new ArrayList<PatientDto>();

			for (Patient p : patient) {
				patientDto.add(mapEntityToDto(p));
			}
			dto.setPntDtos(patientDto);
		}
		return dto;
	}

	private Patient mapDtoToEntity(PatientDto patientDto) {
		Patient entity = new Patient();
		entity.setPid(patientDto.getPid());
		entity.setName(patientDto.getName());
		entity.setGender(patientDto.getGender());
		entity.setEmail(patientDto.getEmail());
		entity.setAddress(patientDto.getAddress());
		entity.setPhone(patientDto.getPhone());
		entity.setDateOfBirth(patientDto.getDateOfBirth());
		entity.setAge(patientDto.getAge());
		entity.setBloodGroup(patientDto.getBloodGroup());
		entity.setAdmitDate(patientDto.getAdmitDate());
		entity.setDischargeDate(patientDto.getDischargeDate());
		entity.setDiseases(patientDto.getDiseases());
		entity.setDoctor(dao.getOneDoctorById(patientDto.getDrId()));
		return entity;
	}

	private PatientDto mapEntityToDto(Patient p) {
		PatientDto dto = new PatientDto();

		dto.setPid(p.getPid());
		dto.setName(p.getName());
		dto.setGender(p.getGender());
		dto.setEmail(p.getEmail());
		dto.setAddress(p.getAddress());
		dto.setPhone(p.getPhone());
		dto.setDateOfBirth(p.getDateOfBirth());
		dto.setAge(p.getAge());
		dto.setBloodGroup(p.getBloodGroup());
		dto.setAdmitDate(p.getAdmitDate());
		dto.setDischargeDate(p.getDischargeDate());
		dto.setDiseases(p.getDiseases());
		dto.setDrId(p.getDoctor().getDrId());
		return dto;
	}

}
