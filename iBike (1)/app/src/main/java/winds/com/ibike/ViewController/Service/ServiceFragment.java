package winds.com.ibike.ViewController.Service;

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

public class ServiceFragment extends Fragment {
    View root;
    ViewPager vpService;
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
        vpService = root.findViewById(R.id.vp_content);
        tabLayout = root.findViewById(R.id.tab);

        RepairingFragment repairingFragment = new RepairingFragment();
        SuggestFragment suggestFragment = new SuggestFragment();
        WarningFragment warningFragment = new WarningFragment();

        data.add(repairingFragment);
        data.add(suggestFragment);
        data.add(warningFragment);

        title.add("Dang sua");
        title.add("Canh bao");
        title.add("De xuat");

        IBikeViewAdapter = new IBikeViewAdapter(getChildFragmentManager(), data, getActivity(),title);
        vpService.setAdapter(IBikeViewAdapter);
        tabLayout.setupWithViewPager(vpService);
    }

}
