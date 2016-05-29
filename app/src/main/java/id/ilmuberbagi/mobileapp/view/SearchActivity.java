package id.ilmuberbagi.mobileapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ilmuberbagi.mobileapp.R;

/**
 * Created by arifcebe on 5/29/16.
 */
public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.search_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.search_close)
    TextView btnClose;
    @BindView(R.id.search_clear)
    ImageView clearText;
    @BindView(R.id.search_edSearch)
    EditText edSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        ButterKnife.bind(this);

    }
}
