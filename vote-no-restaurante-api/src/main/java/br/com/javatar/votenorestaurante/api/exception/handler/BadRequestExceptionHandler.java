package br.com.javatar.votenorestaurante.api.exception.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import javax.servlet.http.HttpServletRequest;

import br.com.javatar.votenorestaurante.api.exception.BadRequestException;
import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * The Class BusinessExceptionHandler.
 * 
 * @author ismael
 *
 */
public class BadRequestExceptionHandler extends ErrorMessageRestExceptionHandler<BadRequestException> {

    /**
     * Instancia um novo(a) business exception handler.
     */
    public BadRequestExceptionHandler() {
        super(BAD_REQUEST);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ErrorMessage createBody(BadRequestException ex, HttpServletRequest req) {
        return super.createBody(ex, req);
    }
}
