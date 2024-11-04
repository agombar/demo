package com.demo.payments.processor.infrastructure.util;

import com.demo.payments.processor.infrastructure.exception.HydrationException;

public interface JsonHydrator {

	<T> T hydrate(String json, Class<T> type) throws HydrationException;

	<T> String dehydrate(T message) throws HydrationException;

}
