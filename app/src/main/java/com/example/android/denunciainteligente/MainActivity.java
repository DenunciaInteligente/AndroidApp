package com.example.android.denunciainteligente;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

import cz.msebera.android.httpclient.Header;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {
    int duration = Toast.LENGTH_SHORT;
    Button btningresar;
    EditText txtusu, txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusu = (EditText) findViewById(R.id.user_edit_text);
        txtpass = (EditText) findViewById(R.id.pass_edit_text);
        btningresar = (Button) findViewById(R.id.ingresar_button);

        //btningresar.setOnClickListener(this);
    }
    public void pruebaclick(View view){

        startActivity(new Intent(MainActivity.this,RegistroActivity.class));

    }
    public void validarOnClick(View view) {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://denuncias.esy.es/Validar.php";
        // String url = "http://192.168.0.5:8080/ServicioWeb/Validar.php";
        RequestParams requestParams = new RequestParams();
        requestParams.add("usu", txtusu.getText().toString());
        requestParams.add("pass", txtpass.getText().toString());

        RequestHandle post = client.post(url, requestParams, new AsyncHttpResponseHandler()
        { String usuario = null;
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    try {

                        JSONObject o = new JSONObject(new String(responseBody));
                        usuario = o.getString("usu");
                        if (!TextUtils.isEmpty(usuario)) {

                            Validar val = (Validar) getApplicationContext();
                            val.setUsuario(usuario);
                            startActivity(new Intent(MainActivity.this,Menu.class));


                        } else {

                            Toast toast = Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", duration);
                            toast.show();
                        }

                    } catch (JSONException e) {
                        Toast toast = Toast.makeText(MainActivity.this, "Ha ocurrido un errors" , duration);
                        toast.show();
                        Log.e("JSON Parser", "Error parsing data " + e.toString());


                    }
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
            }
       /* RequestHandle post = client.post(url, requestParams, new AsyncHttpResponseHandler() {
                    String usuario = null;
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if (statusCode == HttpURLConnection.HTTP_OK) {
                            try {
                                JSONObject o = new JSONObject(new String(responseBody));
                                usuario = o.getString("usu");
                                if(!TextUtils.isEmpty(usuario)){

                                    Validar val= (Validar) getApplicationContext();
                                    val.setUsuario(usuario);
                                    startActivity(new Intent(MainActivity.this,Menu.class));


                                } else{
                                    int duration = Toast.LENGTH_SHORT;

                                    Toast toast = Toast.makeText(context,"Ha ocurrido un error",duration);
                                    toast.show();
                                }



                            } catch (JSONException e) {


                            }


                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Crouton.makeText(MainActivity.this,"Error de ingreso", Style.ALERT).show();
                    }
                }*/


        );
    }
    }

