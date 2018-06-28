package co.appdev.search.ui.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.appdev.search.R;
import co.appdev.search.data.model.User;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ContactViewHolder> {

    private final List<User> userList;
    private Context mContext;


    public SearchAdapter(List<User> userList, Context mContext) {
        this.userList = userList;
        this.mContext = mContext;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_user, null);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        final User user = userList.get(position);

        Glide.with(mContext).load(user.getUrl()).into(holder.dp);
        holder.name.setText(user.getName());
        holder.score.setText(Double.toString(user.getScore()));
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }


    public  class ContactViewHolder extends RecyclerView.ViewHolder {

        ImageView dp;
        TextView name;
        TextView score;

        public ContactViewHolder(View itemView) {
            super(itemView);
            dp = itemView.findViewById(R.id.dp);
            name = itemView.findViewById(R.id.name);
            score = itemView.findViewById(R.id.score);
        }
    }
}
 
