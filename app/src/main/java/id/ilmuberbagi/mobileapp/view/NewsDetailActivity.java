package id.ilmuberbagi.mobileapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ilmuberbagi.mobileapp.R;

/**
 * Created by arifcebe on 5/31/16.
 */
public class NewsDetailActivity extends AppCompatActivity {

    @BindView(R.id.news_detail_appBar)
    AppBarLayout appBar;
    @BindView(R.id.news_detail_author)
    TextView author;
    @BindView(R.id.news_detail_collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.news_detail_content)
    HtmlTextView content;
    @BindView(R.id.news_detail_date)
    TextView date;
    @BindView(R.id.news_detail_imgDetail)
    ImageView img;
    @BindView(R.id.news_detail_kategori)
    TextView category;
    @BindView(R.id.news_detail_title)
    TextView title;
    @BindView(R.id.news_detail_nestedScroll)
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_activity);
        ButterKnife.bind(this);
    }
}
