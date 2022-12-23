package com.prospecta.service;

import java.util.List;

import com.prospecta.entity.Main;
import com.prospecta.exception.MainException;


public interface MainService {
	
	public List<List<String>> findByCategory(String Category) throws MainException;
	
	public Main saveProject(Main main);
}
