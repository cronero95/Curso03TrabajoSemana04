package com.cronero.curso03trabajosemana04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    private String correo ;
    private String contrasena;
    private String destintatario;

    private Properties properties;
    private Session session;
    private Message mensaje;

    private TextInputEditText campoNombre;
    private TextInputEditText campoCorreo;
    private TextInputEditText campoMensaje;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        Toolbar miActionBar = findViewById(R.id.miActionBarBack);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        correo = "juan@gmail.com";
        contrasena = "12345678Ab";
        destintatario = "pablo@gmail.com";

        campoNombre = findViewById(R.id.campoNombre);
        campoCorreo = findViewById(R.id.campoCorreo);
        campoMensaje = findViewById(R.id.campoMensaje);

        activity = this;

        Button button = findViewById(R.id.botonEnviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.ThreadPolicy policy = new  StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.starttls.enable","true");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contrasena);
                        }
                    });
                    if (session!=null){
                        mensaje = new MimeMessage(session);
                        mensaje.setFrom(new InternetAddress(correo));
                        mensaje.setSubject("Nuevo Mensaje de Petagram");
                        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destintatario));
                        mensaje.setContent("Nombre: " + campoNombre.getText().toString()
                                + "\nCorreo: " + campoCorreo.getText().toString()
                                + "\nMensaje: " + campoMensaje.getText().toString(), "text/html; charset=utf-8");

                        Transport.send(mensaje);

                        Toast.makeText(activity, activity.getString(R.string.mensaje_enviado), Toast.LENGTH_SHORT).show();
                        NavUtils.navigateUpFromSameTask(activity);
                    }

                } catch (Exception e){
                    Toast.makeText(activity, activity.getString(R.string.mensaje_no_enviado), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}