package me.shihao.instrumentedunittests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by shihao on 2017/3/1.
 */
@RunWith(AndroidJUnit4.class)
public class ConfigTest {

    private static String userId;

    @BeforeClass
    public static void setUp() {
        userId = "1002123";
    }

    @Test
    public void setUserId() throws Exception {
        //模拟通过SharedPreferences保存userId
        Context context = InstrumentationRegistry.getTargetContext();
        Config.getInstance(context).setUserId(userId);
    }

    @Test
    public void getUserId() throws Exception {
        //读取保存的数据，对比是否保存成功
        Context context = InstrumentationRegistry.getTargetContext();
        String id = Config.getInstance(context).getUserId();
        assertEquals(userId, id);
    }
}