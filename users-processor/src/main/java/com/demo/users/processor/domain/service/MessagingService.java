package com.demo.users.processor.domain.service;

import com.demo.users.processor.domain.exception.PublishMessageException;
import com.demo.users.processor.domain.model.User;

public interface MessagingService {

	void publishUserCreated(User user) throws PublishMessageException;

	void publishUserUpdated(User user) throws PublishMessageException;

}
