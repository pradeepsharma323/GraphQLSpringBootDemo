package com.graphQL.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphQL.example.model.Book;

@Repository
public interface GraphRepository extends JpaRepository<Book, Integer>  {

}
