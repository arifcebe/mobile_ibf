package id.ilmuberbagi.mobileapp.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ilmuberbagi.mobileapp.R;
import id.ilmuberbagi.mobileapp.model.NewsModel;

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
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static final String EXTRA_IMAGE = "news_image";
    public static final String EXTRA_TITLE = "news_title";

    public static void animateNewsDetail(AppCompatActivity activity, View transitionImage, NewsModel model) {
        Intent intent = new Intent(activity, NewsDetailActivity.class);
        intent.putExtra(EXTRA_IMAGE, model.getImg());
        intent.putExtra(EXTRA_TITLE, model.getTitle());

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                transitionImage, EXTRA_IMAGE);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityTransition();
        setContentView(R.layout.news_detail_activity);
        ButterKnife.bind(this);

        initContentDetail();
    }

    @Override public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void initActivityTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    private void initContentDetail(){

        // get String extra
        String getTitle = getIntent().getStringExtra(EXTRA_TITLE);
        String getImage = getIntent().getStringExtra(EXTRA_IMAGE);

        // set animate on image
        ViewCompat.setTransitionName(appBar,EXTRA_IMAGE);
        supportPostponeEnterTransition();
        // set collapsing toolbar
        //collapsingToolbarLayout.setTitle(getTitle);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        // set action bar toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // set content
        title.setText(getTitle);
        author.setText("oleh : Aussie");
        date.setText("30 Mei 2016 19.30 WIB");
        category.setText("Umum");
        Glide.with(this)
                .load(getImage)
                .into(img);
        content.setHtmlFromString("Sedikit berbagi pengalaman.\n" +
                "\n" +
                "Pernah suatu pagi, waktu sedang padat-padatnya kendaraan dan sedang terburu-burunya orang untuk berangkat kerja, sekolah, kuliah dan lain-lain, aku yang sedang terburu-buru ingin segera sampai ke kantor, di traffict light melihat seorang nenek, yang menurut saya sudah sangat tua, yang biasanya memang hadir di situ untuk menerima titipan Allah yang dibawa para pengendara.\n" +
                "\n" +
                "Sedekah\n" +
                "\n" +
                "Aku yang memang berhenti di dekatnya ingin sekali merogoh saku, sedikit memberi kertas berharga untuk beliau. Tetapi karena terburu waktu dan memang traffict light di situ berjalannya cepat, akhirnya aku berfikiran nanti setelah sampai kantor aku ijin keluar sebentar, sambil cari sesuatu. Dan ternyata setelah aku sampai di sana lagi beliau sudah tidak di tempat.\n" +
                "\n" +
                "Dan memang benar, bahwa bila ingin bersedekah jangan menunggu nanti, besok atau lusa, karena pintu sedekah dari Allah tidak selalu terbuka untuk kita. Terkadang pintu itu dibuka waktu kita sedang terburu-buru, sedang tidak ada waktu, atau bahkan sedang memiliki rejeki yang kita anggap hanya cukup untuk kita saja. Padahal telah dijanjikan oleh Allah atas rejeki setiap makhluk-Nya.\n" +
                "\n" +
                "Do now or you gonna lose it.", new HtmlTextView.LocalImageGetter());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
