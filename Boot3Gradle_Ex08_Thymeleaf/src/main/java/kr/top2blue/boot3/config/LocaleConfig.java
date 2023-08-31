package kr.top2blue.boot3.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {
	@Bean 
	LocaleResolver localeResolver() {
	    CookieLocaleResolver localeResolver = new CookieLocaleResolver(); 
	    localeResolver.setDefaultLocale(Locale.US);
	    return localeResolver;
	}
	
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	    localeChangeInterceptor.setParamName("locale"); // 컨트롤러에서 받는 변수값
	    return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
	    interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}
}
