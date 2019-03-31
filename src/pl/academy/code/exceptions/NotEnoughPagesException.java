package pl.academy.code.exceptions;

public class NotEnoughPagesException extends Exception{
    @Override
    public String getMessage() {
        return "Za malo stron";
    }
}
