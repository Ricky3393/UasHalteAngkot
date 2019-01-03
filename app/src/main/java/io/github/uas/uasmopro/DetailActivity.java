package io.github.uas.uasmopro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.jln_dit)
    TextView tvJalan;

    @BindView(R.id.lok_dit)
    TextView tvLokasi;

    @BindView(R.id.ket_dit)
    TextView tvKeterangan;


    private String strLokasi, strKeterangan, strJalan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        getIntentData();

        tvJalan.setText(strJalan);
        tvLokasi.setText(strLokasi);
        tvKeterangan.setText(strKeterangan);
    }

    private void getIntentData(){
        strJalan = getIntent().getStringExtra("jalan");
        strLokasi = getIntent().getStringExtra("lokasi");
        strKeterangan = getIntent().getStringExtra("keterangan");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
