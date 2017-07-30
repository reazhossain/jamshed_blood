package luck.materialdesign.tabsnavigator.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import luck.materialdesign.tabsnavigator.Adapter.NewsFeedRecyleAdapter;
import luck.materialdesign.tabsnavigator.LoginActivity;
import luck.materialdesign.tabsnavigator.News_feed_post_Model;
import luck.materialdesign.tabsnavigator.R;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab1 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<News_feed_post_Model> newsArrayList;
    public static final String TAG = "NewsFeed";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1,container,false);

        newsArrayList = new ArrayList<>();

        mRecyclerView = (RecyclerView) v.findViewById(R.id.news_feed_recycleview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);



        filterDatabase();
        return v;
    }


    public void filterDatabase(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.child("News Feed");

        query.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    ///All address
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        try{
                            News_feed_post_Model newsModel = snapshot.getValue(News_feed_post_Model.class);

                            Log.d(TAG, "t"+newsModel.getSeekerNumber());

                            if(newsModel != null)
                                newsArrayList.add(newsModel);
                        }catch (Exception e){
                            Log.d(TAG, " "+e.getMessage());
                        }


                        Log.d(TAG, ""+snapshot);
                        Toast.makeText(getActivity(), "value :" + snapshot, Toast.LENGTH_SHORT).show();
                    }

                   // specify an adapter (see also next example)
                   mAdapter = new NewsFeedRecyleAdapter(newsArrayList);
                   mRecyclerView.setAdapter(mAdapter);
                  ///Log.d(TAG, "test "+newsArrayList.get(1).getSeekerNumber());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
