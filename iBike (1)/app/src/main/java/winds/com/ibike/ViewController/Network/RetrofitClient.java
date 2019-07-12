package winds.com.ibike.ViewController.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit globalRetrofit;

    public static Retrofit getRetrofit()
    {
        if(globalRetrofit == null){
            return new Retrofit.Builder()
                    .baseUrl("http://winds.hopto.org:8789/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return globalRetrofit;
    }
}
