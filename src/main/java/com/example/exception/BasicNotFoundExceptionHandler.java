package com.example.exception;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
public class BasicNotFoundExceptionHandler implements ExceptionHandler<BasicNotFoundException, HttpResponse<Void>> {

    @Override
    public HttpResponse<Void> handle(HttpRequest request, BasicNotFoundException exception) {
        return HttpResponse.notFound();
    }
}
