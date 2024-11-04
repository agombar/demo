package com.demo.users.payments.sink.domain.repository;

import com.demo.users.payments.sink.domain.exception.ResourceCreateException;
import com.demo.users.payments.sink.domain.exception.ResourceUpdateException;
import com.demo.users.payments.sink.domain.model.User;

public interface UserRepository {

	User create(User user) throws ResourceCreateException;

	User update(User user) throws ResourceUpdateException;

}
