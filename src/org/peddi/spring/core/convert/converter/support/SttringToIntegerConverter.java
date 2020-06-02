package org.peddi.spring.core.convert.converter.support;

import org.springframework.core.convert.converter.Converter;

public class SttringToIntegerConverter implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		return Integer.valueOf(source);
	}
	

}
