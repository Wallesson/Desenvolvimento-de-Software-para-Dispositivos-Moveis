package com.example.projeto;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Random;

public class ActCadClientes extends AppCompatActivity {


    private Spinner spinner;
    private ArrayAdapter<String> adpTipoTelefone;
    GridView gridView;
    private Button btnPlay, btnStop;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cad_clientes);

        spinner = (Spinner) findViewById(R.id.spinner);

        adpTipoTelefone = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoTelefone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adpTipoTelefone);
        adpTipoTelefone.add("Pessoal");
        adpTipoTelefone.add("Comercial");

        gridView = findViewById(R.id.grid);
        gridView.setAdapter(new ImageAdapter(this));

        btnPlay = (Button) findViewById(R.id.play);
        btnStop = (Button) findViewById(R.id.stop);
        clickPlay();
        clickStop();
    }
    private void clickPlay(){
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(ActCadClientes.this, R.raw.05);
                    mediaPlayer.start();
                }
            }
        });
    }

    private void clickStop(){
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                }
            }
        });
    }


    public void selecionarBotao(View v){
        int x = new Random().nextInt(11);

        EditText texto = findViewById(R.id.result);
        texto.setText("Número Sorteado foi: "+x);
    }
}
class ImageAdapter extends BaseAdapter{

    Context context;
    ImageAdapter(Context con){
        context = con;
    }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv;
        if (convertView==null){
            imgv = new ImageView(context);
            imgv.setLayoutParams(new GridView.LayoutParams(100,100));
            imgv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgv.setPadding(10,10,10,10);
        }
        else {
            imgv = (ImageView) convertView;
        }
        imgv.setImageResource(img[position]);
        return imgv;
    }

    int img[] = {R.drawable.f1, R.drawable.f2,R.drawable.f3, R.drawable.f4};

}