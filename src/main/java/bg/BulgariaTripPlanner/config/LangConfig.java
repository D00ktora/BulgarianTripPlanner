package bg.BulgariaTripPlanner.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


@Configuration
public class LangConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver("my-locale-cookie");
    }

//    @Bean
//    public MessageSource messageSource() {
//        final ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
//        ret.setBasename("classpath:lang");
//        ret.setDefaultEncoding("UTF-8");
//        return ret;
//    }
    @Bean
    public LocaleChangeInterceptor localeInterceptor() {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");
        return localeInterceptor;
    }
    @Bean
    public CharacterEncodingInterceptor characterEncodingInterceptor() {
        CharacterEncodingInterceptor interceptor = new CharacterEncodingInterceptor();
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
        registry.addInterceptor(new CharacterEncodingInterceptor());
    }


}
