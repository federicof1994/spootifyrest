package it.spootifyrest.service;

import it.spootifyrest.model.Sessione;

public interface SessioneService extends IBaseService<Sessione> {
	
	public boolean tokenValido(String token);

}
