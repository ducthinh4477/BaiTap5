package vn.iotstar.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

@Configuration
public class SitemeshConfig {

    @Bean
    public FilterRegistrationBean<ConfigurableSiteMeshFilter> siteMeshFilter() {
        FilterRegistrationBean<ConfigurableSiteMeshFilter> filter =  
                new FilterRegistrationBean<>();
        filter.setFilter(new ConfigurableSiteMeshFilter());
        return filter;
    }
}
