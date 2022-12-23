package com.prospecta.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.entity.Main;

@Repository
public interface MainDao extends JpaRepository<Main,Integer> {
	
	public List<Main> findByCategory(String Category);

}
