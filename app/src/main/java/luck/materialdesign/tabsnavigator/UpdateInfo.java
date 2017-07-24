package luck.materialdesign.tabsnavigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import luck.materialdesign.tabsnavigator.Model.Donar_list_model;

public class UpdateInfo extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDB;
    EditText name_ET, number_ET, address_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        name_ET = (EditText) findViewById(R.id.name_ET);
        number_ET = (EditText) findViewById(R.id.number_ET);
        address_ET = (EditText) findViewById(R.id.address_ET);

        mFirebaseDB = FirebaseDatabase.getInstance();


        //spinner matter,

        /*Spinner spinner = (Spinner) findViewById(R.id.blood_group);
        String size = spinner.getSelectedItem().toString();

        int spinner_pos = spinner.getSelectedItemPosition();
        String[] blood_group_entries = getResources().getStringArray(R.array.blood_group_entries);*/
    }

    public void Update(View view) {
        DatabaseReference databaseReference = mFirebaseDB.getReference();

        String donarName = name_ET.getText().toString();
        String donarNumber = number_ET.getText().toString();
        String donarAddress = address_ET.getText().toString();

        Donar_list_model donarListModel = new Donar_list_model(donarName, donarNumber, donarAddress);
        databaseReference.child("DonarInfo").setValue(donarListModel);
    }
}
