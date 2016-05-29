package id.ilmuberbagi.mobileapp.view;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.ilmuberbagi.mobileapp.BaseActivity;
import id.ilmuberbagi.mobileapp.R;
import id.ilmuberbagi.mobileapp.adapter.MainTabPagerAdapter;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_tab)
    TabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_pager)
    ViewPager pager;
    @BindView(R.id.main_appBar)
    AppBarLayout appBar;

    @BindView(R.id.main_menu_main)
    FrameLayout frameMenu;
    @BindView(R.id.main_menu_close)
    TextView btnClose;

    private MainTabPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        pagerAdapter = new MainTabPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addTab(new NewsFragment(),getResources().getString(R.string.news));
        pagerAdapter.addTab(new BlogFragment(),getResources().getString(R.string.blog));
        pagerAdapter.addTab(new ProgramsFragment(),getResources().getString(R.string.programs));

        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
            case R.id.action_profile:
                frameMenu.setVisibility(View.VISIBLE);
                break;
        }
        return true;
    }

    @OnClick(R.id.main_menu_close)
    public void mainClose(){
        frameMenu.setVisibility(View.GONE);
    }
}
