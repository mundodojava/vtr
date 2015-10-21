package br.com.javatar.votenorestaurante.api.exception.handler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;

import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * The Class BusinessExceptionHandler.
 *
 */
public class EmptyResultDataAccessExceptionHandler extends ErrorMessageRestExceptionHandler<EmptyResultDataAccessException> {

    /**
     * Instancia um novo(a) business exception handler.
     */
    public EmptyResultDataAccessExceptionHandler() {
        super(NOT_FOUND);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ErrorMessage createBody(EmptyResultDataAccessException ex, HttpServletRequest req) {
        ErrorMessage msg = super.createBody(ex, req);
        msg.setDetail(ex.getMessage());
        return msg;
    }
}
