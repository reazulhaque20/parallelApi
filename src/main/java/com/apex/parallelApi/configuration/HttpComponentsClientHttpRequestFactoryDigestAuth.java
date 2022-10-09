//package com.apex.parallelApi.configuration;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//
//import java.net.URI;
//
//public class HttpComponentsClientHttpRequestFactoryDigestAuth extends HttpComponentsClientHttpRequestFactory {
//    HttpHost host;
//
//    public HttpComponentsClientHttpRequestFactoryDigestAuth(HttpHost host, HttpClient httpClient) {
//        super(httpClient);
//        this.host = host;
//    }
//
//    @Override
//    protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
//        return createHttpContext();
//    }
//
//    private HttpContext createHttpContext() {
//        // Create AuthCache instance
//        AuthCache authCache = new BasicAuthCache();
//        // Generate DIGEST scheme object, initialize it and add it to the local auth cache
//        DigestScheme digestAuth = new DigestScheme();
//        // If we already know the realm name
//        digestAuth.overrideParamter("realm", "Custom Realm Name");
//        authCache.put(host, digestAuth);
//
//        // Add AuthCache to the execution context
//        BasicHttpContext localcontext = new BasicHttpContext();
//        localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
//        return localcontext;
//    }
//}
