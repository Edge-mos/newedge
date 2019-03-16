package ru.job4j.banklambda.exeptions;

public class NoSuchAccountException extends RuntimeException {

    public NoSuchAccountException(String message) {
        super(message);

    }
}
