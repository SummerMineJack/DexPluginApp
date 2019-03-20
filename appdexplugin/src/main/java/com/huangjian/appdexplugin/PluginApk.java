package com.huangjian.appdexplugin;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

public class PluginApk {
    public DexClassLoader dexClassLoader;
    public AssetManager assetManager;
    public Resources resources;
    public PackageInfo packageInfo;

    public PluginApk(DexClassLoader dexClassLoader,
                     Resources resources, PackageInfo packageInfo) {
        this.dexClassLoader = dexClassLoader;
        this.assetManager = resources.getAssets();
        this.resources = resources;
        this.packageInfo = packageInfo;
    }
}
