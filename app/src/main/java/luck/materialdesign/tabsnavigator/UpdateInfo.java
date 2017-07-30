package luck.materialdesign.tabsnavigator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import luck.materialdesign.tabsnavigator.Model.Donar_list_model;

public class UpdateInfo extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDB;
    EditText name_ET, number_ET, address_ET;
    Spinner spinner_blood_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        name_ET = (EditText) findViewById(R.id.name_ET);
        number_ET = (EditText) findViewById(R.id.number_ET);
        address_ET = (EditText) findViewById(R.id.address_ET);

        mFirebaseDB = FirebaseDatabase.getInstance();

        spinner_blood_group = (Spinner) findViewById(R.id.spinner_blood_group);

        //String Blood_group = spinner_blood_group.getSelectedItem().toString();

}

    public void Update(View view) {


        String donarName = name_ET.getText().toString();
        String donarNumber = number_ET.getText().toString();
        String donarAddress = address_ET.getText().toString();
        String Blood_group = spinner_blood_group.getSelectedItem().toString();

        DatabaseReference databaseReference = mFirebaseDB.getReference();

        Donar_list_model donarListModel = new Donar_list_model(donarName,donarNumber,donarAddress,Blood_group);

        databaseReference.child("DonarInfo").push().setValue(donarListModel);
        Intent home = new Intent(UpdateInfo.this, MainActivity.class);
        startActivity(home);
    }
}
