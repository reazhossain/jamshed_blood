package luck.materialdesign.tabsnavigator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import luck.materialdesign.tabsnavigator.Model.Donar_list_model;

/**
 * Created by Jamshed on 7/30/2017.
 */

public class Donar_list_Adapter extends RecyclerView.Adapter<Donar_list_Adapter.ViewHolder>{

    private ArrayList<Donar_list_model>newArrayList;
    public Donar_list_Adapter(ArrayList<Donar_list_model> newArrayList) {
        this.newArrayList = newArrayList;
    }

    public Donar_list_Adapter() {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView donar_name,donar_number,donar_address,donar_blood_group;
        public ViewHolder(View v) {
            super(v);
            donar_name = (TextView) v.findViewById(R.id.donar_name_tv);
            donar_number = (TextView) v.findViewById(R.id.donar_number_tv);
            donar_address = (TextView) v.findViewById(R.id.donar_address_tv);
            donar_blood_group = (TextView) v.findViewById(R.id.blood_group_tv);

        }
    }



    @Override
    public Donar_list_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_custom__donar_list, parent, false);

        Donar_list_Adapter.ViewHolder vh = new Donar_list_Adapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Donar_list_Adapter.ViewHolder holder, int position) {

        holder.donar_name.setText(newArrayList.get(position).getDonarName());
        holder.donar_number.setText(newArrayList.get(position).getDonarNumber());
        holder.donar_address.setText(newArrayList.get(position).getDonarAddress());
        holder.donar_blood_group.setText(newArrayList.get(position).getBlood_group());

    }

    @Override
    public int getItemCount() {
        return 0;
    }



}
