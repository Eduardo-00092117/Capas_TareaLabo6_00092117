package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {

	@Autowired
	private ContribuyenteDAO contriDAO;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contriDAO.findAll();
	}

	@Override
	public void insertContribuyente(Contribuyente contribuyente) throws DataAccessException {
		contriDAO.insertContribuyente(contribuyente);
	}

}
