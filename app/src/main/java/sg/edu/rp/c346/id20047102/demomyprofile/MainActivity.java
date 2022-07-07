package sg.edu.rp.c346.id20047102.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.rgGender);
        btnSave = findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = etName.getText().toString();
                float gpa = Float.parseFloat(etGPA.getText().toString());
                int intGender = rgGender.getCheckedRadioButtonId();
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putString("name", strName);
                prefEdit.putFloat("gpa", gpa);
                prefEdit.putInt("gender", intGender);
                prefEdit.commit();
            }
        });
    }

    //To save without pressing the Save button
//    @Override
//    protected void onPause() {
//        super.onPause();
//        String strName = etName.getText().toString();
//        float gpa = Float.parseFloat(etGPA.getText().toString());
//        int intGender = rgGender.getCheckedRadioButtonId();
//        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor prefEdit = prefs.edit();
//        prefEdit.putString("name", strName);
//        prefEdit.putFloat("gpa", gpa);
//        prefEdit.putInt("gender", intGender);
//        prefEdit.commit();
//    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name", "John");
        float gpa = prefs.getFloat("gpa", 0);
        int intGender = prefs.getInt("gender", 0);
        etName.setText(strName);
        etGPA.setText(gpa + "");
        rgGender.check(intGender);
    }
}