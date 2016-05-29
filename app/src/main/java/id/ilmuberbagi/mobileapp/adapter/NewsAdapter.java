package id.ilmuberbagi.mobileapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import id.ilmuberbagi.mobileapp.R;
import id.ilmuberbagi.mobileapp.model.NewsModel;
import id.ilmuberbagi.mobileapp.viewholder.NewsViewHolder;

/**
 * Created by arifcebe on 5/29/16.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{

    private Context context;
    private List<NewsModel> list;

    public NewsAdapter(Context context, List<NewsModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item,null);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        NewsModel model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.author.setText(model.getAuthor());
        holder.date.setText(model.getDate());

        Glide.with(context)
                .load(model.getImg())
                .into(holder.imgThumb);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
