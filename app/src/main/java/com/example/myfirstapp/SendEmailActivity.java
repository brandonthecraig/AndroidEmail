package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SendEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        String to = "brandonthecraig@gmail.com, bcraig@ualberta.ca";
        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);

        // add a thing that sends a standard email to my gmail account from myself

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
        email.putExtra(Intent.EXTRA_TEXT, message);

        // need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose Email client :"));
    }
}
