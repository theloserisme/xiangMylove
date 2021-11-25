package com.pikachu.utils.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import static com.pikachu.utils.utils.ToastUtils.context;

/**
 * 创建日期：2021/11/18 15:22
 *
 * @author lcy
 * @version 1.0
 * 包名： com.example.threetool.utils
 * 类说明：
 */

public class WindowUtils {
    public static void setThisWindow(View view, int count1, int count2) {
        WindowManager wManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wManager.getDefaultDisplay().getMetrics(dm);
        ViewGroup.LayoutParams lp;
        lp = view.getLayoutParams();
        lp.height = dm.heightPixels * count1 / count2;
        lp.width = dm.widthPixels;
    }
}
