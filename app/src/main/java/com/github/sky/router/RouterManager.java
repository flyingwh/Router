package com.github.sky.router;

import com.github.sky.router.lib.Router;

/**
 * Created by fuyuxian on 2016/12/27.
 */

public class RouterManager {

    public static void init() {
        Router.put("/activity/second/:title/", SecondActivity.class);
    }
}
