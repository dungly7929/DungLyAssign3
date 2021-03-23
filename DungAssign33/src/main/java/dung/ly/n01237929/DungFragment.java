package dung.ly.n01237929;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

public class DungFragment extends Fragment

{
    private Button btn ;
    private CanvasView cuscanvas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.dungfragment,container,false);
        cuscanvas = (CanvasView) view.findViewById(R.id.signature_canvas);
        btn = view.findViewById(R.id.clearbtn);
        btn.setOnClickListener(v -> cuscanvas.clear());
        return view;
    }

}
