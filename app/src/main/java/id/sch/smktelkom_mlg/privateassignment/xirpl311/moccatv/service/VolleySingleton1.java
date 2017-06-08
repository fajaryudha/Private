package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.service;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.NowPlayingFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Page2Fragment;

/**
 * Created by hyuam on 18/04/2017.
 */

public class VolleySingleton1
{
    private static volatile VolleySingleton1 mInstance;
    private static NowPlayingFragment mCtx1;
    private RequestQueue mRequestQueue;

    //private VolleySingleton(Context context)
    //{
    //    if (mInstance != null)
    //    {
    //        throw new RuntimeException(
    //                "Use getInstance() method to get the single instance of this class");
    //    }
    //    mCtx = context;
    //    mRequestQueue = getRequestQueue();
    //}

    public VolleySingleton1(NowPlayingFragment context) {
        if (mInstance != null)
        {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx1 = context;
        mRequestQueue = getRequestQueue();
    }
    
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(mCtx1.getActivity());
        }
        return mRequestQueue;
    }
    
    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }


    public static VolleySingleton1 getInstance(NowPlayingFragment nowPlayingFragment) {

        if (mInstance == null)
        {
            synchronized (VolleySingleton1.class)
            {
                if (mInstance == null) mInstance = new VolleySingleton1(nowPlayingFragment);
            }
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue1() {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(mCtx1.getActivity());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue1(Request<T> req)
    {
        getRequestQueue1().add(req);
    }

}
