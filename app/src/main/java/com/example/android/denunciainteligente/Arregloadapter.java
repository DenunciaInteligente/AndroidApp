package com.example.android.denunciainteligente;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman on 22/06/2017.
 */

public class Arregloadapter extends RecyclerView.Adapter<Arregloadapter.MyViewHolder> {

    List<Arreglo> listaArreglo;
    Context context;

    public Arregloadapter(Context context, List<Arreglo> data){
        this.context = context;
        this.listaArreglo = data;

    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        public TextView nombre_denuncia, descri_denuncia;
        public ImageView imagen_denuncia;

        public MyViewHolder(View itemView) {
            super(itemView);

            nombre_denuncia = (TextView) itemView.findViewById(R.id.nombre_denuncia_text_view);
            imagen_denuncia = (ImageView) itemView.findViewById(R.id.image_denuncia_view);
            descri_denuncia = (TextView) itemView.findViewById(R.id.estado_denuncia_text_view);
        }
    }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

            return new MyViewHolder(itemView);
        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Arreglo Arreglo = listaArreglo.get(position);

            holder.nombre_denuncia.setText(Arreglo.nombreDenuncia());
            holder.descri_denuncia.setText(Arreglo.descriDenuncia());
            Glide.with(context).load(Arreglo.estadoDenuncia()).into(holder.imagen_denuncia);
        }



    //en este constructor asignas el contexto de la actividad el arreglo y además el color de fondo de cada activity, esto
    //se hace a través del colorResourceId el cual pides los datos hacia colors.xml mediante el resources.

  /*  private int mcolorResourceId;

    public Arregloadapter(Activity context, ArrayList<Arreglo> arregloadapter, int colorResourceId) {
        super(context, 0, arregloadapter);
        mcolorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        Arreglo actualarreglo = getItem(position);

        TextView textViewNombre = (TextView) listitemView.findViewById(R.id.nombre_denuncia_text_view);

        textViewNombre.setText(actualarreglo.nombreDenuncia());

        TextView textViewEstado = (TextView) listitemView.findViewById(R.id.estado_denuncia_text_view);

        textViewEstado.setText(actualarreglo.estadoDenuncia());

        ImageView imageViewdenuncia = (ImageView) listitemView.findViewById(R.id.image_denuncia_view);

        if (actualarreglo.hasImage()) {
            imageViewdenuncia.setImageResource(actualarreglo.getfotoId());

        } else {
            imageViewdenuncia.setVisibility(View.GONE);
        }

        View textContainer = listitemView.findViewById(R.id.linear_layout_list_item);

        int color = ContextCompat.getColor(getContext(), mcolorResourceId);


        textContainer.setBackgroundColor(color);

        return listitemView;
        */
    @Override
    public int getItemCount() {
        return listaArreglo.size();
    }
    }
