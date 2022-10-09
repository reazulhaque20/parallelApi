//package com.apex.parallelApi.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class ClientConfig {
//    @Bean
//    public RestTemplate restTemplate() {
//        HttpHost host = new HttpHost("192.168.4.24", 80, "http");
//        CloseableHttpClient client = HttpClientBuilder.create().
//                setDefaultCredentialsProvider(provider()).useSystemProperties().build();
//        HttpComponentsClientHttpRequestFactory requestFactory =
//                new HttpComponentsClientHttpRequestFactoryDigestAuth(host, client);
//
//        return new RestTemplate(requestFactory);
//    }
//
//    private CredentialsProvider provider() {
//        CredentialsProvider provider = new BasicCredentialsProvider();
//        UsernamePasswordCredentials credentials =
//                new UsernamePasswordCredentials("admin", "Hik12345");
//        provider.setCredentials(AuthScope.ANY, credentials);
//        return provider;
//    }
//}
