package luck.materialdesign.tabsnavigator;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jamshed on 7/30/2017.
 */

public class NewsFeedAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<News_feed_post_Model>arrayList;

    public NewsFeedAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<News_feed_post_Model>arrayList) {
        super(context, R.layout.custom_newsfeed_cardview, arrayList);

        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_newsfeed_cardview,parent,false);

        TextView Hospital_name = (TextView) convertView.findViewById(R.id.hospital_name_TV);
        TextView phone_number = (TextView) convertView.findViewById(R.id.pnumber_TV);
        TextView Status = (TextView) convertView.findViewById(R.id.post_TV);

        News_feed_post_Model newsFeedPostModel = arrayList.get(position);


        Hospital_name.setText(newsFeedPostModel.getHospital_name());
        phone_number.setText(newsFeedPostModel.getSeekerNumber());
        Status.setText(newsFeedPostModel.getStatus());



        return convertView;
       // return super.getView(position, convertView, parent);
    }
}
