package com.rodionbykov.service;

import java.util.List;

import com.rodionbykov.model.Nota;

public interface NotaService {
	public Nota create(Nota nota);

	public Nota delete(int id);

	public List<Nota> findAll();

	public Nota update(Nota nota);

	public Nota findById(int id);

	public List<Nota> search(String s);
}
