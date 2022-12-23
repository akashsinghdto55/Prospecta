package com.prospecta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.dao.MainDao;
import com.prospecta.entity.Main;
import com.prospecta.exception.MainException;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	private MainDao mdao;
	
	@Override
	public Main saveProject(Main main) {
		
		return mdao.save(main);
	}

	@Override
	public List<List<String>> findByCategory(String Category) throws MainException {
		

		List<List<String>> result = new ArrayList<>();
		
		List<Main> main = mdao.findByCategory(Category);
		    
		for(Main m : main) {
			
			List<String> re = new ArrayList<>();
			
			re.add(m.getTitle());
			re.add(m.getDescription());
			
			result.add(re);
		}
		
		if(result.size()>0) {
			
			return result;
			
		}
		else {
			throw new MainException("Title and Description not avaiable");
		}
		
		
		
	}

}
