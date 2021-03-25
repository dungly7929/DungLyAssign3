package dung.ly.n01237929;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LyFragment extends Fragment {
    private int CALL_PERMISSION = 1;
    private View view1;
    Button btnper, btnstart, btnstop, btn500,btn300,btn100,btn25;
    AnimationDrawable mframeAnimation = null;
    int stop = 0;
    ImageView shark;
    ArrayList<BitmapDrawable> frame = new ArrayList<BitmapDrawable>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lyfragment, container, false);
        view1 = view;
        setupid();
        btnper.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "You're already have this permission !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:4377708477"));
                startActivity(intent);
            } else {
                requestStoregePer();
            }
        });

        btnstart.setOnClickListener(v -> {
            AnimationStart();

        });
        btnstop.setOnClickListener(v ->
        {
            if (mframeAnimation == null) {
                Toast.makeText(getActivity(), "No animation to Stop !", Toast.LENGTH_SHORT).show();
            } else {
                stopAnimation();
            }

        });
        btn500.setOnClickListener(v ->
        {
            animationspeed(500);
        });

        btn300.setOnClickListener(v ->
        {
            animationspeed(300);
        });

        btn100.setOnClickListener(v ->
        {
            animationspeed(100);
        });

        btn25.setOnClickListener(v ->
        {
            animationspeed(25);
        });
        return view;
    }

    private void requestStoregePer() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CALL_PHONE)) {
            new AlertDialog.Builder(getActivity()).setTitle("READ EXTERNAL STORAGE PERMISSION")
                    .setMessage("This permission need because the app need to read the external storage !")
                    .setPositiveButton("Yes", (dialog, which) ->
                    {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION);
                        Snackbar.make(view1, "Permission Granted", Snackbar.LENGTH_SHORT).show();

                    }).setNegativeButton("No", (dialog, which) ->
            {
                Snackbar.make(view1, "Permission Denied", Snackbar.LENGTH_SHORT).show();
            }).create().show();
            ;
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Snackbar.make(view1, "Permission Granted", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(view1, "Permission Denied", Snackbar.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    public void AnimationStart() {
        stop = 1;
        for (int i = 1; i < 12; i++) {
            frame.add((BitmapDrawable) getResources().getDrawable(getResources().getIdentifier("shark" + i, "drawable", getActivity().getPackageName())));
        }
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);
        int reasonableDuration = 250;
        for (int i = 0; i < frame.size(); i++) {
            mframeAnimation.addFrame(frame.get(i), reasonableDuration);
        }
        shark.setBackground(mframeAnimation);
        mframeAnimation.setVisible(true, true);
        mframeAnimation.start();

    }

    private void stopAnimation() {
        stop = 0;
        mframeAnimation.stop();
        mframeAnimation.setVisible(false, false);

    }

    public void animationspeed(int number) {
        if (mframeAnimation == null) {
            Toast.makeText(getActivity(), "No animation to run !", Toast.LENGTH_SHORT).show();
        } else {
            if (stop == 0) {
                Toast.makeText(getActivity(), "You have to start animation 1st !", Toast.LENGTH_SHORT).show();
            } else {
                mframeAnimation.unscheduleSelf(mframeAnimation);
                mframeAnimation = null;
                mframeAnimation = new AnimationDrawable();
                for (int i = 0; i < frame.size(); i++) {
                    mframeAnimation.addFrame(frame.get(i), number);
                }
                shark.setBackground(mframeAnimation);
                mframeAnimation.setVisible(true, true);
                mframeAnimation.run();
            }
        }
    }

    public void setupid() {
        btnper = view1.findViewById(R.id.btnper);
        btnstart = view1.findViewById(R.id.btnstart);
        btnstop = view1.findViewById(R.id.btnstop);
        btn500 = view1.findViewById(R.id.btn500);
        btn300 = view1.findViewById(R.id.btn300);
        btn100 = view1.findViewById(R.id.btn100);
        btn25 = view1.findViewById(R.id.btn25);
        shark = (ImageView) view1.findViewById(R.id.ImgViewshark);
    }
}
