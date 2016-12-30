package com.github.sky.router.lib;

import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.AppCompatActivity;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import org.junit.runner.RunWith;

import java.io.Serializable;

/**
 * Created by fuyuxian on 2016/12/9.
 */

@RunWith(AndroidJUnit4.class)
public class RouterTest extends AndroidTestCase {

    public void test_basic_url() {
        Router.clear();
        Router.put("/user/:name/", AppCompatActivity.class);
        Router router = Router.getInstance(getContext())
                              .url("/user/:sky");
        router.tryToMatch();
        Intent intent = router.getIntent();
        Assert.assertEquals("sky", intent.getStringExtra("name"));
    }


//    public void test_basic_param() {
//        Router.clear();
//        Router.put("/user/:name", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/")
//                              .addParam("name", "sky");
//        router.tryToMatch();
//        Intent intent = router.getIntent();
//        Assert.assertEquals("sky", intent.getStringExtra("name"));
//    }
//
//    public void test_basic_param2() {
//        Router.clear();
//        Router.put("/user/:name/:age?", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/")
//                              .addParam("name", "sky")
//                              .addParam("age", "4");
//        router.tryToMatch();
//        Intent intent = router.getIntent();
//        Assert.assertEquals("sky", intent.getStringExtra("name"));
//        Assert.assertEquals("4", intent.getStringExtra("age"));
//    }
//
//    public void test_basic_param3() {
//        Router.clear();
//        Router.put("/user/:name/:age?", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/")
//                              .addParam("name", "sky");
//        router.tryToMatch();
//        Intent intent = router.getIntent();
//        Assert.assertEquals("sky", intent.getStringExtra("name"));
//    }
//
//    public void test_basic_url_serializable() {
//        Router.clear();
//        User user = new User();
//        user.name = "sky";
//        user.age = 5;
//        Router.put("/user/:name/@user", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/:sky")
//                              .addSerializableParam("user", user);
//        router.tryToMatch();
//        Intent intent = router.getIntent();
//        User user1 = (User) intent.getSerializableExtra("user");
//        Assert.assertEquals(user.toString(), user1.toString());
//    }
//
//    public void test_basic_url_serializable2() {
//        Router.clear();
//        User user = new User();
//        user.name = "sky";
//        user.age = 5;
//        Router.put("/user/:name/@user/@boss?", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/:sky")
//                              .addSerializableParam("user", user)
//                              .addSerializableParam("boss", user);
//        router.tryToMatch();
//        Intent intent = router.getIntent();
//        User user1 = (User) intent.getSerializableExtra("user");
//        User user2 = (User) intent.getSerializableExtra("boss");
//        Assert.assertEquals(user.toString(), user1.toString());
//        Assert.assertEquals(user.toString(), user2.toString());
//    }
//
//    public void test_basic_url_serializable3() {
//        Router.clear();
//        User user = new User();
//        user.name = "sky";
//        user.age = 5;
//        Router.put("/user/:name/@user/@boss?", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/:sky")
//                              .addSerializableParam("user", user);
//        router.tryToMatch();
//        Intent intent = router.getIntent();
//        User user1 = (User) intent.getSerializableExtra("user");
//        Assert.assertEquals(user.toString(), user1.toString());
//    }
//
//    public void test_basic_flag() {
//        Router.clear();
//        Router.put("/user/:name", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .flag(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                              .flag(Intent.FLAG_ACTIVITY_NEW_TASK)
//                              .url("/user/:sky");
//        router.tryToMatch();
//        Intent intent = router.getIntent();
//        Assert.assertEquals("sky", intent.getStringExtra("name"));
//        Assert.assertEquals(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK,
//                            intent.getFlags());
//    }
//
//    public void test_exception_url_num() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        Router.put("/user/:name/:age", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/:sky");
//        try {
//            router.tryToMatch();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("Invalid route param num did not throw exception", exceptionThrown);
//    }
//
//    public void test_exception_optional_param() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        Router.put("/user/:name/:age?", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/:sky");
//        try {
//            router.tryToMatch();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("Invalid method called did not throw exception", exceptionThrown);
//    }
//
//    public void test_exception_param_num() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        Router.put("/user/:name/:age", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .addParam("age", String.valueOf(5))
//                              .url("/user/");
//        try {
//            router.tryToMatch();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("Invalid route param num did not throw exception", exceptionThrown);
//    }
//
//    public void test_exception_both_url_and_param() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        Router.put("/user/:name/:age", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .addParam("name", "sky")
//                              .url("/user/:5");
//        try {
//            router.tryToMatch();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("Invalid param configuration did not throw exception", exceptionThrown);
//    }
//
//    public void test_exception_param_not_exist1() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        Router.put("/user/:name/:age?", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/")
//                              .addParam("user", "sky")
//                              .addParam("aaa", "dd");
//        try {
//            router.tryToMatch();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("param not exists did not throw exception", exceptionThrown);
//    }
//
//    public void test_exception_param_not_exist2() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        User user = new User();
//        user.name = "sky";
//        user.age = 5;
//        Router.put("/user/@user/", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/")
//                              .addSerializableParam("user", user)
//                              .addSerializableParam("ddd", "ss");
//        try {
//            router.tryToMatch();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("param not exists did not throw exception", exceptionThrown);
//    }
//
//    public void test_exception_url_not_match1() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        Router.put("/user/:name/:age", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/info/");
//        try {
//            router.tryToMatch();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("url not tryToMatch did not throw exception", exceptionThrown);
//    }
//
//
//    public void test_exception_url_not_match2() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        Router.put("/user/info/:name/:age", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .url("/user/");
//        try {
//            router.tryToMatch();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("url not tryToMatch did not throw exception", exceptionThrown);
//    }
//
//    public void test_exception_result_no_activity() {
//        boolean exceptionThrown = false;
//        Router.clear();
//        Router.put("/user/:name", AppCompatActivity.class);
//        Router router = Router.getInstance(getContext())
//                              .needResult(true)
//                              .resultCode(20)
//                              .url("/user/:sky");
//        try {
//            router.open();
//        } catch (IllegalArgumentException e) {
//
//            exceptionThrown = true;
//        }
//
//        Assert.assertTrue("activity or fragment did not found did not throw exception",
//                          exceptionThrown);
//    }
//
//    public void test_isAllPrimitiveRequired() {
//        Router router = Router.getInstance(getContext());
//        String url1 = "/user/:name/:age?";
//        String url2 = "/user/:name/:age";
//        String url3 = "/user/:name/:age/@user?/";
//        Assert.assertTrue("", !router.isAllPrimitiveRequired(url1));
//        Assert.assertTrue("", router.isAllPrimitiveRequired(url2));
//        Assert.assertTrue("", router.isAllPrimitiveRequired(url3));
//    }
//
//    class User implements Serializable {
//        public String name;
//        public int age;
//
//        @Override
//        public String toString() {
//            return name + ":" + age;
//        }
//    }


}

