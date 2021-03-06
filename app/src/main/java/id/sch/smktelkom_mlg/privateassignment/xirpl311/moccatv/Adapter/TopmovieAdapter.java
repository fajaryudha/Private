package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.NowPlayingFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Page2Fragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.ScrollingActivity;

import static android.R.id.list;

/**
 * Created by Smktelkom on 5/10/2017.
 */

public class TopmovieAdapter extends RecyclerView.Adapter<TopmovieAdapter.ViewHolder> {
    ArrayList<Results> mlist;
    Page2Fragment page2fragment;
    NowPlayingFragment nowPlayingFragment;
    Context context;
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    //private int lastposition = -1;


    public TopmovieAdapter(Page2Fragment page2Fragment, ArrayList<Results> mlist,Context context) {
        this.mlist = mlist;
        this.page2fragment = page2Fragment;
        this.context = context;
    }

    public TopmovieAdapter(NowPlayingFragment nowPlayingFragment, ArrayList<Results> mlist, Context context) {
        this.mlist = mlist;
        this.nowPlayingFragment = nowPlayingFragment;
        this.context = context;
    }

    @Override
    public TopmovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.source_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TopmovieAdapter.ViewHolder holder, int position) {

        final Results results = mlist.get(position);
        holder.tvName.setText(results.title);
        holder.tvDesc.setText(results.overview);
        image = url+results.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
        //setAnimation(holder.itemView,position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=results.id;
                Intent intent = new Intent(context, ScrollingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("date",results.release_date);
                intent.putExtra("movie_title",results.title);
                intent.putExtra("poster_path",results.backdrop_path);
                intent.putExtra("description",results.overview);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mlist != null)
            return mlist.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvDesc;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);
            cardView = (CardView) itemView.findViewById(R.id.CardView);
            //itemView.setOnClickListener(new View.OnClickListener()
            //{
            //    @Override
            //    public void onClick(View v)
            //    {
            //        Results source = list.get(getAdapterPosition());
            //        List<String> sort = source.sortBysAvailable;
            //        mISourceAdapter.showArticles(source.id, source.name, sort.get(sort.size() - 1));
            //    }
            //});
            //cardView.setOnClickListener(new View.OnClickListener() {
            //    @Override
            //    public void onClick(View view) {

            //    }
            //});
        }
    }
}
