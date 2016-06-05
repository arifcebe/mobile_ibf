package id.ilmuberbagi.mobileapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ilmuberbagi.mobileapp.R;
import id.ilmuberbagi.mobileapp.adapter.NewsAdapter;
import id.ilmuberbagi.mobileapp.model.NewsModel;

/**
 * Created by arifcebe on 5/28/16.
 */
public class NewsFragment extends Fragment {

    @BindView(R.id.news_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.news_recyclerview_header)
    RecyclerViewHeader recyclerViewHeader;
    @BindView(R.id.news_header_image)
    ImageView imgHeader;

    private NewsAdapter adapter;
    private List<NewsModel> list = new ArrayList<NewsModel>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment,null);
        ButterKnife.bind(this,view);

        adapter = new NewsAdapter(getActivity(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerViewHeader.attachTo(recyclerView);

        Glide.with(this)
                .load("https://2.bp.blogspot.com/-t9YAB7aQXWk/Vt7soe8evDI/AAAAAAAAADk/sN6Jhy9WtkA/s320/ardi-kick-andy-285x300.jpg")
                .into(imgHeader);

        for (int i = 0;i < 15;i++){
            NewsModel model = new NewsModel();
            model.setTitle("Ridwan kamil : kami akan bangun Bandung");
            model.setAuthor("Aussie");
            model.setDate("10 menit lalu");
            model.setImg("http://2.bp.blogspot.com/-JWU0jEmCFDY/Ub2R8pcEZjI/AAAAAAAAAs0/2fmviEitgLo/s1600/ridwan+kamil.png");

            list.add(model);
        }

        return view;
    }
}
