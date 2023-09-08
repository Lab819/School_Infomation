package gp.jessicali.sallytsze.schoolinfo;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

//Show a school's information in a page, not finished
public class InfoActivity extends AppCompatActivity {

    private Float longitude;
    private Float latitude;
    private HashMap<String, String> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);
        Bundle bundle = this.getIntent().getExtras(); // get clicked school's info

        if (bundle != null) {
            info = (HashMap<String, String>) bundle.getSerializable("info");
            Log.i("infoAct_HaspMap_info: ", info.toString());
        }

        TextView schoolNo = findViewById(R.id.schoolNo);
        TextView schoolName = findViewById(R.id.schoolName);
        TextView studentGender = findViewById(R.id.studentsGender);
        TextView session = findViewById(R.id.session);
        TextView district = findViewById(R.id.district);
        TextView financeType = findViewById(R.id.financeType);
        TextView schoolLevel = findViewById(R.id.schoolLevel);
        TextView telephone = findViewById(R.id.telephone);
        TextView faxNumber = findViewById(R.id.faxNumber);
        TextView website = findViewById(R.id.website);
        TextView religion = findViewById(R.id.religion);
        TextView address = findViewById(R.id.address);

        schoolNo.setText(info.get("A"));

        if ("".equals(info.get("Z")) || "".equals(info.get("AA")))
            telephone.setText("N.A.");
        else
            telephone.setText(info.get("Z"));

        if ("".equals(info.get("AB")) || "".equals(info.get("AC")))
            faxNumber.setText("N.A.");
        else
            faxNumber.setText(info.get("AB"));

        if ("".equals(info.get("AD")) || "".equals(info.get("AE")))
            website.setText("N.A.");
        else
            website.setText(info.get("AD"));

        if ("zh".equals(Locale.getDefault().getLanguage())) {
            schoolName.setText(info.get("E"));
            setTitle(info.get("E"));
            address.setText(info.get("G"));
            studentGender.setText(info.get("Q"));
            session.setText(info.get("S"));
            district.setText(info.get("U"));
            financeType.setText(info.get("W"));
            schoolLevel.setText(info.get("Y"));
            religion.setText(info.get("AG"));
        } else { // "en"
            schoolName.setText(info.get("D"));
            setTitle(info.get("D"));
            address.setText(info.get("F"));
            studentGender.setText(info.get("P"));
            session.setText(info.get("R"));
            district.setText(info.get("T"));
            financeType.setText(info.get("V"));
            schoolLevel.setText(info.get("X"));
            religion.setText(info.get("AF"));
        }

        longitude = Float.parseFloat(Objects.requireNonNull(info.get("H")));
        latitude = Float.parseFloat(Objects.requireNonNull(info.get("J")));

        Button showMap = findViewById(R.id.showMap);
        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mapURL = "http://maps.google.com/maps?q=" + latitude + "," + longitude + "&z=20";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapURL));
                startActivity(intent);
            }
        });

    }
}