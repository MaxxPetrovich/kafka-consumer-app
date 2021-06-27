package org.mpetrov.kafkaconsumerapp.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.mpetrov.kafkaconsumerapp.utils.UrlDeserializer;

import java.util.Map;

@JsonDeserialize(using = UrlDeserializer.class)
public class Url {
    private HttpVerb httpVerb;
    private String url;
    private String body;
    private Map<String, String> httpHeaders;
    private Map<String, String> pathVariables;
    private Map<String, String> queryVariables;


    public Url() {
    }

    public Url(HttpVerb httpVerb, String url, String body, Map<String, String> httpHeaders, Map<String, String> pathVariables, Map<String, String> queryVariables) {
        this.httpVerb = httpVerb;
        this.url = url;
        this.body = body;
        this.httpHeaders = httpHeaders;
        this.pathVariables = pathVariables;
        this.queryVariables = queryVariables;
    }

    public HttpVerb getHttpVerb() {
        return httpVerb;
    }

    public void setHttpVerb(HttpVerb httpVerb) {
        this.httpVerb = httpVerb;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(Map<String, String> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public Map<String, String> getPathVariables() {
        return pathVariables;
    }

    public void setPathVariables(Map<String, String> pathVariables) {
        this.pathVariables = pathVariables;
    }

    public Map<String, String> getQueryVariables() {
        return queryVariables;
    }

    public void setQueryVariables(Map<String, String> queryVariables) {
        this.queryVariables = queryVariables;
    }

    @Override
    public String toString() {
        return httpVerb.toString() + ' ' + url + pathVariables;
    }
}