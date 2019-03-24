package com.huangjian.thridapp;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.huangjian.appdexplugin.PluginActivity;

public class MainActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnClickListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showLong("来自插件app的Toast提示");
            }
        });
    }
}
