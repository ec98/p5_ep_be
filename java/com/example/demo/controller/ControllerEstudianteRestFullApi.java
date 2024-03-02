package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTO;

@RestController
@RequestMapping(path = "/estudiantes")
@CrossOrigin
public class ControllerEstudianteRestFullApi {

	@Autowired
	private IEstudianteService iEstudianteService;

	// http://localhost:7020/API/v1.0/Servicio/estudiantes

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody EstudianteTO estudiante) {
		this.iEstudianteService.guardar(estudiante);
	}

	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteTO> buscarPorCedula(@PathVariable String cedula) {
		return ResponseEntity.status(HttpStatus.OK).body(this.iEstudianteService.buscarPorCedula(cedula));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(this.iEstudianteService.buscarTodos());
	}

}
