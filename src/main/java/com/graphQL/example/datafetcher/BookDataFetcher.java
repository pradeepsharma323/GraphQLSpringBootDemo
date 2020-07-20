package com.graphQL.example.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphQL.example.model.Book;
import com.graphQL.example.repository.GraphRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Book>{

    @Autowired
    GraphRepository graphRepository;

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {

        Integer isn = dataFetchingEnvironment.getArgument("id");

        return graphRepository.findById(isn).get();
    }
}