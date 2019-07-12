package winds.com.ibike.ViewController.Base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class IBikeViewAdapter extends FragmentPagerAdapter {

    List<Fragment> data;
    Context context;
    List<String> title;


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    public IBikeViewAdapter(FragmentManager fm, List<Fragment> data, Context context,List<String> title) {
        super(fm);
        this.data = data;
        this.context = context;
        this.title = title;
    }

    public IBikeViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return data.get(i);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
