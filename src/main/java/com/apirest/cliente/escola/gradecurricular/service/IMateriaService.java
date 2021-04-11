package com.apirest.cliente.escola.gradecurricular.service;

import java.util.List;
import java.util.Optional;

import com.apirest.cliente.escola.gradecurricular.entity.MateriaEntity;

public interface IMateriaService {
	
	public Boolean cadastrar(final MateriaEntity materia);
	
	public List<MateriaEntity> listarTodos();
	
	public Optional<MateriaEntity> consultar(Long id);
	
	public Boolean atualizar(final MateriaEntity materia);
	
	public Boolean excluir(Long id);
}
