package com.skilldistillery.beerlab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
public class AppConfig {
	@Bean
	public FormattingConversionService conversionService() {
		DefaultFormattingConversionService convSvc = new DefaultFormattingConversionService(false);
		DateFormatterRegistrar reg = new DateFormatterRegistrar();
		reg.setFormatter(new DateFormatter("yyyy-MM-dd"));
		reg.registerFormatters(convSvc);
		return convSvc;
	}

}
