package com.graphQL.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.graphQL.example.model.Book;
import com.graphQL.example.repository.GraphRepository;
import com.graphQL.example.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
public class GraphQLController {

	@Autowired
	GraphQLService graphQlService;
	@Autowired
	GraphRepository graphRepository;

	@PostMapping("/rest/getAllBooks")
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		ExecutionResult executionResult = graphQlService.getGraphQL().execute(query);

		return new ResponseEntity<Object>(executionResult, HttpStatus.OK);
	}
	
	@DeleteMapping("/rest/deleteBookByID")
	public ResponseEntity<Object> deleteBookByID(@RequestBody String query) {
		ExecutionResult executionResult = graphQlService.getGraphQL().execute(query);

		return new ResponseEntity<Object>("Record Deleted", HttpStatus.OK);
	}
	
	@PutMapping("/rest/updateBook")
	public ResponseEntity<Object> updateBook(@RequestBody String query) {
		ExecutionResult executionResult = graphQlService.getGraphQL().execute(query);

		return new ResponseEntity<Object>("Record Updated", HttpStatus.OK);
	}

	/*
	 * @PostMapping("/createBooks")
	 * 
	 * public String createBook(@RequestBody Book book) {
	 * graphRepository.save(book); return "Record Added .....!!!"; }
	 * 
	 * @DeleteMapping("/deleteBook/{id}")
	 * 
	 * public String deleteBookRecord(@PathVariable String id) { return
	 * "Record has been Deleted"; }
	 */
}
