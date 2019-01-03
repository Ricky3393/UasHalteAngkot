package io.github.uas.uasmopro;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.uas.uasmopro.adapter.PertandinganAdapter;
import io.github.uas.uasmopro.model.Angkot;
import io.github.uas.uasmopro.model.AngkotResponse;
import io.github.uas.uasmopro.service.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListPertandinganFragment extends Fragment {

    View v;
    ArrayList<Angkot> listPertandingan;
    RecyclerView mRecyclerView;
    PertandinganAdapter mAdapter;
    ProgressDialog loading;
    private RecyclerView rvPertandingan;

    public ListPertandinganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list_angkot, container, false);
        rvPertandingan = v.findViewById(R.id.rv_pertandingan);
        listPertandingan = new ArrayList<>();

        loading = ProgressDialog.show(getActivity(), null, "Harap Tunggu...", true, false);

        Call<AngkotResponse> call = UtilsApi.getAPIService().getAllPertandingan();
        call.enqueue(new Callback<AngkotResponse>() {
            @Override
            public void onResponse(Call<AngkotResponse> call, Response<AngkotResponse> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    listPertandingan = (ArrayList<Angkot>) response.body().getData();

                    rvPertandingan.setAdapter(new PertandinganAdapter(getActivity(), listPertandingan));
                    mAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getActivity(), "not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AngkotResponse> call, Throwable t) {
                loading.dismiss();

                Toast.makeText(getActivity(), "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView = v.findViewById(R.id.rv_pertandingan);
        mAdapter = new PertandinganAdapter(getActivity(), listPertandingan);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

}
