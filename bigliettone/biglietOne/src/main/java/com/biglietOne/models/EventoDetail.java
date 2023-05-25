package com.biglietOne.models;

import java.sql.Date;

public class EventoDetail extends Entity {
	
	private Date dataEvento;
	private Location location;
	private int idEventi;
	private int postiLiberi;
	
	public void setIdLcation(int id) {
		if(location == null) {
			location = new Location();
		}
		location.setId(id);
	}
	
	public int getIdLocation() {
		return location.getId();
	}
	
	
	
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public int getPostiLiberi() {
		return postiLiberi;
	}
	public void setPostiLiberi(int postiLiberi) {
		this.postiLiberi = postiLiberi;
	}

	public int getIdEventi() {
		return idEventi;
	}

	public void setIdEventi(int idEventi) {
		this.idEventi = idEventi;
	}
	
	
	

}
