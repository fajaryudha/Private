package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Smktelkom on 6/13/2017.
 */
public class FavouriteItem extends SugarRecord implements Serializable
{
    public String judul;

    public FavouriteItem()
    {
    }

    public FavouriteItem(String judul)
    {
        this.judul = judul;
    }

    @Override
    public String toString() {
        return judul ;
    }
}
