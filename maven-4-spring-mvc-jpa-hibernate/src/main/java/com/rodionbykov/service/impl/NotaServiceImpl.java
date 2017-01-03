package com.rodionbykov.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rodionbykov.model.Nota;
import com.rodionbykov.repository.NotaRepository;
import com.rodionbykov.service.NotaService;

@Service
public class NotaServiceImpl implements NotaService {
	@Resource
	private NotaRepository notaRepository;

	@Override
	public Nota create(Nota nota) {
		Nota createdNota = nota;

		return notaRepository.save(createdNota);
	}

	@Override
	public Nota delete(int id) {
		Nota deletedUser = notaRepository.findOne(id);

		notaRepository.delete(deletedUser);

		return deletedUser;
	}

	@Override
	public List<Nota> findAll() {
		// TODO Auto-generated method stub
		return notaRepository.findAll();
	}

	@Override
	public Nota update(Nota nota) {
		Nota updatedNota = notaRepository.findOne(nota.getId());

		updatedNota.setNombre(nota.getNombre());
		updatedNota.setDescripcion(nota.getDescripcion());

		return updatedNota;
	}

	@Override
	public Nota findById(int id) {

		return notaRepository.findOne(id);
	}

	@Override
	public List<Nota> search(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
