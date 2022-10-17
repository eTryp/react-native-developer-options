package com.reactnativedeveloperoptions;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.util.Objects;

@ReactModule(name = DeveloperOptionsModule.NAME)
public class DeveloperOptionsModule extends ReactContextBaseJavaModule {
    public static final String NAME = "DeveloperOptions";

    public DeveloperOptionsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }


   /**
    * Check if the developer mode is enabled on the android device
    *
    * @param promise boolean
    */
    @ReactMethod
    public void isDeveloperModeEnabled(Promise promise) {
        final boolean settingEnabled = Settings.Global.getInt(
            getReactApplicationContext().getContentResolver(),
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
            Build.TYPE.equals("eng") ? 1 : 0
        ) != 0;

        promise.resolve(settingEnabled);
    }

  /**
   * Open the developer settings
   * @param promise void
   */
  @ReactMethod
    public void openDeveloperSettings(Promise promise) {
        Objects.requireNonNull(getCurrentActivity()).startActivity(
            new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
        );
        promise.resolve(null);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }
}
