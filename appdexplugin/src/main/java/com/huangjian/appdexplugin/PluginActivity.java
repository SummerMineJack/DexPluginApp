package com.huangjian.appdexplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PluginActivity extends Activity implements IPluginActivity {
    private int FROM = FROM_INTERNAL;
    private Activity mProxyActivity;

    @Override
    public void attach(Activity activity) {
        mProxyActivity = activity;
    }

    @Override
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            FROM = bundle.getInt("FROM");
        }
        if (FROM == FROM_INTERNAL) {
            super.onCreate(bundle);
            mProxyActivity = this;
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if (FROM == FROM_INTERNAL) {
            super.setContentView(layoutResID);
        } else {
            mProxyActivity.setContentView(layoutResID);
        }
    }

    @Override
    public void onStart() {
        if (FROM == FROM_INTERNAL) {
            super.onStart();
        }

    }

    @Override
    public void onRestart() {
        if (FROM == FROM_INTERNAL) {
            super.onRestart();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (FROM == FROM_INTERNAL) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onResume() {
        if (FROM == FROM_INTERNAL) {
            super.onResume();
        }
    }

    @Override
    public void onPause() {
        if (FROM == FROM_INTERNAL) {
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if (FROM == FROM_INTERNAL) {
            super.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if (FROM == FROM_INTERNAL) {
            super.onDestroy();
        }
    }
}
