package luck.materialdesign.tabsnavigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewsFeed extends AppCompatActivity {

    ArrayList<News_feed_post_Model> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("News Feed");

        arrayList = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //int count=0;

                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    News_feed_post_Model newsFeedPostModel = snapshot.getValue(News_feed_post_Model.class);
                    arrayList.add(newsFeedPostModel);

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(this,arrayList);
        CardView
    }
}
