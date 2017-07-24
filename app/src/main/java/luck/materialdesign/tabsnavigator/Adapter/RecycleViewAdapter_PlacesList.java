package luck.materialdesign.tabsnavigator.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

import luck.materialdesign.tabsnavigator.Model.PlacesListModel;
import luck.materialdesign.tabsnavigator.R;

/**
 * Created by prince on 2/10/2017.
 */

public class RecycleViewAdapter_PlacesList extends RecyclerView.Adapter<RecycleViewAdapter_PlacesList.PersonViewHolder> {

static String place_id;

    List<PlacesListModel> place;
    static FragmentTransaction fragmentTransaction;
  static Context context;

    public RecycleViewAdapter_PlacesList(List<PlacesListModel> place, FragmentTransaction fragmentTransaction) {
        this.place = place;
        this.fragmentTransaction = fragmentTransaction;
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView name;
        TextView address;
        RatingBar rating;

        PersonViewHolder(View itemView) {
            super(itemView);

            cv = (CardView) itemView.findViewById(R.id.card_view);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            rating = (RatingBar) itemView.findViewById(R.id.rating);

            ///View onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String placeName = name.getText().toString();
                    String mAddress = address.getText().toString();

                    ///Toast.makeText(v.getContext(), "Name:"+place_id, Toast.LENGTH_LONG).show();

                    try{

                     /*   Fragment fragment = new PlaceDetailsFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("name", placeName);
                        bundle.putString("place_id", place_id);
                        fragment.setArguments(bundle);

                        if (fragment != null) {


                            fragmentTransaction.replace(R.id.container, fragment, fragment.getTag());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }*/

                    }catch (Exception e)
                    {
                        Log.d("Error", ""+e.getMessage());
                       Toast.makeText(v.getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }



                }
            });
        }
    }


    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_design_places_list, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        

        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {

        context = holder.name.getContext();

        place_id = place.get(position).getPlace_id();

        holder.name.setText(place.get(position).getName());
        holder.address.setText(place.get(position).getAddress());

        double a = place.get(position).getRating();
        float rating = (float) a;  //b will lose some of a's precision

        holder.rating.setRating(rating);
        
 /*       holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "hi", Toast.LENGTH_SHORT).show();
            }
        });*/

    }




    @Override
    public int getItemCount() {
        return place.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
