package krunal.com.example.usersessionmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SessionManagement {

    private SharedPreferences mSharedPreferences;
    private Context mContext;

    SessionManagement(Context context){
        this.mContext = context;
        this.mSharedPreferences = context.getSharedPreferences(context.getResources()
                .getString(R.string.Login_preference),Context.MODE_PRIVATE);
    }

    public void EditLogin(boolean status){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(mContext.getResources().getString(R.string.Login_status_key),status);
        editor.apply();
    }

    public boolean isLoginCheck(){
        Log.i("login","isLoginCheck call");
        boolean status = false;
        status = mSharedPreferences.getBoolean(mContext.getResources()
                        .getString(R.string.Login_status_key),false);
        Log.i("login",String.valueOf(status));
        return status;
    }

}
