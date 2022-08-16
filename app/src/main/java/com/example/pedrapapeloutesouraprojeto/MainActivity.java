package com.example.pedrapapeloutesouraprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){
        ImageView imagemResultado = findViewById(R.id.iv_resultado);
        TextView textoResultado = findViewById(R.id.tv_Resultado);

        int numero = new Random().nextInt(3); //0 1 2
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch(opcaoApp){
            case "Pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
                (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel")
        ){//App ganhador
            textoResultado.setText(R.string.txt_AppGanhador);
        }else if(
                (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura") ||
                (opcaoSelecionada == "Papel" && opcaoApp == "Pedra") ||
                (opcaoSelecionada == "Tesoura" && opcaoApp == "Papel")

        ){//Usuario ganhador
            textoResultado.setText(R.string.txt_UsuarioGanhador);
        }else{//Empate
            textoResultado.setText(R.string.txt_EmpateTecnico);
        }

        System.out.println("Item Clicado: " + opcaoApp);//test for visualization on Logcat

    }
}