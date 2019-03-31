package pl.academy.code.exceptions;

public class IdiotBugException extends RuntimeException {
    @Override
    public String getMessage() {
        return "tytul jest glupi!!";
    }
}
