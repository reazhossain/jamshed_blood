package luck.materialdesign.tabsnavigator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FabActivity extends AppCompatActivity {

    EditText post_ET,hospital_name_ET,number_ET;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);

        post_ET = (EditText) findViewById(R.id.post_ET);
        hospital_name_ET = (EditText) findViewById(R.id.hospital_name_ET);
        number_ET = (EditText) findViewById(R.id.number_ET);

        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void Status_Post(View view) {

        String post = post_ET.getText().toString();
        String Hospital_name = hospital_name_ET.getText().toString();
        String number = number_ET.getText().toString();

        DatabaseReference databaseReference = firebaseDatabase.getReference();

        News_feed_post_Model newsFeedPostModel = new News_feed_post_Model(post,Hospital_name,number);
        databaseReference.child("News Feed").push().setValue(newsFeedPostModel);

        Intent home = new Intent(FabActivity.this, NewsFeed.class);
        startActivity(home);

    }
}
