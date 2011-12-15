package it.try2solve.data.repository;

import it.try2solve.data.model.User;

import org.springframework.data.document.mongodb.repository.MongoRepository;
import org.springframework.data.document.mongodb.repository.QueryDslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRepository extends MongoRepository<User , String>, QueryDslPredicateExecutor<User> {

}
