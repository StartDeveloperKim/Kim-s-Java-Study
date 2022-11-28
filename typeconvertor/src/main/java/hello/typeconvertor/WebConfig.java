package hello.typeconvertor;

import hello.typeconvertor.converter.IntegerToStringConverter;
import hello.typeconvertor.converter.IpPortToStringConverter;
import hello.typeconvertor.converter.StringToIntegerConverter;
import hello.typeconvertor.converter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
    }
}
