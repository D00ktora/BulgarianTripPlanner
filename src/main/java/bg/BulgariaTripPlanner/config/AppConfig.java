package bg.BulgariaTripPlanner.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
    return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
  }
    @Bean
    public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    /*
@Use if we have a LocalDate convert. But not LocalDateTime or LocalTime.
@Format (dd/MM/yyyy) needs to be set up according to input format.
 */
//    modelMapper.addConverter(new Converter<String, LocalDate>() {
//      @Override
//      public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
//        return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//      }
//    });


        modelMapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                return LocalDateTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            }
        });
        modelMapper.addConverter(new Converter<LocalDateTime, String>() {
            @Override
            public String convert(MappingContext<LocalDateTime, String> context) {
                final DateTimeFormatter CUSTOM_FORMATER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime source = context.getSource();
                String formated = source.format(CUSTOM_FORMATER);
                return formated;
            }
        });
    return modelMapper;
    }
}
