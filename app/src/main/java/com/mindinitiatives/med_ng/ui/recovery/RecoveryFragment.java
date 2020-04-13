package com.mindinitiatives.med_ng.ui.recovery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mindinitiatives.med_ng.R;

public class RecoveryFragment extends Fragment {

    private RecoveryViewModel recoveryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recoveryViewModel =
                ViewModelProviders.of(this).get(RecoveryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recovery, container, false);
        final TextView textView = root.findViewById(R.id.recovery);
        recoveryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
