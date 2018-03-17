package com.example.korisnik.imdbapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button search_button;
    private EditText search_edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_button = findViewById(R.id.search_button);
        search_edit_text = findViewById(R.id.search_edit_text);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,DisplayMovies.class);
                i.putExtra("movie",search_edit_text.getText().toString());
                startActivity(i);
            }
        });
    }
}
