package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.orm.SugarRecord;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model.FavouriteItem;

public class YourFavoriteActivity extends AppCompatActivity {

    private ListView listView;
    public TextView textView;
    private ArrayAdapter<FavouriteItem> mAdapter;
    private String title,no;
    FavouriteItem favouriteItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_favorite);
        Intent intent = getIntent();
        setTitle("Your Favorite");
        title = intent.getStringExtra("title");
        textView = (TextView) findViewById(R.id.tvFavorite);
        FavouriteItem book = FavouriteItem.findById(FavouriteItem.class, (long) 1);
        //textView.setText(book.toString());
        String owner = textView.getText().toString();
        listView = (ListView) findViewById(R.id.Favorite);
        String judul = "KOtak";
        List<FavouriteItem> favorite = FavouriteItem.listAll(FavouriteItem.class);
        mAdapter = new ArrayAdapter<FavouriteItem>(YourFavoriteActivity.this,android.R.layout.simple_list_item_1,favorite);
        mAdapter.notifyDataSetChanged();
        listView.setAdapter(mAdapter);
    }
}
