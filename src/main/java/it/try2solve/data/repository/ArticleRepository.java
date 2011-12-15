package it.try2solve.data.repository;

import it.try2solve.data.model.Article;

import org.springframework.data.document.mongodb.repository.MongoRepository;
import org.springframework.data.document.mongodb.repository.QueryDslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ArticleRepository extends MongoRepository<Article, String>, QueryDslPredicateExecutor<Article>{
	
}
