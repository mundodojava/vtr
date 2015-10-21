package br.com.javatar.votenorestaurante.api.exception.handler;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import br.com.javatar.votenorestaurante.service.exception.BusinessException;
import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;
import cz.jirutka.spring.exhandler.messages.ValidationErrorMessage;

/**
 * The Class BusinessExceptionHandler.
 * 
 * @author ismael
 *
 */
public class BusinessExceptionHandler extends ErrorMessageRestExceptionHandler<BusinessException> {

    /**
     * Instancia um novo(a) business exception handler.
     */
    public BusinessExceptionHandler() {
        super(UNPROCESSABLE_ENTITY);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ErrorMessage createBody(BusinessException ex, HttpServletRequest req) {
        ValidationErrorMessage msg = new ValidationErrorMessage(super.createBody(ex, req));
        for(Entry<String, String> message : ex.getError().entrySet()) {
            msg.addError(message.getKey(), null, message.getValue());
        }
        msg.setDetail(ex.getMessage());
        return msg;
    }
}
