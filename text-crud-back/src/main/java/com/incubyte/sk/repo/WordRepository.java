package com.incubyte.sk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incubyte.sk.entity.WordEntity;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, Integer>{

	void deleteByWordId(Integer id);
	
	

}
