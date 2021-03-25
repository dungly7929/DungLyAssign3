package dung.ly.n01237929;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class LyFragment extends Fragment {
    private int CALL_PERMISSION = 1;
    private View view1;
    Button btnper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lyfragment, container, false);
        view1 = view;
        btnper = view.findViewById(R.id.btnper);
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
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Snackbar.make(view1, "Permission Granted", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(view1, "Permission Denied", Snackbar.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
