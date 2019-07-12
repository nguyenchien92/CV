package winds.com.ibike;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import winds.com.ibike.ViewController.Model.LoginResponse;
import winds.com.ibike.ViewController.Model.UserInfo;
import winds.com.ibike.ViewController.Network.ApiService;
import winds.com.ibike.ViewController.Network.RetrofitClient;
import winds.com.ibike.ViewController.Utils.AppConfig;

public class LoginActivity extends AppCompatActivity {

    private EditText edPhoneNumber;
    private Button btLogin;
    private MobileInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        edPhoneNumber = findViewById(R.id.ed_phone_number);
        btLogin = findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {

        info = new MobileInfo(edPhoneNumber.getText().toString(), "asdiasdijaokjdak", "android");

        Retrofit retrofit = RetrofitClient.getRetrofit();
        Call<LoginResponse> call = retrofit.create(ApiService.class)
                .requestLogin(info);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body().getStatus() == 1) {

                    String bikeId = response.body().getUserInfo().getListBike().get(0);
                    String customerName = response.body().getUserInfo().getCustomerName();

                    SharedPreferences.Editor editor = AppConfig.getEditor(LoginActivity.this
                            ,"iBike",MODE_PRIVATE);
                    editor.putString("bikeId",bikeId);
                    editor.putString("customerName",customerName);
                    editor.apply();


                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                    AppConfig.setIsLogin(LoginActivity.this, true, MODE_PRIVATE);
                }else {
                    Toast.makeText(LoginActivity.this, "Error phone number", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Fails", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class MobileInfo {

        private String phoneNumber;

        private String deviceID;

        private String os;

        public MobileInfo(String phoneNumber, String deviceID, String os) {
            this.phoneNumber = phoneNumber;
            this.deviceID = deviceID;
            this.os = os;
        }
    }
}
