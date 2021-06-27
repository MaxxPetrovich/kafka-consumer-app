package org.mpetrov.kafkaconsumerapp.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.mpetrov.kafkaconsumerapp.model.HttpVerb;
import org.mpetrov.kafkaconsumerapp.model.Url;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UrlDeserializer extends StdDeserializer<Url> {

    public UrlDeserializer() {
        this(null);
    }

    public UrlDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Url deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        Url url = new Url();
        Map<String, String> httpHeaders = new HashMap<>();
        Map<String, String> pathVariables = new HashMap<>();
        Map<String, String> queryVariables = new HashMap<>();

        JsonNode node = jp.getCodec().readTree(jp);

        url.setUrl(node.get("url").asText());

        url.setBody(node.get("body").asText());

        String httpVerb = node.get("httpVerb").asText();
        for (HttpVerb hv : HttpVerb.values()) {
            if (httpVerb.equalsIgnoreCase(hv.name())) {
                url.setHttpVerb(hv);
            }
        }
        JsonNode httpHeadersNode = node.get("httpHeaders");
        if (httpHeadersNode != null) {
            for (Map.Entry<String, JsonNode> it : (Iterable<Map.Entry<String, JsonNode>>) () -> httpHeadersNode.fields()) {
                httpHeaders.put(it.getKey(), it.getValue().asText());
            }
        }
        url.setHttpHeaders(httpHeaders);

        JsonNode pathVariablesNode = node.get("pathVariables");
        if (pathVariablesNode != null) {
            for (Map.Entry<String, JsonNode> it : (Iterable<Map.Entry<String, JsonNode>>) () -> pathVariablesNode.fields()) {
                pathVariables.put(it.getKey(), it.getValue().asText());
            }
        }
        url.setPathVariables(pathVariables);

        JsonNode queryVariablesNode = node.get("queryVariables");
        if (queryVariablesNode != null) {
            for (Map.Entry<String, JsonNode> it : (Iterable<Map.Entry<String, JsonNode>>) () -> queryVariablesNode.fields()) {
                queryVariables.put(it.getKey(), it.getValue().asText());
            }
        }
        url.setQueryVariables(queryVariables);

        return url;
    }
}
