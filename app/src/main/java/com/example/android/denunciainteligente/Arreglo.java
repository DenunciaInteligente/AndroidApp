package com.example.android.denunciainteligente;

/**
 * Created by roman on 22/06/2017.
 */

public class Arreglo {
    private String mnombreDenuncia;
    private String mestadoDenuncia;
    private String mdescriDenuncia;
    private int mfoto = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Arreglo(String nombreDenuncia, String estadoDenuncia, String descriDenuncia){

        mnombreDenuncia = nombreDenuncia;
        mestadoDenuncia = estadoDenuncia;
        mdescriDenuncia = descriDenuncia;
    }


    public Arreglo(String nombreDenuncia, String estadoDenuncia, int foto){

        mnombreDenuncia = nombreDenuncia;
        mestadoDenuncia = estadoDenuncia;
        mfoto = foto;
    }

   public String nombreDenuncia(){
       return mnombreDenuncia;
   }
   public String estadoDenuncia(){
       return mestadoDenuncia;

   }
    public String descriDenuncia(){
        return mdescriDenuncia;

    }
   public int getfotoId(){
       return mfoto;

   }

   public boolean hasImage(){
       return mfoto != NO_IMAGE_PROVIDED;
   }

}
