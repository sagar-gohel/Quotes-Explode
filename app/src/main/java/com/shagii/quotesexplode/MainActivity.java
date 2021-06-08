package com.shagii.quotesexplode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView quoteList = findViewById(R.id.quoteList);
        quoteList.setLayoutManager(new LinearLayoutManager(this));

      /*This code use to check is it Quotes Look and View properly or not
        List<String> quotes = new ArrayList<>();
        quotes.add("Quote 1");
        quotes.add("Quote 2");
        quotes.add("Quote 3");
        quotes.add("Quote 4");
        quotes.add("Quote 5");
        quoteList.setAdapter(new QuotesAdapter(quotes,this));
*/
        quoteList.setAdapter(new QuotesAdapter(getQuotes(),this));

    }
    private List<String> getQuotes(){
        List<String> quotes = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getAssets().open("quotes.txt"), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                quotes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return quotes;
    }
}