//DUNG LY       ID: N01327929
package dung.ly.n01237929;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DungActivity extends AppCompatActivity {
    private BottomNavigationView bNavview;
    private ViewPager vpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNavview = findViewById(R.id.bottom_nav);
        vpager = findViewById(R.id.viewpager);

        setupViewPager();

        bNavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
            }
        });
    }

    private void setupViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpager.setAdapter(viewPagerAdapter);

    }


}