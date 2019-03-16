package ru.job4j.banklambda.exeptions;

public class NoSuchClientException extends RuntimeException {
    public NoSuchClientException(String message) {
        super(message);
    }

    public NoSuchClientException() {
    }
}
