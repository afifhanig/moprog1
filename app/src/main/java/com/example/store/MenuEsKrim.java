package com.example.store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MenuEsKrim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_es_krim);

        final CheckBox van = findViewById(R.id.vanilla);
        final CheckBox green = findViewById(R.id.greentea);
        final CheckBox moc = findViewById(R.id.mocca);
        final CheckBox rg = findViewById(R.id.rotigoreng);
        final CheckBox rb = findViewById(R.id.rotibakar);

        final EditText jml_van = findViewById(R.id.jml_vanilla);
        final EditText jml_green = findViewById(R.id.jml_greentea);
        final EditText jml_moc = findViewById(R.id.jml_mocca);
        final EditText jml_rg = findViewById(R.id.jml_rotigoreng);
        final EditText jml_rb = findViewById(R.id.jml_rotibakar);

        final int hrg_van = 4000;
        final int hrg_green = 5000;
        final int hrg_moc = 3000;
        final int hrg_rg = 10000;
        final int hrg_rb = 20000;

        Button btn_pesan = findViewById(R.id.btn_pesan);

        btn_pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String sumOrder  = "";
               int totOrder = 0;
               if(van.isChecked()){
                   String txt = "Es Krim Vanilla";
                   int jml = Integer.parseInt(String.valueOf(jml_van.getText()));
                   int calc = jml*hrg_van;
                   sumOrder += txt+" "+jml+"\n";
                   totOrder += calc;
               }
                if(green.isChecked()){
                    String txt = "Es Krim Greentea";
                    int jml = Integer.parseInt(String.valueOf(jml_green.getText()));
                    int calc = jml*hrg_green;
                    sumOrder += txt+" "+jml+"\n";
                    totOrder += calc;
                }
                if(moc.isChecked()){
                    String txt = "Es Krim Mocca";
                    int jml = Integer.parseInt(String.valueOf(jml_moc.getText()));
                    int calc = jml*hrg_moc;
                    sumOrder += txt+" "+jml+"\n";
                    totOrder += calc;
                }
                if(rb.isChecked()){
                    String txt = "Roti Bakar";
                    int jml = Integer.parseInt(String.valueOf(jml_rb.getText()));
                    int calc = jml*hrg_rb;
                    sumOrder += txt+" "+jml+"\n";
                    totOrder += calc;
                }
                if(rg.isChecked()){
                    String txt = "Roti Goreng";
                    int jml = Integer.parseInt(String.valueOf(jml_rg.getText()));
                    int calc = jml*hrg_rg;
                    sumOrder += txt+" "+jml+"\n";
                    totOrder += calc;
                }

                Intent myIntent = new Intent(MenuEsKrim.this,Final.class);
                myIntent.putExtra("summaryOrder",sumOrder);
                myIntent.putExtra("totalOrder", totOrder);
                startActivity(myIntent);


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
