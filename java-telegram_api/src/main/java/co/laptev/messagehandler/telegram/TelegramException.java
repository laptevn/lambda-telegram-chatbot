package co.laptev.messagehandler.telegram;

public class TelegramException extends Exception {
    private static final long serialVersionUID = -8705207557155600722L;

    public TelegramException(String message) {
        super(message);
    }

    public TelegramException(String message, Throwable cause) {
        super(message, cause);
    }
}