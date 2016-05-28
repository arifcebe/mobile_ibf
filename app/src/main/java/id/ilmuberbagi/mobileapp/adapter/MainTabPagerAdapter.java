package id.ilmuberbagi.mobileapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arifcebe on 5/28/16.
 */
public class MainTabPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment = new ArrayList<Fragment>();
    private List<String> listTitle = new ArrayList<String>();

    public MainTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addTab(Fragment fragment,String title){
        listFragment.add(fragment);
        listTitle.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
