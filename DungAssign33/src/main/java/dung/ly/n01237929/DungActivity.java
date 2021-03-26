//DUNG LY       ID: N01327929
package dung.ly.n01237929;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DungActivity extends AppCompatActivity
{
    private BottomNavigationView bNavview;
    private ViewPager vpager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNavview = findViewById(R.id.bottom_nav);
        vpager = findViewById(R.id.dungviewpager);

        setupViewPager();

        bNavview.setOnNavigationItemSelectedListener(item ->
        {
            switch (item.getItemId())
            {
                case R.id.acttab1:
                    vpager.setCurrentItem(0);
                    break;

                case R.id.acttab2:
                    vpager.setCurrentItem(1);
                    break;

                case R.id.acttab3:
                    vpager.setCurrentItem(2);
                    break;
            }
            return true;
        });
    }

    private void setupViewPager()
    {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpager.setAdapter(viewPagerAdapter);

        vpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                switch (position)
                {
                    case 0:
                        bNavview.getMenu().findItem(R.id.acttab1).setChecked(true);
                        break;
                    case 1:
                        bNavview.getMenu().findItem(R.id.acttab2).setChecked(true);
                        break;
                    case 2:
                        bNavview.getMenu().findItem(R.id.acttab3).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

    }

    @Override
    public void onBackPressed()
    {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dung_ly_n01327929)
                .setCancelable(false)
                .setMessage(R.string.Quit_Ask)
                .setPositiveButton(R.string.Yes, (dialog, which) -> finish())
                .setNegativeButton(R.string.No, (dialog, which) -> dialog.cancel())
                .create()
                .show();
    }

}