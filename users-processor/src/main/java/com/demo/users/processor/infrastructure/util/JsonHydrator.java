package com.demo.users.processor.infrastructure.util;

import com.demo.users.processor.infrastructure.exception.HydrationException;

public interface JsonHydrator {

	<T> T hydrate(String json, Class<T> type) throws HydrationException;

	<T> String dehydrate(T message) throws HydrationException;

}
