//Name: DUNG LY         ID: N01327929
package dung.ly.n01237929;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewPagerAdapter extends FragmentStatePagerAdapter
{

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior)
    {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new DungFragment();
            case 1:
                return new LyFragment();
            case 2:
                return new N01327929Fragment();
            default:
                return new DungFragment();

        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}
