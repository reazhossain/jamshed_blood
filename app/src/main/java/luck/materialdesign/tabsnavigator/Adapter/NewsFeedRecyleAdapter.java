package luck.materialdesign.tabsnavigator.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import luck.materialdesign.tabsnavigator.News_feed_post_Model;
import luck.materialdesign.tabsnavigator.R;

/**
 * Created by prince on 7/30/2017.
 */

public class NewsFeedRecyleAdapter extends RecyclerView.Adapter<NewsFeedRecyleAdapter.ViewHolder> {
    private ArrayList<News_feed_post_Model> newsArrayList;

    public NewsFeedRecyleAdapter(ArrayList<News_feed_post_Model> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }

    public NewsFeedRecyleAdapter() {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.title);
        }
    }



    // Create new views (invoked by the layout manager)
    @Override
    public NewsFeedRecyleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_newsfeed_cardview2, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(newsArrayList.get(position).getSeekerNumber());

    }


    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }
}
