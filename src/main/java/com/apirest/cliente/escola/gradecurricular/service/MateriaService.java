package com.apirest.cliente.escola.gradecurricular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.apirest.cliente.escola.gradecurricular.repository.IMateriaRepository;

@Service
public class MateriaService implements IMateriaService{
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	public Boolean cadastrar(MateriaEntity materia) {
		try {
			this.materiaRepository.save(materia);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<MateriaEntity> listarTodos() {
		return this.materiaRepository.findAll();
	}

	@Override
	public Optional<MateriaEntity> consultar(Long id) {
		return this.materiaRepository.findById(id);
	}

	@Override
	public Boolean atualizar(MateriaEntity materia) {
		try {
			//find materia why like of update
			MateriaEntity materiaUpdate = this.materiaRepository.findById(materia.getId()).get();
			materiaUpdate.setNome(materia.getNome());
			materiaUpdate.setHoras(materia.getHoras());
			materiaUpdate.setCodigo(materia.getCodigo());
			materiaUpdate.setFrequencia(materia.getFrequencia());
			
			//Saving changes
			this.materiaRepository.save(materiaUpdate);
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean excluir(Long id) {
		try {
			this.materiaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
