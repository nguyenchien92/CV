package winds.com.ibike.ViewController.History;


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
public class AccessoryHistoryFragment extends Fragment {

    private List<Product> products;
    private ItemAdapter adapter;
    private RecyclerView rvItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products = new ArrayList<>();
        init();
        adapter = new ItemAdapter(getActivity(),products);
    }

    private void init() {
        Product product = new Product("aaa", "bbb", "ccc");
        products.add(product);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_with_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvItem = view.findViewById(R.id.rv_item);
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvItem.setAdapter(adapter);
    }
}
