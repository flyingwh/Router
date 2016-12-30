package com.github.sky.router.lib;

/**
 * Created by fuyuxian on 2016/12/9.
 */

public interface Interceptor {
    /**
     *
     * @return boolean true if intercepted false if not
     */
    boolean intercept(Router.Param param);
}
