package winds.com.ibike.ViewController.Accessory;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class AccessoryFragment extends Fragment {

    View root;
    ViewPager vpAccessory;
    List<Fragment> data = new ArrayList<>();
    List<String> title = new ArrayList<>();
    IBikeViewAdapter IBikeViewAdapter;
    TabLayout tabLayout;

    public AccessoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_with_viewpager, container, false);
        init();
        return root;
    }


    void init() {
        vpAccessory = root.findViewById(R.id.vp_content);
        tabLayout = root.findViewById(R.id.tab);

        AllAccessoryFragment allAccessoryFragment = new AllAccessoryFragment();
        UsuallyAccessoryFragment usuallyAccessoryFragment = new UsuallyAccessoryFragment();

        data.add(allAccessoryFragment);
        data.add(usuallyAccessoryFragment);

        title.add("Tat ca");
        title.add("Thuong xuyen");

        IBikeViewAdapter = new IBikeViewAdapter(getChildFragmentManager(), data, getActivity(),title);
        vpAccessory.setAdapter(IBikeViewAdapter);
        tabLayout.setupWithViewPager(vpAccessory);
    }

}
