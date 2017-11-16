package com.edm.josue.catalogoquaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);

        //Oculta los menus de default de android y hace la app full screen
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

       //region EVENTOS DE BOTONES
        Button btnBreakfasts = (Button) findViewById(R.id.btnBreakfasts);
        btnBreakfasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipes.typeRecipe = Recipes.TypeRecipe.Breakfast;
                Intent intent = new Intent(getApplicationContext(), Recipes.class);
                startActivity(intent);
            }
        });

        Button btnDrinks = (Button) findViewById(R.id.btnDrinks);
        btnDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipes.typeRecipe = Recipes.TypeRecipe.Drinks;
                Intent intent = new Intent(getApplicationContext(), Recipes.class);
                startActivity(intent);
            }
        });

        Button btnBakery = (Button) findViewById(R.id.btnBakery);
        btnBakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipes.typeRecipe = Recipes.TypeRecipe.Bakery;
                Intent intent = new Intent(getApplicationContext(), Recipes.class);
                startActivity(intent);
            }
        });

        Button btnDesserts = (Button) findViewById(R.id.btnDesserts);
        btnDesserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipes.typeRecipe = Recipes.TypeRecipe.Desserts;
                Intent intent = new Intent(getApplicationContext(), Recipes.class);
                startActivity(intent);
            }
        });

        Button btnBenefits = (Button) findViewById(R.id.btnBenefits);
        btnBenefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Benefits.class);
                startActivity(intent);
            }
        });
        //endregion
    }
}
