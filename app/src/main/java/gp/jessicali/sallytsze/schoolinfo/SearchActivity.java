package gp.jessicali.sallytsze.schoolinfo;

import static gp.jessicali.sallytsze.schoolinfo.Filter.filterList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Locale;

//Brief information of matched schools, matching function not finished
public class SearchActivity extends AppCompatActivity {

    public static String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_list);
        ListView listView = findViewById(R.id.listview);
        language = Locale.getDefault().getLanguage(); //english = en , chinese = zh
        Log.i("language:", language);

        Bundle bundle = getIntent().getExtras();
        String schoolName = bundle.getString("schoolName");
        String district = bundle.getString("district");
        String schoolLevel = bundle.getString("schoolLevel");
        String financeType = bundle.getString("financeType");
        String studentGender = bundle.getString("studentGender");
        String religion = bundle.getString("religion");
        String session = bundle.getString("session");
        Log.i("Bundle:", String.valueOf(bundle));

        JsonHandlerThread jsonHandlerThread = new JsonHandlerThread();
        jsonHandlerThread.start();

        try {
            jsonHandlerThread.join();

            //after retrieved the json contents and stored into the "contactList", i.e. contactList is ready for display
            //1. setup ListView component to display the contact list
            //2. implement the item click event handling

            //1. Create an adapter that accommodates a data list of items to views that becomes children of an adapter view
            //i.e. the Adapter object acts as a bridge between an ListViews and the contacts for that view

            for (int i = 0; i < SchoolInfo.infoList.size(); i++) {
                if (i == 0) {
                    filterList.clear();
                    Log.i("doFilter clean list", String.valueOf(filterList.size()));
                }

                if (!filterList.contains(SchoolInfo.getInfoList(i)))
                    if (Filter.doFilter(i, schoolName, district, schoolLevel, financeType
                            , studentGender, religion, session)) {
                        filterList.add(SchoolInfo.infoList.get(i));
                    }
            }

            Log.i("filterList.size", String.valueOf(filterList.size()));
            setTitle(filterList.size() + " " + getString(R.string.result));

            SimpleAdapter adapter = new SimpleAdapter(
                    this,
                    filterList, //"contactList" that stores all the retrieved contacts, defined in ContactInfo
                    R.layout.search_result_layout, //layout resource represent item layout design
                    ("zh".equals(language)) ?
                            new String[]{SchoolInfo.CHNAME, SchoolInfo.CHFINANCETYPE, SchoolInfo.CHSCHOOLLEVEL, SchoolInfo.CHADDRESS} :
                            new String[]{SchoolInfo.NAME, SchoolInfo.FINANCETYPE, SchoolInfo.SCHOOLLEVEL, SchoolInfo.ADDRESS}
                    , //represent the three data that display in an item
                    new int[]{R.id.schoolName, R.id.financeType, R.id.schoolLevel, R.id.address} //represent where the item is displayed
            );

            //Associate the adapter with the ListView
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(
                    //should implement intent class for turning to InfoActivity
                    new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            HashMap<String, String> info = filterList.get(position);
                            Log.i("info:", info.toString());
                            Intent intent = new Intent(SearchActivity.this, InfoActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("info", info);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    }
            );

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}