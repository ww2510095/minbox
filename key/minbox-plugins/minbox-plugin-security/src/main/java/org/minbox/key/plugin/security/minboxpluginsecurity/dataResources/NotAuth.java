package org.minbox.key.plugin.security.minboxpluginsecurity.dataResources;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
@Inherited
public @interface NotAuth {
}
