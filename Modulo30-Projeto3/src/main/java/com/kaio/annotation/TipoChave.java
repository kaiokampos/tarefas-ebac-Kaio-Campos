package com.kaio.annotation;

import java.lang.annotation.*;

/**
 * @author Kaio.kampos
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}