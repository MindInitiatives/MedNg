package com.mindinitiatives.med_ng.ui.epidemic;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.mindinitiatives.med_ng.R;

public class EpidemicFragment extends Fragment {

    WebView myBrowser;

    private EpidemicViewModel mViewModel;


    public static EpidemicFragment newInstance() {
        return new EpidemicFragment();
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_epidemic, container, false);
        myBrowser = view.findViewById(R.id.mybrowser);
        myBrowser.getSettings().setJavaScriptEnabled(true);
        myBrowser.loadUrl("file:///android_asset/worldmap/test.html");

        return view;
    }





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EpidemicViewModel.class);
        // TODO: Use the ViewModel
        // add pie chart to main layout


    }

}
