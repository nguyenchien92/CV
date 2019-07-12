package winds.com.ibike.ViewController.Accessory;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import winds.com.ibike.R;
import winds.com.ibike.ViewController.Base.MaterialData;
import winds.com.ibike.ViewController.Network.ApiService;
import winds.com.ibike.ViewController.Network.RetrofitClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuallyAccessoryFragment extends Fragment {
    private List<BikeInfo> bikeInfos;
    private MaterialAdapter adapter;
    private RecyclerView rvItem;
    private MaterialData info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_with_list_view, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        info = new MaterialData("231654613", "", "1");
        bikeInfos = new ArrayList<>();
        adapter = new MaterialAdapter(getActivity(),bikeInfos,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvItem = view.findViewById(R.id.rv_item);
        prepareData();
        configUI();
    }

    private void configUI() {
        rvItem.setAdapter(adapter);
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private void prepareData() {
        Retrofit retrofit = RetrofitClient.getRetrofit();
        Call<MaterialResponse> call = retrofit.create(ApiService.class)
                .requestMaterial(info);
        call.enqueue(new Callback<MaterialResponse>() {
            @Override
            public void onResponse(Call<MaterialResponse> call, Response<MaterialResponse> response) {
                bikeInfos.addAll(response.body().getResult());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MaterialResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Fails", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
