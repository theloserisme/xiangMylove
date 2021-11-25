package com.pikachu.utils;

import android.app.Application;

import com.pikachu.utils.utils.LogsUtils;
import com.pikachu.utils.utils.SharedPreferencesUtils;
import com.pikachu.utils.utils.ToastUtils;

/**
 * @author pkpk.run
 * @project 通用工程
 * @package com.pikachu.utils
 * @date 2021/9/6
 * @description 略
 */
public class App extends Application {


    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        SharedPreferencesUtils.info(app); // XML 存储
        ToastUtils.info(ToastUtils.S, app); // 提示
    }

    public static App getApp() {
        return app;
    }
}
