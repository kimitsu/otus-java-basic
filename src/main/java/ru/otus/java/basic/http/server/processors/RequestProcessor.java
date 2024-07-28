package ru.otus.java.basic.http.server.processors;

import ru.otus.java.basic.http.server.exceptions.BadRequestException;
import ru.otus.java.basic.http.server.HttpContext;
import ru.otus.java.basic.http.server.HttpRequest;
import ru.otus.java.basic.http.server.exceptions.NotAcceptableException;

import java.io.IOException;
import java.io.OutputStream;

public interface RequestProcessor {
    void process(HttpRequest request, HttpContext context, OutputStream out) throws IOException, BadRequestException, NotAcceptableException;
}
