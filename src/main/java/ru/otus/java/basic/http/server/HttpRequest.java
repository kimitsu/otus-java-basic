package ru.otus.java.basic.http.server;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String rawRequest;
    private String uri;
    private HttpMethod method;
    private Map<String, String> parameters;
    private String body;

    public HttpRequest(String rawRequest) throws BadRequestException {
        this.rawRequest = rawRequest;
        this.parse();
    }

    private void parse() throws BadRequestException {
        int startIndex = rawRequest.indexOf(' ');
        if (startIndex == -1) {
            throw new BadRequestException("URI not specified");
        }
        int endIndex = rawRequest.indexOf(' ', startIndex + 1);
        if (startIndex == -1) {
            throw new BadRequestException("HTTP version not specified");
        }
        this.uri = rawRequest.substring(startIndex + 1, endIndex);
        try {
            this.method = HttpMethod.valueOf(rawRequest.substring(0, startIndex));
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Unsupported method specified");
        }
        this.parameters = new HashMap<>();
        if (uri.contains("?")) {
            String[] elements = uri.split("[?]", 2);
            this.uri = elements[0];
            String[] keysValues = elements[1].split("&");
            for (String keyValue : keysValues) {
                String parts[] = keyValue.split("=", 2);
                if (parts.length < 2) {
                    throw new BadRequestException("Missing delimiter between a key and a value in a parameter");
                }
                this.parameters.put(parts[0], parts[1]);
            }
        }
        if (method == HttpMethod.POST) {
            int bodyStart = rawRequest.indexOf("\r\n\r\n");
            if (bodyStart > -1) {
                this.body = rawRequest.substring(bodyStart + 4);
            }
        }
    }

    public String getUri() {
        return uri;
    }

    public String getBody() {
        return body;
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }

    public boolean containsParameter(String key) {
        return parameters.containsKey(key);
    }

    public void printInfo(boolean showRawRequest) {
        System.out.println("uri: " + uri);
        System.out.println("method: " + method);
        if (showRawRequest) {
            System.out.println(rawRequest);
        }
    }

    public String getRoutingKey() {
        return method.name() + " " + uri;
    }
}
