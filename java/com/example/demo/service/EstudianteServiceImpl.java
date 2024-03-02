package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTO estudianteto) {
		// TODO Auto-generated method stub
		this.estudianteRepository.save(this.convertir(estudianteto));

	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		// TODO Auto-generated method stub

		List<Estudiante> ls = this.estudianteRepository.searchAll();
		List<EstudianteTO> lsfinal = new ArrayList<EstudianteTO>();
		for (Estudiante est : ls) {
			EstudianteTO convers = this.convertirTo(est);
			lsfinal.add(convers);
		}
		return lsfinal;
	}

	@Override
	public EstudianteTO buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.convertirTo(this.estudianteRepository.searchForCedu(cedula));
	}

	private EstudianteTO convertirTo(Estudiante estudiante) {
		EstudianteTO esto = new EstudianteTO();
		esto.setId(estudiante.getId());
		esto.setNombre(estudiante.getNombre());
		esto.setApellido(estudiante.getApellido());
		esto.setCedula(estudiante.getCedula());
		return esto;
	}

	private Estudiante convertir(EstudianteTO estudiante) {
		Estudiante est = new Estudiante();
		est.setId(estudiante.getId());
		est.setNombre(estudiante.getNombre());
		est.setApellido(estudiante.getApellido());
		est.setCedula(estudiante.getCedula());
		return est;
	}
}
