package com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.config;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.constant.CommonConstant;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(CommonConstant.MESSAGE_SOURCE_PATH.getValue());
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.toString());
        messageSource.setDefaultLocale(Locale.ENGLISH);
        messageSource.setCacheSeconds(60);
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
