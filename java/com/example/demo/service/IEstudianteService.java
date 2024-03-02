package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	public void guardar(EstudianteTO estudiante);

	public List<EstudianteTO> buscarTodos();

	public EstudianteTO buscarPorCedula(String cedula);

}
