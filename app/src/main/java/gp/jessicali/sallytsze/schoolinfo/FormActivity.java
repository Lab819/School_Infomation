package gp.jessicali.sallytsze.schoolinfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//A form page for searching schools with condition, finished
public class FormActivity extends AppCompatActivity {

    private TextView schoolNameKeyword;
    private Spinner district_spinner;
    private Spinner schoolLevel_spinner;
    private Spinner financeType_spinner;
    private Spinner studentGender_spinner;
    private Spinner religion_spinner;
    private Spinner session_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_form);

        schoolNameKeyword = findViewById(R.id.editText_schoolName);

        district_spinner =  findViewById(R.id.spinner_district);
        ArrayAdapter<CharSequence> district_adapter = ArrayAdapter.createFromResource(this,
                R.array.district_array, android.R.layout.simple_spinner_item);
        district_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district_spinner.setAdapter(district_adapter);

        schoolLevel_spinner = findViewById(R.id.spinner_schoolLevel);
        ArrayAdapter<CharSequence> schoolLevel_adapter = ArrayAdapter.createFromResource(this,
                R.array.schoolLevel_array, android.R.layout.simple_spinner_item);
        schoolLevel_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolLevel_spinner.setAdapter(schoolLevel_adapter);

        financeType_spinner = findViewById(R.id.spinner_fianceType);
        ArrayAdapter<CharSequence> financeType_adapter = ArrayAdapter.createFromResource(this,
                R.array.financeType_array, android.R.layout.simple_spinner_item);
        financeType_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        financeType_spinner.setAdapter(financeType_adapter);

        studentGender_spinner = findViewById(R.id.spinner_studentsGender);
        ArrayAdapter<CharSequence> studentGender_adapter = ArrayAdapter.createFromResource(this,
                R.array.studentGender_array, android.R.layout.simple_spinner_item);
        studentGender_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studentGender_spinner.setAdapter(studentGender_adapter);

        religion_spinner = findViewById(R.id.spinner_religion);
        ArrayAdapter<CharSequence> religion_adapter = ArrayAdapter.createFromResource(this,
                R.array.religion_array, android.R.layout.simple_spinner_item);
        religion_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        religion_spinner.setAdapter(religion_adapter);

        session_spinner = findViewById(R.id.spinner_session);
        ArrayAdapter<CharSequence> session_adapter = ArrayAdapter.createFromResource(this,
                R.array.session_array, android.R.layout.simple_spinner_item);
        session_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        session_spinner.setAdapter(session_adapter);

        Button submit_btn = findViewById(R.id.btn_submit);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle formBundle = new Bundle();

                if ("".equals(schoolNameKeyword.getText().toString()))
                    formBundle.putString("schoolName", "--");
                else
                    formBundle.putString("schoolName", schoolNameKeyword.getText().toString().trim().toUpperCase());
                formBundle.putString("district", district_spinner.getSelectedItem().toString());
                formBundle.putString("schoolLevel", schoolLevel_spinner.getSelectedItem().toString());
                formBundle.putString("financeType", financeType_spinner.getSelectedItem().toString());
                formBundle.putString("studentGender", studentGender_spinner.getSelectedItem().toString());
                formBundle.putString("session", session_spinner.getSelectedItem().toString());
                formBundle.putString("religion", religion_spinner.getSelectedItem().toString());

                Log.i("formBundle: ", formBundle.toString());
                Intent intent = new Intent(FormActivity.this, SearchActivity.class);
                intent.putExtras(formBundle);
                startActivity(intent);
            }
        });
    }
}