//Name: DUNG LY         ID: N01327929
package dung.ly.n01237929;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class N01327929Fragment extends Fragment

{
    private View view1;
    private ImageView earthImgview, moonTmgview;
    private Button btnstart, btnstop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.n01327929fragment, container, false);
        view1 = view;
        setupid();

        btnstart.setOnClickListener(v ->
        {
            startAni();
        });

        btnstop.setOnClickListener(v ->
        {
            stopAni();
        });

        return view;

    }

    private void setupid()
    {
        earthImgview = view1.findViewById(R.id.imgViewearth);
        moonTmgview = view1.findViewById(R.id.imgViewmoon);
        btnstart = view1.findViewById(R.id.btnstartani);
        btnstop = view1.findViewById(R.id.dungbtnstopani);
    }

    private void startAni()
    {
        Toast.makeText(getActivity(), R.string.Animation_start, Toast.LENGTH_SHORT).show();

        this.earthImgview.setImageResource(R.drawable.earth);
        this.moonTmgview.setImageResource(R.drawable.moon);


        Animation eAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.earthanimation);
        Animation mAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.moonanimation);

        eAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.RESTART);
        mAnimation.setRepeatCount(Animation.INFINITE);

        this.moonTmgview.startAnimation(mAnimation);
        this.earthImgview.startAnimation(eAnimation);
    }

    private void stopAni()
    {
        Toast.makeText(getActivity(), R.string.Animation_Stop, Toast.LENGTH_SHORT).show();
        this.earthImgview.clearAnimation();
        this.moonTmgview.clearAnimation();
    }
}
