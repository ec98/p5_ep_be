package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void save(Estudiante estudiante);

	public Estudiante searchForCedu(String cedula);

	public List<Estudiante> searchAll();
}
