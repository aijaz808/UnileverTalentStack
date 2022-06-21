package com.unilever.utilityservice.common;

import java.util.Collection;

public abstract class Assert {

    private static final String NOT_NULL_MESSAGE = "Object must not be null";
    private static final String INVALID_STATE_MESSAGE = "Provided expression is not statisfied";
    private static final String INVALID_TEXT_MESSAGE = "Provided text can not be empty";
    private static final String EMPTY_ARRAY_MESSAGE = "Provided array can not be empty";
    private static final String EMPTY_COLLECTION_MESSAGE = "Provided collection can not be empty";

    /**
     * Asserts that provided text message contains at least one printable
     * (non-white-space) character.
     *
     * @param text message for assertion.
     * @throws IllegalArgumentException if provided text is either null or empty.
     */
    public static void hasText(final String text) throws IllegalArgumentException {
        hasText(text, INVALID_TEXT_MESSAGE);
    }

    /**
     * Asserts that provided text message contains at least one printable
     * (non-white-space) character.
     *
     * @param text message for assertion.
     * @param message message to be used if assertion fails.
     * @throws IllegalArgumentException if provided text is either null or empty.
     */
    public static void hasText(final String text, final String message) throws IllegalArgumentException {
        if (text == null || text.trim().isEmpty())
            throw new IllegalArgumentException(message);
    }

    /**
     * Asserts that provided object is not null.
     *
     * @param object the object for assertion.
     * @throws IllegalArgumentException if provided object is <code>null</code>.
     */
    public static void notNull(final Object object) throws IllegalArgumentException {
        notNull(object, NOT_NULL_MESSAGE);
    }

    /**
     * Asserts that provided object is not null.
     *
     * @param object the object for assertion.
     * @param message exception message to be used if assertion fails.
     * @throws IllegalArgumentException if provided object is <code>null</code>.
     */
    public static void notNull(final Object object, final String message) throws IllegalArgumentException {
        if (object == null)
            throw new IllegalArgumentException(message);
    }

    /**
     * Asserts that provided expression is <code>true</code>.
     *
     * @param expression expression to be used for assertion.
     * @throws IllegalArgumentException if provided expression is <code>false</code>.
     */
    public static void isTrue(final boolean expression) throws IllegalArgumentException {
        isTrue(expression, INVALID_STATE_MESSAGE);
    }

    /**
     * Asserts that provided expression is <code>true</code>.
     *
     * @param expression expression to be used for assertion.
     * @param message exception message to be used if assertion fails.
     * @throws IllegalArgumentException if provided expression is <code>false</code>.
     */
    public static void isTrue(final boolean expression, final String message) throws IllegalArgumentException {
        if (!expression)
            throw new IllegalArgumentException(message);
    }

    /**
     * Asserts that provided state is valid. Call isTrue if you wish to throw
     * <code>IllegalArgumentException</code> on an assertion failure.
     *
     * @param expression state to be used for assertion.
     * @throws IllegalStateException if provided state is invalid.
     */
    public static void state(final boolean expression) throws IllegalStateException {
        state(expression, INVALID_STATE_MESSAGE);
    }

    /**
     * Asserts that provided state is valid. Call isTrue if you wish to throw
     * <code>IllegalArgumentException</code> on an assertion failure.
     *
     * @param expression state to be used for assertion.
     * @param message exception message to be used if assertion fails.
     * @throws IllegalStateException if provided state is invalid.
     */
    public static void state(final boolean expression, String message) throws IllegalStateException {
        if (!expression)
            throw new IllegalStateException(message);
    }

    /**
     * Asserts that provided array is not null and not empty.
     *
     * @param array instance of array to be used for assertion.
     * @throws IllegalArgumentException if provided array is either null or empty.
     */
    public static void notEmpty(final Object[] array) throws IllegalArgumentException {
        notEmpty(array, EMPTY_ARRAY_MESSAGE);
    }

    /**
     * Asserts that provided array is not null and not empty.
     *
     * @param array instance of array to be used for assertion.
     * @param message exception message to be used if assertion fails.
     * @throws IllegalArgumentException if provided array is either null or empty.
     */
    public static void notEmpty(final Object[] array, final String message) throws IllegalArgumentException {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException(message);
    }

    /**
     * Asserts that provided collection is not null and not empty.
     *
     * @param values instance of collection to be used for assertion.
     * @throws IllegalArgumentException if provided collection is either null or empty.
     */
    public static void notEmpty(final Collection<?> values) throws IllegalArgumentException {
        notEmpty(values, EMPTY_COLLECTION_MESSAGE);
    }

    /**
     * Asserts that provided collection is not null and not empty.
     *
     * @param values instance of collection to be used for assertion.
     * @param message exception message to be used if assertion fails.
     * @throws IllegalArgumentException if provided collection is either null or empty.
     */
    public static void notEmpty(final Collection<?> values, final String message) throws IllegalArgumentException {
        if (values == null || values.isEmpty())
            throw new IllegalArgumentException(message);
    }
}
