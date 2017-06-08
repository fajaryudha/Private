package id.sch.smktelkom_mlg.privateassignment.xirpl311.moccatv.App;

import android.app.Application;
import io.realm.Realm;
/**
 * Created by Smktelkom on 5/14/2017.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }

}
