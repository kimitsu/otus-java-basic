package ru.otus.java.basic.http.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.exceptions.BadRequestException;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private static final Logger logger = LogManager.getLogger(HttpRequest.class);
    private String rawRequest;
    private String uri;
    private HttpMethod method;
    private Map<String, String> parameters;
    private Map<String, String> headers;
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
        if (endIndex == -1) {
            throw new BadRequestException("HTTP version not specified");
        }
        this.uri = rawRequest.substring(startIndex + 1, endIndex);
        logger.trace("uri = {}", this.uri);
        try {
            this.method = HttpMethod.valueOf(rawRequest.substring(0, startIndex));
            logger.trace("method = {}", this.method);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Unsupported method specified");
        }
        parseParameters();
        parseBody();
        parseHeaders();
    }

    private void parseHeaders() throws BadRequestException {
        logger.trace("Parsing headers");
        headers = new HashMap<>();
        int startIndex = rawRequest.indexOf("\r\n");
        if (startIndex == -1) {
            throw new BadRequestException("Missing newline");
        }
        while (true) {
            int endIndex = rawRequest.indexOf("\r\n", startIndex + 2);
            int delimiterIndex = rawRequest.indexOf(':', startIndex + 2);
            logger.trace("startIndex = {}; delimiterIndex = {}; endIndex = {}", startIndex, delimiterIndex, endIndex);
            if (delimiterIndex == -1 || delimiterIndex > endIndex) {
                break;
            }
            String headerKey = rawRequest.substring(startIndex + 2, delimiterIndex);
            logger.trace("Parsing header = {}", headerKey);
            StringBuilder builder = new StringBuilder(rawRequest.substring(delimiterIndex + 1, endIndex).stripLeading());
            while (rawRequest.charAt(endIndex + 2) == ' ' || rawRequest.charAt(endIndex + 2) == '\t') {
                logger.trace("Parsing additional line");
                startIndex = endIndex + 2;
                endIndex = rawRequest.indexOf("\r\n", startIndex);
                if (endIndex == -1) {
                    throw new BadRequestException("Missing newline");
                }
                builder.append(rawRequest.substring(startIndex, endIndex).stripLeading());
            }
            String headerValue = builder.toString();
            logger.debug("Header {} = {}", headerKey, headerValue);
            headers.put(headerKey, headerValue);
            startIndex = endIndex + 2;
        }
    }

    private void parseBody() {
        if (method == HttpMethod.POST) {
            logger.trace("Parsing body");
            int bodyStart = rawRequest.indexOf("\r\n\r\n");
            if (bodyStart > -1) {
                body = rawRequest.substring(bodyStart + 4);
                logger.trace("Body (length = {}):{}{}", body.length(), System.lineSeparator(), body);
            } else {
                logger.trace("Body absent");
            }
        }
    }

    private void parseParameters() throws BadRequestException {
        parameters = new HashMap<>();
        if (!uri.contains("?")) {
            logger.trace("URI Parameters absent");
            return;
        }
        logger.trace("Parsing URI parameters");
        String[] elements = uri.split("[?]", 2);
        uri = elements[0];
        String[] keysValues = elements[1].split("&");
        for (String keyValue : keysValues) {
            String[] parts = keyValue.split("=", 2);
            if (parts.length < 2) {
                throw new BadRequestException("Missing delimiter between a key and a value in a parameter");
            }
            logger.trace("Parameter {} = {}", parts[0], parts[1]);
            parameters.put(parts[0], parts[1]);
        }
    }

    public boolean accepts(String mime) {
        return !containsHeader("Accept")
                || getHeader("Accept").contains("*/*")
                || getHeader("Accept").contains(mime); // TODO Correct parsing and wildcard matching

    }

    public String getHeader(String headerKey) {
        return headers.get(headerKey);
    }
    public boolean containsHeader(String headerKey) {
        return headers.containsKey(headerKey);
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

    public void log() {
        logger.info("{} {}", method, uri);
    }

    public String getRoutingKey() {
        return method.name() + " " + uri;
    }
}
