package com.graphQL.example.datafetcher;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphQL.example.model.Book;
import com.graphQL.example.repository.GraphRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UpdateBookRecord implements DataFetcher<Book>{

	  @Autowired
	    GraphRepository graphRepository;
	  
	@Override
	public Book get(DataFetchingEnvironment arg0) {
		Book book1=null;
		Optional<Book> userExist=graphRepository.findById(arg0.getArgument("id"));
		System.out.println("Id is==========================="+userExist);
		if(userExist.isPresent()) {
		  book1=new Book();
		  book1.setId(arg0.getArgument("id"));
		book1.setAuthors(arg0.getArgument("authors"));	
		}
		return graphRepository.save(book1);
	}

}
