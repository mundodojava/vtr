package br.com.javatar.votenorestaurante.service.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.NoSuchMessageException;

import br.com.javatar.votenorestaurante.service.exception.BusinessException;

import com.google.common.base.Preconditions;

public final class ValidatorUtil {

    private static final Validator VALIDATOR = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory().getValidator();

    /**
     * Instancia um novo(a) validator util.
     */
    private ValidatorUtil() {
    }

    /**
     * Validates all constraints on <code>object</code>.
     *
     * @param <T>
     *            O tipo genérico
     * @param objetc
     *            O(a)(s) objetc
     * @param groups
     *            group or list of groups targeted for validation (default to {@link javax.validation.groups.Default})
     */
    public static <T> void checkBeanViolations(final T objetc, Class<?>... groups) {
        Violations<T> violations = validate(objetc, groups);
        if (violations.hasViolations()) {
            throw new ConstraintViolationException("Erro de validação", violations.constraintViolations());
        }
    }

    /**
     * Validate.
     *
     * @param <T>
     *            O tipo genérico
     * @param objetc
     *            O(a)(s) objetc
     * @param groups
     *            O(a)(s) groups
     * @return O(a)(s) violations
     */
    public static <T> Violations<T> validate(final T objetc, Class<?>... groups) {
        return new Violations<T>(constraintViolations(objetc, groups));
    }

    /**
     * Validates all constraints on <code>object</code>.
     *
     * @param <T>
     *            O tipo genérico
     * @param object
     *            object to validate
     * @param groups
     *            group or list of groups targeted for validation (default to {@link javax.validation.groups.Default})
     * @return constraint violations or an empty Set if none
     */
    public static <T> Set<ConstraintViolation<T>> constraintViolations(T object, Class<?>... groups) {
        Preconditions.checkArgument(object != null);
        return VALIDATOR.validate(object, groups);
    }

    /**
     * Validates all constraints placed on the property of <code>object</code> named <code>propertyName</code>.
     *
     * @param <T>
     *            O tipo genérico
     * @param object
     *            object to validate
     * @param propertyName
     *            property to validate (ie field and getter constraints)
     * @param groups
     *            group or list of groups targeted for validation (default to {@link javax.validation.groups.Default})
     * @return constraint violations or an empty Set if none
     */
    public static <T> Set<ConstraintViolation<T>> validateProperty(final T object, final String propertyName, final Class<?>... groups) {
        Preconditions.checkArgument(object != null);
        Preconditions.checkArgument(propertyName != null);
        return VALIDATOR.validateProperty(object, propertyName, groups);
    }

    /**
     * Validate value.
     *
     * @param <T>
     *            O tipo genérico
     * @param beanType
     *            O(a)(s) bean type
     * @param propertyName
     *            O(a)(s) property name
     * @param value
     *            O(a)(s) value
     * @param groups
     *            O(a)(s) groups
     * @return O(a)(s) sets the
     */
    public static <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        Preconditions.checkArgument(beanType != null);
        Preconditions.checkArgument(propertyName != null);
        return VALIDATOR.validateValue(beanType, propertyName, value, groups);
    }

    /**
     * Validates all constraints placed on the property of <code>object</code> named <code>propertyName</code>.
     *
     * @param <T>
     *            O tipo genérico
     * @param object
     *            object to validate
     * @param propertyName
     *            property to validate (ie field and getter constraints)
     * @param groups
     *            group or list of groups targeted for validation (default to {@link javax.validation.groups.Default})
     * @return violations
     */
    public static <T> Violations<T> constraintViolations(final T object, final String propertyName, final Class<?>... groups) {
        return new Violations<T>(validateProperty(object, propertyName, groups));
    }

    /**
     * Validates all constraints placed on the property of <code>object</code> named <code>propertyName</code>.
     *
     * @param <T>
     *            O tipo genérico
     * @param beanType
     *            O(a)(s) bean type
     * @param properties
     *            O(a)(s) properties
     * @param groups
     *            group or list of groups targeted for validation (default to {@link javax.validation.groups.Default})
     * @return violations
     */
    public static <T> Violations<T> constraintViolations(Class<T> beanType, Map<String, Object> properties, Class<?>... groups) {
        Preconditions.checkArgument(beanType != null);
        Preconditions.checkArgument(properties != null);
        Set<ConstraintViolation<T>> violations = new HashSet<>();
        for (Entry<String, Object> propertie : properties.entrySet()) {
            violations.addAll(validateValue(beanType, propertie.getKey(), propertie.getValue(), groups));
        }
        return new Violations<T>(violations);
    }

    /**
     * Check bean violations.
     *
     * @param <T>
     *            O tipo genérico
     * @param errorMsgs
     *            O(a)(s) error msgs
     * @param objetc
     *            O(a)(s) objetc
     * @param groups
     *            O(a)(s) groups
     * @throws BusinessException
     *             se violations ou errorMsgs for diferente de vazio
     */
    public static <T> void checkViolations(final Violations<T> violations) {
        checkViolations(new HashMap<String, String>(), violations);
    }
    
    
    public static <T> void checkViolations(final Map<String, String> errorMsgs) {
        checkViolations(errorMsgs, new Violations<T>(new HashSet<ConstraintViolation<T>>()));
    }

    /**
     * Check bean violations.
     *
     * @param <T>
     *            O tipo genérico
     * @param errorMsgs
     *            O(a)(s) error msgs
     * @param objetc
     *            O(a)(s) objetc
     * @param groups
     *            O(a)(s) groups
     * @throws BusinessException
     *             se violations ou errorMsgs for diferente de vazio
     */
    public static <T>  void checkViolations(final Map<String, String> errorMsgs, final Violations<T> violations) {
        Map<String, String> mapaErrorMsgs = new HashMap<String, String>();
        if (errorMsgs != null && !errorMsgs.isEmpty()) {
            mapaErrorMsgs.putAll(errorMsgs);
        }

        if (violations != null && violations.hasViolations()) {
            for (ConstraintViolation<?> violation : violations.constraintViolations()) {
                try {
                    mapaErrorMsgs.put(violation.getPropertyPath().toString(), violation.getMessage());
                } catch (NoSuchMessageException e) {
                    mapaErrorMsgs.put(violation.getPropertyPath().toString(), violation.getMessage());
                }
            }
        }
        if (!mapaErrorMsgs.isEmpty()) {
            throw new BusinessException(mapaErrorMsgs, "Erro de validação");
        }
    }

}
