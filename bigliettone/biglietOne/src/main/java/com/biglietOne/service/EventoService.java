package com.biglietOne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.biglietOne.database.EventiDao;
import com.biglietOne.database.EventoDetailDao;
import com.biglietOne.models.Entity;
import com.biglietOne.models.Evento;
import com.biglietOne.models.EventoDetail;

public class EventoService {

	@Autowired
	EventiDao eventiDao;
	
	@Autowired
	EventoDetailDao eventoDetailDao;
	
	public List<Evento> getEventi(){
		
		
		
		List<Evento> listaEventi = new ArrayList<Evento>();
		
		Map<Integer, Entity> mapEventi = eventiDao.read();
		for(Entry<Integer, Entity> entryEventi : mapEventi.entrySet()) {
			
			Evento e = (Evento) entryEventi.getValue();
			
			
			
			Map<Integer, Entity> mapEventiDetail = eventoDetailDao.read(e.getId());
			
			for(Entry<Integer, Entity> entryEventiDetail : mapEventiDetail.entrySet()) {
				
				EventoDetail eD = (EventoDetail) entryEventiDetail.getValue();
				e.getListaEventoDetails().add(eD);
				
			}
			listaEventi.add(e);
			
		}
		
		return listaEventi;
		
	}
	
}
