package winds.com.ibike.ViewController.History;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import winds.com.ibike.R;
import winds.com.ibike.ViewController.Base.ItemAdapter;
import winds.com.ibike.ViewController.Model.Product;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillFragment extends Fragment {
    private List<Product> productList;
    private ItemAdapter adapter;
    private RecyclerView rvItem;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareData();
        adapter = new ItemAdapter(getActivity(), productList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_with_list_view, container, false);
        rvItem = view.findViewById(R.id.rv_item);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvItem.setLayoutManager(manager);
        rvItem.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void prepareData() {
        productList = new ArrayList<>();
        Product product = new Product("aaa", "bbb", "ccc");
        productList.add(product);
    }
}
