package winds.com.ibike.ViewController.History;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import winds.com.ibike.R;
import winds.com.ibike.ViewController.Base.IBikeViewAdapter;

public class HistoryFragment extends Fragment {
    View root;
    ViewPager vpHistory;
    List<Fragment> data = new ArrayList<>();
    List<String> title = new ArrayList<>();
    winds.com.ibike.ViewController.Base.IBikeViewAdapter IBikeViewAdapter;
    TabLayout tabLayout;

    


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_with_viewpager, container, false);
        init();
        return root;
    }


    void init() {
        vpHistory = root.findViewById(R.id.vp_content);
        tabLayout = root.findViewById(R.id.tab);

        BillFragment billFragment = new BillFragment();
        AccessoryHistoryFragment accessoryHistoryFragment = new AccessoryHistoryFragment();

        data.add(billFragment);
        data.add(accessoryHistoryFragment);

        title.add("Hoa don");
        title.add("Phu tung");

        IBikeViewAdapter = new IBikeViewAdapter(getChildFragmentManager(), data, getActivity(),title);
        vpHistory.setAdapter(IBikeViewAdapter);
        tabLayout.setupWithViewPager(vpHistory);
    }
}
