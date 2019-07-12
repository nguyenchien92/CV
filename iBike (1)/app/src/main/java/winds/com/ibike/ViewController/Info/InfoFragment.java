package winds.com.ibike.ViewController.Info;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import winds.com.ibike.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    View root;
    WebView wvInfo;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_info, container, false);
        init();
        return root;
    }

    void init(){
        wvInfo = root.findViewById(R.id.wv_info);
        wvInfo.loadUrl("file:///android_res/raw/about.html");
    }

}
