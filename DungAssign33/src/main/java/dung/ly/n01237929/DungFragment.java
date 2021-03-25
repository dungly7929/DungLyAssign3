package dung.ly.n01237929;

import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DungFragment extends Fragment

{

    private Button btn ;
    private ImageButton btnthick1,btnthick2,btnthick3 ;
    private Button btncolor1,btncolor2,btncolor3;
    private CanvasView cuscanvas;
    public int thick1 = 1, thick2 = 4, thick3 = 6;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.dungfragment,container,false);

            cuscanvas = (CanvasView) view.findViewById(R.id.signature_canvas);
            btn = view.findViewById(R.id.clearbtn);
            btnthick1 = view.findViewById(R.id.imgbtnthick1);
            btnthick2 = view.findViewById(R.id.imgbtnthick2);
            btnthick3 = view.findViewById(R.id.imgbtnthick3);
            btncolor1 = view.findViewById(R.id.btncolor1);
            btncolor2 = view.findViewById(R.id.btncolor2);
            btncolor3 = view.findViewById(R.id.btncolor3);

            btn.setOnClickListener(v -> cuscanvas.clear());

            btnthick1.setOnClickListener(v -> {cuscanvas.setBrushsize(thick1); });
            btncolor1.setOnClickListener(v -> {cuscanvas.setColor("#FB0303");});

            btnthick2.setOnClickListener(v -> {cuscanvas.setBrushsize(thick2); });
            btncolor2.setOnClickListener(v -> {cuscanvas.setColor("#02DAF6");});

            btnthick3.setOnClickListener(v -> {cuscanvas.setBrushsize(thick3); });
            btncolor3.setOnClickListener(v -> {cuscanvas.setColor("#07000E");});

            return view;
        }
    }
