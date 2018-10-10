package com.example.store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView summary = findViewById(R.id.txtSummary);
        TextView total  = findViewById(R.id.txtotal);

        Intent intent = getIntent();
        String sum = intent.getStringExtra("summaryOrder");
        int tot = intent.getIntExtra("totalOrder", 0);

        summary.setText(sum);
        total.setText("Rp. "+tot);

        Button selesai = findViewById(R.id.btn_selesai);
        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selIntent = new Intent(Final.this,Selesai.class);
                startActivity(selIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.home){
            startActivity(new Intent(this, MainActivity.class));
        }
        return true;
    }
}
