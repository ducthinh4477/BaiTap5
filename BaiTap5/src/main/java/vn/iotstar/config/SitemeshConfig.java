package vn.iotstar.config;

@Configuration
public class SitemeshConfig {

    @Bean
    public FilterRegistrationBean<ConfigurableSiteMeshFilter> siteMeshFilter() {
        FilterRegistrationBean<ConfigurableSiteMeshFilter> filter =
                new FilterRegistrationBean<>();
        filter.setFilter(new ConfigurableSiteMeshFilter());
        filter.addUrlPatterns("/*");
        return filter;
    }

}
