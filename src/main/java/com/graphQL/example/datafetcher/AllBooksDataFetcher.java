package com.graphQL.example.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphQL.example.model.Book;
import com.graphQL.example.repository.GraphRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>>{

    @Autowired
    GraphRepository graphRepository;

    @Override
    public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return graphRepository.findAll();
    }
}
