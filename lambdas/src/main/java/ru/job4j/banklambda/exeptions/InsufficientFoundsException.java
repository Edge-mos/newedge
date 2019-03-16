package ru.job4j.banklambda.exeptions;

public class InsufficientFoundsException extends RuntimeException {
    public InsufficientFoundsException(String message) {
        super(message);
    }
}
