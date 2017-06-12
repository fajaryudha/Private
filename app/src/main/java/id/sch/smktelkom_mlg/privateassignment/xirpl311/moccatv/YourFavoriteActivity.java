package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model.Favorite;

public class YourFavoriteActivity extends AppCompatActivity {

    public TextView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_favorite);
        listView = (TextView) findViewById(R.id.Favorite);
        List<Favorite> favorite = Favorite.listAll(Favorite.class);
        listView.setText(favorite.toString());
    }
}
