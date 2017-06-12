package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model.Favorite;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model.Results;
import io.realm.Realm;

public class ScrollingActivity extends AppCompatActivity {

    public String url = "https://image.tmdb.org/t/p/w500";
    String Id,img,des,gambar,reales;
    Results results;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        reales = intent.getStringExtra("date");
        Id = intent.getStringExtra("movie_title");
        img = intent.getStringExtra("poster_path");
        des = intent.getStringExtra("description");
        setTitle(Id);
        gambar = url+img;
        ImageView detail = (ImageView) findViewById(R.id.imageViewDetail);
        TextView descipsi = (TextView) findViewById(R.id.textDesc);
        final String title = Id;
        TextView judul = (TextView) findViewById(R.id.Judul);
        TextView release = (TextView) findViewById(R.id.textDate);
        Glide.with(this).load(gambar)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(detail);
        judul.setText(Id);
        release.setText(reales);
        descipsi.setText(des);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Favorite favorite = new Favorite(Id);
                favorite.save();
                Snackbar.make(view, "Berhasil Ditambah Ke Favorite",Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
