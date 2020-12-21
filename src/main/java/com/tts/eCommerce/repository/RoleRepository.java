package com.tts.eCommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.eCommerce.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	public Role findByRole(String string);


}
