package org.minbox.key.plugin.security.minboxpluginsecurity.dataResources;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
@Inherited
public @interface MinboxSecurityAuth {

    String[] SecurityAuthKey() default {};

    boolean isAuthAll() default true;
}
