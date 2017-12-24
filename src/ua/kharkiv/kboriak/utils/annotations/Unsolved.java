package ua.kharkiv.kboriak.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a class is designed for a training task that is not yet solved.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Unsolved {
}
