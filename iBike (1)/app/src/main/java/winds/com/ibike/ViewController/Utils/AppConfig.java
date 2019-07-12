package winds.com.ibike.ViewController.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import static android.content.Context.MODE_PRIVATE;

public class AppConfig {
    public static boolean isLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("iBike", MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean("isLogged", false);
        return isLogin;
    }

    public static void setIsLogin(Context context, boolean isLogin,int mode) {
        SharedPreferences.Editor editor = getEditor(context,"iBike",mode);
        editor.putBoolean("isLogged", isLogin);
        editor.apply();
    }

    public static SharedPreferences.Editor getEditor(Context context, String nameFile, int mode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(nameFile,mode);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        return editor;
    }

    public static String getValue(Context context,String fileName,String key,int mode){
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, mode);
        String value = sharedPreferences.getString(key, null);

        return value;
    }
}
