package br.com.javatar.votenorestaurante.service.util;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.google.common.base.Strings;

public final class Violations<T> {

    /** O(a)(s) violations. */
    private final Set<ConstraintViolation<?>> violations;

    /**
     * Instancia um novo(a) violations.
     *
     * @param violations
     *            O(a)(s) violations
     */
    @SuppressWarnings("unchecked")
    public Violations(Set<ConstraintViolation<T>> violations) {
        this.violations = (Set<ConstraintViolation<?>>) (!isEmpty(violations) ? violations : new HashSet<ConstraintViolation<?>>());
    }

    /**
     * Checks for violations.
     * 
     * @return true, if successful
     */
    public boolean hasViolations() {
        return !isEmpty(violations);
    }

    /**
     * None violations.
     * 
     * @return true, if successful
     */
    public boolean noneViolations() {
        return !hasViolations();
    }

    /**
     * Single violation.
     * 
     * @return true, if successful
     */
    public boolean singleViolation() {
        return noneViolations() ? false : violations.size() == 1;
    }

    /**
     * Contains unique message.
     * 
     * @param expectedMessage
     *            the expected message
     * @return true, if successful
     */
    public boolean containsUniqueMessage(String expectedMessage) {
        checkArgument(!Strings.isNullOrEmpty(expectedMessage));
        if (!singleViolation()) {
            return false;
        }

        boolean retorno = false;

        for (ConstraintViolation<?> constraintViolation : violations) {
            if (expectedMessage.equals(constraintViolation.getMessage())) {
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    /**
     * List violations.
     * 
     * @return the list of violations
     */
    public List<String> listViolations() {

        List<String> errorList = new ArrayList<>();
        for (ConstraintViolation<?> violation : violations) {
            errorList.add(violation.getMessage());
        }
        return errorList;
    }

    /**
     * Constraint violations.
     *
     * @return O(a)(s) sets the
     */
    public Set<ConstraintViolation<?>> constraintViolations() {
        return violations;
    }

    /**
     * List violations.
     * 
     * @return the list of violations and PropertyPath
     */
    public List<String> listPropertyPathAndViolations() {

        List<String> errorList = new ArrayList<>();
        for (ConstraintViolation<?> violation : violations) {
            StringBuilder message = new StringBuilder();

            message.append(violation.getPropertyPath());
            if (message.length() > 0) {
                message.append(" ");
            }
            message.append(violation.getMessage());
            errorList.add(message.toString());
        }
        return errorList;
    }
}
