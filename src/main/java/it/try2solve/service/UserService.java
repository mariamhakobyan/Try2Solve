package it.try2solve.service;

import it.try2solve.data.model.BaseModel;
import it.try2solve.data.model.QUser;
import it.try2solve.data.model.User;
import it.try2solve.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;


@Service("userService")
public class UserService implements it.try2solve.service.Service {

	//@Autowired
	UserRepository userRepository;

	@Override
	@SuppressWarnings("unchecked")
	public <T extends BaseModel> T save(T obj) {
		User user = (User) obj;
		
		if(user.getId() == null) {
			QUser quser = QUser.user;
			User existingUser = userRepository.findOne(quser.socialId.eq(user.getSocialId()).
					and(quser.userSource.eq(user.getUserSource())));
	
			if(existingUser != null) {
				user.setId(existingUser.getId());
			}
		}
		return (T) userRepository.save(user);
	}

	@Override
	public <T extends BaseModel> void delete(T obj) {
		userRepository.delete((User) obj);
	}
	
	@Override
	public Page<? extends BaseModel> findAll(Predicate predicate, Pageable pagable) {
		return null;
	}
	
	@Override
	public Page<? extends BaseModel> findAll(Pageable pagable) {
		return null;
	}
}
