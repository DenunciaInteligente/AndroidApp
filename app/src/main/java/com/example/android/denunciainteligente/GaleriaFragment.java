package com.example.android.denunciainteligente;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by roman on 12/06/2017.
 */

public class GaleriaFragment extends Fragment {

    private ArrayList<Arreglo> listaImagenesArreglo;
    private RecyclerView recyclerView;
    private Arregloadapter adapter;

    Arreglo Arreglo;
    String nombre_denuncia, estado_denuncia, descri_denuncia;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_galeria, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        listaImagenesArreglo = new ArrayList<>();
        adapter = new Arregloadapter(getContext(), listaImagenesArreglo);

        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);
        stringBuscar("http://denuncias.esy.es/sistema_denuncias_final/CapaDatos/galeria.php");
        return rootView;

    }
    public void stringBuscar(String url){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObj = jsonArray.getJSONObject(i);
                        nombre_denuncia = jsonObj.getString("titulo");
                        descri_denuncia = jsonObj.getString("descripcion");
                        estado_denuncia = jsonObj.getString("imagen");
                        Arreglo = new Arreglo(nombre_denuncia,estado_denuncia,descri_denuncia);
                        listaImagenesArreglo.add(Arreglo);
                    }
                    adapter.notifyDataSetChanged();
                }
                catch (JSONException e) {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
        /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_galeria, container, false);



        ArrayList<Arreglo> denuncias = new ArrayList<Arreglo>();
        denuncias.add(new Arreglo("Asalto","Activo",R.drawable.avatar));
        denuncias.add(new Arreglo("Asalto","Activo",R.drawable.avatar));
        denuncias.add(new Arreglo("Asalto","Activo",R.drawable.register1));
        denuncias.add(new Arreglo("Asalto","Activo",R.drawable.register1));

        Arregloadapter adapter = new Arregloadapter(getActivity(),denuncias,R.color.denuncias);
        ListView listView = (ListView) rootView.findViewById(R.id.List);
        listView.setAdapter(adapter);
        return rootView;

*/
    }

}
