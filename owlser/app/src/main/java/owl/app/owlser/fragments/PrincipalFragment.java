package owl.app.owlser.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import owl.app.owlser.R;
import owl.app.owlser.adapters.OnItemSliderClickListener;
import owl.app.owlser.adapters.SliderAdapter;
import owl.app.owlser.models.Slider;

public class PrincipalFragment extends Fragment {

    private RecyclerView RecyclerView;
    private RecyclerView.Adapter sliderAdapter;
    private RecyclerView.LayoutManager sliderLayoutManager;

    private List<Slider> sliderList;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        RecyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewSlider);

        this.sliderList = getSliderList();

        // crear el adaptador y configurarlo en la vista de lista
        sliderLayoutManager = new LinearLayoutManager(getActivity());

        sliderAdapter = new SliderAdapter(sliderList, R.layout.cardview_slider, new OnItemSliderClickListener() {
            @Override
            public void onItemClick(Slider sliderInterface, int position) {
                Toast.makeText(getContext(),"descripción: " + sliderInterface.getDescripcion(), Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView.setHasFixedSize(true);
        RecyclerView.setItemAnimator(new DefaultItemAnimator());

        RecyclerView.setLayoutManager(sliderLayoutManager);
        RecyclerView.setAdapter(sliderAdapter);

        return view;
    }

    private List<Slider> getSliderList(){
        return new ArrayList<Slider>()
        {{
         add(new Slider(1,"Página Web","Es una página web desarrollada para el ayuntamiento de cosamaloapan veracruz",
                 R.drawable.ic_launcher_background, R.drawable.pagina_web));
         add(new Slider(2,"Aplicacion Móvil","Es una aplicación móvil desarrollada para el ayuntamiento de cosamaloapan veracruz",
                 R.drawable.ic_launcher_background, R.drawable.moviles_espana));
         add(new Slider(3,"Página Web y Aplicación Móvil","Es una página web y una aplicación móvil desarrollada para la canaco servytur",
                 R.drawable.ic_launcher_background, R.drawable.pagina_web2));
        }};
    }

}
