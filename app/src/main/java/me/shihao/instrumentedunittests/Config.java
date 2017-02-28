package me.shihao.instrumentedunittests;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by shihao on 2017/2/28.
 */

public class Config {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static Config instance;

    private Config(Context context) {
        sharedPreferences = context.getSharedPreferences("test", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static Config getInstance(Context context) {
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    /**
     * 模拟待测试方法，通过SharedPreferences保存userId
     *
     * @param userId
     */
    public static void setUserId(String userId) {
        editor.putString("userId", userId);
        editor.commit();
    }

    /**
     * 模拟待测试方法，通过SharedPreferences读取userId
     *
     * @return
     */
    public static String getUserId() {
        return sharedPreferences.getString("userId", "");
    }

}
