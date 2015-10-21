package br.com.javatar.votenorestaurante.service.exception;

import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class BusinessException.
 *
 * @author ismael
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /** O(a)(s) error msgs. */
    private final Map<String, String> errorMsgs = new HashMap<String, String>();

    /**
     * Instancia um novo(a) business exception.
     */
    public BusinessException() {
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param message O(a)(s) message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param cause O(a)(s) cause
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param message O(a)(s) message
     * @param cause O(a)(s) cause
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param message O(a)(s) message
     * @param cause O(a)(s) cause
     * @param enableSuppression O(a)(s) enable suppression
     * @param writableStackTrace O(a)(s) writable stack trace
     */
    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param errorMsgs O(a)(s) error msgs
     * @param message O(a)(s) message
     * @param cause O(a)(s) cause
     */
    public BusinessException(Map<String, String> errorMsgs, String message, Throwable cause) {
        super(message, cause);
        if (!isEmpty(errorMsgs)) {
            this.errorMsgs.clear();
            this.errorMsgs.putAll(errorMsgs);
        }
    }
    
    /**
     * Instancia um novo(a) business exception.
     *
     * @param errorMsgs O(a)(s) error msgs
     * @param message O(a)(s) message
     */
    public BusinessException(Map<String, String> errorMsgs) {
        this(errorMsgs, "Erro de validação");
    }

    /**
     * Instancia um novo(a) business exception.
     *
     * @param errorMsgs O(a)(s) error msgs
     * @param message O(a)(s) message
     */
    public BusinessException(Map<String, String> errorMsgs, String message) {
        super(message);
        if (!isEmpty(errorMsgs)) {
            this.errorMsgs.clear();
            this.errorMsgs.putAll(errorMsgs);
        }
    }

    /**
     * Obtém o valor do(a)(s) error msgs.
     *
     * @return O(a)(s) error msgs
     */
    public Map<String, String> getError() {
        return Collections.unmodifiableMap(errorMsgs);
    }
    
}
