package com.MangmentRessources.MangRess;

import com.MangmentRessources.MangRess.service.AbstractNativeConsumer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MangRessApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(MangRessApplication.class, args);
//    }
//    =================================================================
    private static final Logger log = LoggerFactory.getLogger(MangRessApplication.class);
//    @Value("${default-lang}")
//    private static String defaultLang;

    public static void main(String[] args) throws UnknownHostException {

        
        SpringApplication app = new SpringApplication(MangRessApplication.class);
//        DefaultProfileUtil.addDefaultProfile(app);
//        Environment env = app.run(args).getEnvironment();
        ConfigurableApplicationContext ctx = app.run(args);
        Environment env = ctx.getEnvironment();
        Boolean kafkaProfileStauts = Arrays.stream(env.getActiveProfiles()).anyMatch("kafka"::equals);
        String consumersStauts = "Consumer(s): \n";
        Collection<AbstractNativeConsumer> consumerInstances = ctx.getBeansOfType(AbstractNativeConsumer.class).values();

        for (AbstractNativeConsumer consumerInstance : consumerInstances) {
            consumersStauts += ("\t\t" + consumerInstance.getConsumerIdentity() + ": " + consumerInstance.getConsumerStatus().toString() + "\n");
        }

        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
//        defaultLang= env.getProperty("default-lang");
        log.info("\n----------------------------------------------------------\n\t"
                + "Application's name '{}' is running! Access URLs:\n\t"
                + "Local: \t\t{}://localhost:{}{}\n\t"
                + "External: \t{}://{}:{}{}\n\t"
                + "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                env.getProperty("server.contextPath"),
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.contextPath"),
                env.getActiveProfiles());
    }

//    -----------------------------------------
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration crosConfiguration = new CorsConfiguration();
        crosConfiguration.setAllowCredentials(true);
        crosConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        crosConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        crosConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        crosConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", crosConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);

    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

///**
// * Hello world!
// *
// */
//public class App 
//{
//    public static void main( String[] args )
//    {
//      
//
//        
//
//    }
//}
}
