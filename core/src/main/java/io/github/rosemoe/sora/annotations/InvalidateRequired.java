package io.github.rosemoe.sora.annotations;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks you must call {@link View#invalidate()} after changing this property
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD})
public @interface InvalidateRequired {
}