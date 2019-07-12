package winds.com.ibike.ViewController.Network;




import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import winds.com.ibike.LoginActivity;
import winds.com.ibike.ViewController.Accessory.AllAccessoryFragment;
import winds.com.ibike.ViewController.Accessory.MaterialResponse;
import winds.com.ibike.ViewController.Base.MaterialData;
import winds.com.ibike.ViewController.Model.LoginResponse;

public interface ApiService {

    @POST("Service/Login")
    @Headers("Content-Type:application/json")
    Call<LoginResponse> requestLogin(@Body LoginActivity.MobileInfo info);

    @POST("Service/GetPriceListMaterial")
    @Headers("Content-Type:application/json")
    Call<MaterialResponse> requestMaterial(@Body MaterialData detailData);
}
