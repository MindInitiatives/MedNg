package com.mindinitiatives.med_ng.ui.condition;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mindinitiatives.med_ng.R;

import java.util.ArrayList;

public class ConditionFragment extends Fragment {

    private ConditionViewModel mViewModel;

    public static ConditionFragment newInstance() {
        return new ConditionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_condition, container, false);


        PieChart mChart = view.findViewById(R.id.piechart);
        ArrayList<PieEntry> NoOfCases = new ArrayList<PieEntry>();

        NoOfCases.add(new PieEntry(945f, "Recovered"));
        NoOfCases.add(new PieEntry(1040f, "Deaths"));
        NoOfCases.add(new PieEntry(1133f, "Infected"));

        PieDataSet dataSet = new PieDataSet(NoOfCases, "Number Of Cases");

        Description description = new Description();
        description.setText("Number Of Cases");
        PieData data = new PieData(dataSet);
        mChart.setData(data);
        mChart.setDescription(description);
        dataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        mChart.animateXY(2000, 2000);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ConditionViewModel.class);
        // TODO: Use the ViewModel
    }

}
