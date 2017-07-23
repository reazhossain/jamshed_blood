package luck.materialdesign.tabsnavigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class UpdateInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        Spinner spinner = (Spinner) findViewById(R.id.blood_group);
        String size = spinner.getSelectedItem().toString();

        int spinner_pos = spinner.getSelectedItemPosition();
        String[] blood_group_entries = getResources().getStringArray(R.array.blood_group_entries);
    }
}
