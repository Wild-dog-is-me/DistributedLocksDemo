package org.dog.server.annotation;

import java.lang.annotation.*;

/**
 * @Author: Odin
 * @Date: 2023/6/22 02:29
 * @Description:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DistributedLock {

    String key() default "distributedLock";

    long expiredTime() default 30L;

    int maxToRenewNum() default 30;

}
