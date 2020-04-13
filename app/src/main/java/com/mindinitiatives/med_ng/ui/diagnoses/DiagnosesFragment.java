package com.mindinitiatives.med_ng.ui.diagnoses;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mindinitiatives.med_ng.R;
import com.mindinitiatives.med_ng.adapter.DiagnosesAdapter;
import com.mindinitiatives.med_ng.data.model.States;
import com.mindinitiatives.med_ng.data.model.TotalCases;
import com.mindinitiatives.med_ng.remote.ApiClient;
import com.mindinitiatives.med_ng.remote.ApiInterface;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DiagnosesFragment extends Fragment {

    private static final String TAG = "Get";
    List<States> states;
    List<TotalCases> confirmed;
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DiagnosesAdapter adapter;
    TextView number, cases;

    private com.mindinitiatives.med_ng.ui.diagnoses.DiagnosesViewModel mViewModel;

    public static DiagnosesFragment newInstance() {
        return new DiagnosesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_diagnoses, container, false);


    }

    private void fetchDiagnoses() {


        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<States>> call = apiInterface.getStates("states");
        Call<List<TotalCases>> cases = apiInterface.getTotal();
        call.enqueue(new Callback<List<States>>() {
            @Override
            public void onResponse(Call<List<States>> call, Response<List<States>> response) {
                Log.i(TAG, "Got Request from API." + response.body());
                states = response.body();
                adapter = new DiagnosesAdapter(states, DiagnosesFragment.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<States>> call, Throwable t) {

            }
        });

        cases.enqueue(new Callback<List<TotalCases>>() {
            @Override
            public void onResponse(Call<List<TotalCases>> call, Response<List<TotalCases>> response) {
                Log.i(TAG, "Got Cases from API." + response.body());
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        List<String> n = Arrays.asList(response.body().get(1).getValues());
                        String first = n.get(0);
                        number.setText(first);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TotalCases>> call, Throwable t) {
                t.getMessage();
            }
        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(com.mindinitiatives.med_ng.ui.diagnoses.DiagnosesViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        number = view.findViewById(R.id.total_number);
        cases = view.findViewById(R.id.total_cases);
        recyclerView = view.findViewById(R.id.states_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchDiagnoses();

    }
}
