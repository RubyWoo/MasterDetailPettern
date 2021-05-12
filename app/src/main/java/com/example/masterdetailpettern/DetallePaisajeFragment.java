package com.example.masterdetailpettern;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetallePaisajeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallePaisajeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //::::::::::::

    PaisajeVo paisaje;

    TextView textDescripDetails;
    ImageView imageViewDetails;

    public DetallePaisajeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetallePaisajeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetallePaisajeFragment newInstance(String param1, String param2) {
        DetallePaisajeFragment fragment = new DetallePaisajeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_paisaje, container, false);
        textDescripDetails = view.findViewById(R.id.textView_description_details);
        imageViewDetails = view.findViewById(R.id.imageView_details);

        Bundle paisajeEnviado = getArguments();

        if(paisajeEnviado != null ){

            paisaje = (PaisajeVo) paisajeEnviado.getSerializable("objeto");
            asignarInformacion(paisaje);

        }

        return view;
    }

    public void asignarInformacion(PaisajeVo paisaje) {

        textDescripDetails.setText(paisaje.getDescriptionDetails());
        imageViewDetails.setImageResource(paisaje.getImageResourceDetails());
    }
}
