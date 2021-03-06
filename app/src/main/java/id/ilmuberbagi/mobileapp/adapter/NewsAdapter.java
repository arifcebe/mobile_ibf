package id.ilmuberbagi.mobileapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import id.ilmuberbagi.mobileapp.R;
import id.ilmuberbagi.mobileapp.model.NewsModel;
import id.ilmuberbagi.mobileapp.view.NewsDetailActivity;
import id.ilmuberbagi.mobileapp.viewholder.NewsViewHolder;

/**
 * Created by arifcebe on 5/29/16.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>
        implements View.OnClickListener{

    private Context context;
    private List<NewsModel> list;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

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
    public void onBindViewHolder(final NewsViewHolder holder, int position) {

        final NewsModel model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.author.setText(model.getAuthor());
        holder.date.setText(model.getDate());

        Glide.with(context)
                .load(model.getImg())
                .into(holder.imgThumb);

        holder.imgThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //context.startActivity(new Intent(context, NewsDetailActivity.class));
                NewsDetailActivity.animateNewsDetail((AppCompatActivity) context,holder.imgThumb,model);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override public void onClick(final View v) {
        onItemClickListener.onItemClick(v, (NewsModel) v.getTag());
    }


    public interface OnItemClickListener{
        void onItemClick(View view,NewsModel model);
    }
}
