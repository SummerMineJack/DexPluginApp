package com.huangjian.appdexplugin;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

public class PluginProxyAcivity extends Activity {


    private String className;
    private IPluginActivity iPluginActivity = null;
    private PluginApk pluginApk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getIntent().getStringExtra("className");
        pluginApk = PluginManager.getInstance().getPluginApk();
        try {
            Class<?> clazz = pluginApk.dexClassLoader.loadClass(className);
            Object object = clazz.newInstance();
            if (object instanceof IPluginActivity) {
                iPluginActivity = (IPluginActivity) object;
                iPluginActivity.attach(this);
                Bundle bundle = new Bundle();
                bundle.putInt("FROM", IPluginActivity.FROM_EXTERNAL);
                iPluginActivity.onCreate(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resources getResources() {
        return pluginApk != null ? pluginApk.resources : super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return pluginApk != null ? pluginApk.assetManager : super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return pluginApk != null ? pluginApk.dexClassLoader : super.getClassLoader();
    }
}
