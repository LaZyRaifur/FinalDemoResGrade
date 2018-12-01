package com.example.raifur.foodgradingsystem.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    //Shared pref mode
    int PRIVATE_MODE = 0;

    //Shared preference file name
    private static final String PRF_NAME = "QuickAID-welcome";
    private static final String IS_FINAL_TIME_LAUNCH ="IsFirstTimeLaunch";

    public PreferencManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PRF_NAME,PRIVATE_MODE);
        editor=pref.edit();
    }


    public void setFirstTimeLaunch(boolean isFirstTime){
        editor.putBoolean(IS_FINAL_TIME_LAUNCH,isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch(){
        return pref.getBoolean(IS_FINAL_TIME_LAUNCH,true);
    }
}
