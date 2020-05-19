package com.uca.capas.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteService contriService;
	@Autowired
	private ImportanciaService importService;
	
	private List<Importancia> importancias = null;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		try {
			importancias = importService.findAll(); 
			mav.addObject("importancia", importancias);
			mav.addObject("contribuyente", new Contribuyente());
			mav.setViewName("index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/guardar")
	public ModelAndView insertar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
			mav.addObject("importancia", importancias);
		} else {
			try {
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Integer.toString(localDate.getDayOfMonth()) + "/" + Integer.toString(localDate.getMonthValue()) + "/" + Integer.toString(localDate.getYear()));
				contribuyente.setF_fecha_ingreso(date1);
				contriService.insertContribuyente(contribuyente);
				mav.setViewName("exito");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> list = null;
		try {
			list = contriService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyente", list);
		mav.setViewName("listado");
		return mav;
	}
}
