package ru.netology;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String name) {
        super("Игрок под именем " + name + "не зарегистрирован");
    }

}
