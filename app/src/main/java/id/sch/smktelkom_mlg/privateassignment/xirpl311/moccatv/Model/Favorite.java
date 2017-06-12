package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.Model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Smktelkom on 6/12/2017.
 */

public class Favorite extends SugarRecord implements Serializable {
    public String id1;

    public Favorite(String id1) {
        this.id1 = id1;
    }
}
