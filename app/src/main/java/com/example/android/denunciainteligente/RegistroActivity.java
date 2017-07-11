package com.example.android.denunciainteligente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import com.android.volley.toolbox.JsonObjectRequest;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.duration;

public class RegistroActivity extends AppCompatActivity {
    int duration = Toast.LENGTH_SHORT;
    EditText firstname, lastname, email, confirm;
    Button insert, show;
    RequestQueue requestQueue;
    String insertUrl = "http://denuncias.esy.es/insert1.php";
   // String insertUrl = "http://192.168.0.5:8080/ServicioWeb/insert1.php";
    //String showUrl = "http://192.168.0.5:8080/ServicioWeb/showinsert.php";
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        LinearLayout ll = (LinearLayout) findViewById(R.id.linear_layout);
        ll.setAlpha(1);

        firstname = (EditText) findViewById(R.id.users_text_view);
        lastname = (EditText) findViewById(R.id.passR_text_view);
        confirm = (EditText) findViewById(R.id.confirm_text_view);
        email = (EditText) findViewById(R.id.emailR_text_view);
        insert = (Button) findViewById(R.id.insert);
        //result = (TextView) findViewById(R.id.textview);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
/*
        show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, showUrl, new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse (JSONObject response){
                        try {
                            JSONArray students = response.getJSONArray("students");
                            for(int i = 0; i < students.length(); i++){
                                JSONObject student = students.getJSONObject(i);

                                String firstname = student.getString("firstname");
                                String lastname = student.getString("lastname");
                                String email = student.getString("email");


                                result.append(firstname+""+lastname+""+email+"\n");


                            }
                            result.append("===\n");



                        } catch (JSONException e){
                            e.printStackTrace();

                        }
                    }

                }, new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse (VolleyError error){


                    }
                });
                requestQueue.add(jsonObjectRequest);

            }
        });


*/


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if( firstname.getText().toString().length() == 0){
                    firstname.setError( "El campo usuario es requerido" );}else{
                    if( lastname.getText().toString().length() == 0){
                        lastname.setError( "El campo contraseña es requerido" );
                    }else{
                        if( email.getText().toString().length() == 0){
                            email.setError( "El campo email es requerido" );

                        }else{
                            if( confirm.getText().toString().length() == 0){
                                confirm.setError( "El campo de confirmación de contraseña es requerido" );

                            }else{

                                if(lastname.getText().toString().equals(confirm.getText().toString())) {
                                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Toast toast = Toast.makeText(RegistroActivity.this, "Ha sido registrado", duration);
                                            toast.show();
                                            startActivity(new Intent(RegistroActivity.this,MainActivity.class));
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {

                                        }
                                    }) {
                                        @Override
                                        protected Map<String, String> getParams() throws AuthFailureError {
                                            Map<String, String> parameters = new HashMap<String, String>();
                                            parameters.put("firstname", firstname.getText().toString());
                                            parameters.put("lastname", lastname.getText().toString());
                                            parameters.put("email", email.getText().toString());
                                            return parameters;

                                        }

                                    };

                                    requestQueue.add(request);
                                }else
                                {
                                    Toast toast = Toast.makeText(RegistroActivity.this, "Las contraseñas no son iguales", duration);
                                    toast.show();

                                }


                            }
                        }

                    }

                }

    }
});


    }


    public void volver(View view) {
        startActivity(new Intent(RegistroActivity.this, MainActivity.class));

    }




}
