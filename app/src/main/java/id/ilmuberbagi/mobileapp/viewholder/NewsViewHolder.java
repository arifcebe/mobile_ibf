package id.ilmuberbagi.mobileapp.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ilmuberbagi.mobileapp.R;

/**
 * Created by arifcebe on 5/29/16.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.news_item_title)
    public TextView title;
    @BindView(R.id.news_item_author)
    public TextView author;
    @BindView(R.id.news_item_date)
    public TextView date;
    @BindView(R.id.news_item_imgThumb)
    public ImageView imgThumb;

    public  NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


}
