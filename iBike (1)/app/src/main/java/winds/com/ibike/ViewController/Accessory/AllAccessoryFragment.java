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
public class AllAccessoryFragment extends Fragment {

    private MaterialAdapter adapter;
    private List<BikeInfo> bikeInfoList;
    private RecyclerView rvItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_list_view, container, false);


        return view;
    }


    // This event fires 2nd, before views are created for the fragment
    // The onCreate method is called when the Fragment instance is being created, or re-created.
    // Use onCreate for any standard setup that does not require the activity to be fully created
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bikeInfoList = new ArrayList<>();
        adapter = new MaterialAdapter(getActivity(), bikeInfoList, true);
    }

    // This event is triggered soon after onCreateView().
    // onViewCreated() is only called if the view returned from onCreateView() is non-null.
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
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


    // This method is called after the parent Activity's onCreate() method has completed.
    // Accessing the view hierarchy of the parent activity must be done in the onActivityCreated.
    // At this point, it is safe to search for activity View objects by their ID, for example.
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void prepareData() {
        MaterialData materialData = new MaterialData("231654613", "", "1");

        Retrofit retrofit = RetrofitClient.getRetrofit();
        Call<MaterialResponse> call = retrofit.create(ApiService.class)
                .requestMaterial(materialData);

        call.enqueue(new Callback<MaterialResponse>() {
            @Override
            public void onResponse(Call<MaterialResponse> call, Response<MaterialResponse> response) {
                bikeInfoList.addAll(response.body().getResult());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MaterialResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Fails", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
