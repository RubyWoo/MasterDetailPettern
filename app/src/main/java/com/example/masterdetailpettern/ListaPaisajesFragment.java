package com.example.masterdetailpettern;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaPaisajesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPaisajesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // ::::::::::::  VARIABLES   ::::::::::::://
    ArrayList<PaisajeVo> listaPaisajes;
    RecyclerView recyclerPaisajes;

    Activity activity;
    IComunicaFragmentsListener mListener;


    public ListaPaisajesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPaisajesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPaisajesFragment newInstance(String param1, String param2) {
        ListaPaisajesFragment fragment = new ListaPaisajesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity = (Activity) context;
            mListener = (IComunicaFragmentsListener) this.activity;
        }
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
        View vista = inflater.inflate(R.layout.fragment_lista_paisajes, container, false);

        listaPaisajes = new ArrayList<PaisajeVo>();
        recyclerPaisajes = vista.findViewById(R.id.recyclerId);
        recyclerPaisajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaPersonajes();

        AdaptadorPaisajes adapter = new AdaptadorPaisajes(listaPaisajes);
        recyclerPaisajes.setAdapter(adapter);

        adapter.setOnClickListenerRecycler(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Selecciona"
                        +listaPaisajes.get(recyclerPaisajes.getChildAdapterPosition(v)).getNameCity(),Toast.LENGTH_SHORT).show();

                mListener.enviarPaisaje(listaPaisajes.get(recyclerPaisajes.getChildAdapterPosition(v)));

            }
        });


        return vista;
    }

    private void llenarListaPersonajes(){

        listaPaisajes.add(new PaisajeVo(getString(R.string.Seattle), getString(R.string.Seattle_short_descrip),
                getString(R.string.Seattle_large_descrip),R.drawable.landsquare1,R.drawable.land1));

        listaPaisajes.add(new PaisajeVo(getString(R.string.NewYork), getString(R.string.NewYork_short_descrip),
                getString(R.string.NewYork_large_descrip), R.drawable.landsquare2,R.drawable.land2));

        listaPaisajes.add(new PaisajeVo(getString(R.string.London), getString(R.string.London_short_descrip),
                getString(R.string.London_large_descrip), R.drawable.landsquare3,R.drawable.land3));

        listaPaisajes.add(new PaisajeVo(getString(R.string.Venice), getString(R.string.Venice_short_descrip),
                getString(R.string.Venice_large_descrip), R.drawable.landsquare7,R.drawable.land4));

        listaPaisajes.add(new PaisajeVo(getString(R.string.Athens), getString(R.string.Athens_short_descrip),
                getString(R.string.Athens_large_descrip), R.drawable.landsquare6,R.drawable.land5));

        listaPaisajes.add(new PaisajeVo(getString(R.string.Mexico), getString(R.string.Mexico_short_descrip),
                getString(R.string.Mexico_large_descrip), R.drawable.landsquare5,R.drawable.land6));

        listaPaisajes.add(new PaisajeVo(getString(R.string.Toronto), getString(R.string.Toronto_short_descrip),
                getString(R.string.Toronto_large_descrip), R.drawable.landsquare4,R.drawable.land9));

    }


}
