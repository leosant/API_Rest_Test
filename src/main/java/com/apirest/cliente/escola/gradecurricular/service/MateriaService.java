package com.apirest.cliente.escola.gradecurricular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.apirest.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.apirest.cliente.escola.gradecurricular.exception.MateriaException;
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
	public MateriaEntity consultar(Long id) {
		try {
			Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(id);
			if(materiaOptional.isPresent()) {
				return materiaOptional.get();
			}
			throw new MateriaException("Matéria não encontrada", HttpStatus.NOT_FOUND);
		}catch (MateriaException m) {
				throw m;
		}catch (Exception e) {
			throw new MateriaException("Erro interno identificado. Contante o suporte", HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@Override
	public Boolean atualizar(MateriaEntity materia) {
		try {
			this.consultar(materia.getId());
			Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(materia.getId());
			if(materiaOptional.isPresent()) {
				//find materia why like of update
				MateriaEntity materiaUpdate = materiaOptional.get();
				
				materiaUpdate.setNome(materia.getNome());
				materiaUpdate.setHoras(materia.getHoras());
				materiaUpdate.setCodigo(materia.getCodigo());
				materiaUpdate.setFrequencia(materia.getFrequencia());
				
				//Saving changes
				this.materiaRepository.save(materiaUpdate);
				
				return true;
			}
			return false;
		}catch(MateriaException m) {
			throw m;
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean excluir(Long id) {
		try {
			this.consultar(id);
			this.materiaRepository.deleteById(id);
			return true;
		}catch(MateriaException m) {
			throw m;	
		} catch(Exception e) {
			throw e;
		}
	}

}
