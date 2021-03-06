package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Adapter.TopmovieAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model.ResultsResponse;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.service.VolleySingleton;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.service.VolleySingleton1;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {

    ArrayList<Results> mlist = new ArrayList<>();
    View inflate;
    RecyclerView recyclerView;
    TopmovieAdapter topmovieAdapter;

    public NowPlayingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_now_playing, container, false);
        inflate = inflater.inflate(R.layout.page2_fragment, container,false);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        topmovieAdapter = new TopmovieAdapter(this,mlist,getContext());
        recyclerView.setAdapter(topmovieAdapter);

        LinearLayoutManager grid = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(grid);

        downloadDataSources();
        return inflate;
    }

    private void downloadDataSources() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=c72575a25c2e38d54bb76e3edc5fce09&language=en-US&page=1";
        //String url = "https://newsapi.org/v1/sources?language=en";

        GsonGetRequest<ResultsResponse> myRequest = new GsonGetRequest<ResultsResponse>
                (url, ResultsResponse.class, null, new Response.Listener<ResultsResponse>()
                {

                    @Override
                    public void onResponse(ResultsResponse resultsResponse)
                    {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(resultsResponse)));
                        //if (response.status.equals("ok"))
                        //{
                        //    fillColor(response.sources);
                        mlist.addAll(resultsResponse.results);
                        topmovieAdapter.notifyDataSetChanged();
                        //}
                    }

                } , new Response.ErrorListener()
                {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton1.getInstance(this).addToRequestQueue1(myRequest);
    }

}
