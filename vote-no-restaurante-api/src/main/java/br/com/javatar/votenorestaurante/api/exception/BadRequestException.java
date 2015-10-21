package br.com.javatar.votenorestaurante.api.exception;

/**
 * The Class BusinessException.
 *
 * @author ismael
 */
public class BadRequestException extends RuntimeException {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instancia um novo(a) business exception.
     */
    public BadRequestException() {
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param message O(a)(s) message
     */
    public BadRequestException(String message) {
        super(message);
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param cause O(a)(s) cause
     */
    public BadRequestException(Throwable cause) {
        super(cause);
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param message O(a)(s) message
     * @param cause O(a)(s) cause
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
