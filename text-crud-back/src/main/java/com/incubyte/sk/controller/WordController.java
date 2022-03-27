package com.incubyte.sk.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incubyte.sk.entity.ModelRepsonse;
import com.incubyte.sk.entity.WordEntity;
import com.incubyte.sk.repo.WordRepository;

@RestController
@RequestMapping("/api")
public class WordController {
	
	@Autowired private WordRepository wordRepository;
	
	@GetMapping("/test")
	public String test () {
		return "<h3>Test Success</h3>" ;
	}
	
	@PostMapping(value = "/add-word", produces = { "application/json" }, consumes = {"application/json"})
	public ResponseEntity<ModelRepsonse> addWord (@RequestBody WordEntity word) {
		try {
			wordRepository.save(word);
			return  new ResponseEntity<>(new ModelRepsonse(200, "SUCCESS", "Data inserted"), HttpStatus.OK) ;
		} catch (Exception e) {
			return  new ResponseEntity<>(new ModelRepsonse(400, "FAILED", e.getLocalizedMessage()), HttpStatus.BAD_REQUEST) ;
		}
	}
	
	@GetMapping(value = "/get-words", produces = {"application/json"})
	public ResponseEntity<List<WordEntity>> getAllWords () {
		
		try {
			List<WordEntity> words =  wordRepository.findAll();
			return new ResponseEntity<> (words, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST) ;
		}
		
	}
	
	@GetMapping(value = "/delete/{id}")
	@Modifying
	@Transactional
	public ResponseEntity<ModelRepsonse> deleteWord ( @PathVariable(value = "id", required = true) Integer id ) {
		try {
			System.out.println("deleting id " + id);
			wordRepository.deleteByWordId(id) ;
			return  new ResponseEntity<>(new ModelRepsonse(200, "SUCCESS", "Data deleted"), HttpStatus.OK) ;
		} catch (Exception e) {
			return  new ResponseEntity<>(new ModelRepsonse(400, "FAILED", e.getLocalizedMessage()), HttpStatus.BAD_REQUEST) ;
		}
	}
	
	

}
