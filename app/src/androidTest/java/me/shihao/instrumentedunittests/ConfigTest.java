package me.shihao.instrumentedunittests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by shihao on 2017/3/1.
 */
@RunWith(AndroidJUnit4.class)
public class ConfigTest {

    @Test
    public void setUserId() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        Config.getInstance(context).setUserId("1002123");
    }

    @Test
    public void getUserId() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        String userId = Config.getInstance(context).getUserId();
        assertEquals("1002123", userId);
    }

}