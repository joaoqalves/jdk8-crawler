package net.joaoqalves.config;

import net.joaoqalves.domain.qualifiers.Qualifier;
import net.joaoqalves.domain.qualifiers.TitleQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "net.joaoqalves")
@EnableAsync
public class AppConfig {

    @Autowired
    private TitleQualifier titleQualifier;

    @Bean
    List<Qualifier> catalogers() {
        List<Qualifier> prospectsQualifiers = new ArrayList<>();
        prospectsQualifiers.add(titleQualifier);
        return prospectsQualifiers;
    }

}
