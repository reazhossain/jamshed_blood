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


import luck.materialdesign.tabsnavigator.Donar_list_Adapter;
import luck.materialdesign.tabsnavigator.Model.Donar_list_model;

import luck.materialdesign.tabsnavigator.R;

public class Tab2 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<Donar_list_model> newArrayList;
    public static final String TAG = "Donar List";
    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);

        newArrayList = new ArrayList<>();

        mRecyclerView = (RecyclerView) v.findViewById(R.id.news_feed_recycleview);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        filterDatabase();

        return v;
    }

    public void filterDatabase(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.child("DonarInfo").orderByChild("blood_group").equalTo("A+");

        query.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    ///All address
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        try{
                            Donar_list_model donarListModel = snapshot.getValue(Donar_list_model.class);

                            Log.d(TAG, "t"+donarListModel.getBlood_group());

                            if(donarListModel != null)
                                newArrayList.add(donarListModel);
                        }catch (Exception e){
                            Log.d(TAG, " "+e.getMessage());
                        }


                        Log.d(TAG, ""+snapshot);
                        Toast.makeText(getActivity(), "value :" + snapshot, Toast.LENGTH_SHORT).show();
                    }

                    // specify an adapter (see also next example)
                    mAdapter = new Donar_list_Adapter(newArrayList);
                    mRecyclerView.setAdapter(mAdapter);


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}