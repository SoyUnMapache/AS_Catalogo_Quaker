package com.edm.josue.catalogoquaker;

import android.content.Intent;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class Recipes extends AppCompatActivity {

    //region TIPO DE RECETA
    enum TypeRecipe {
        Breakfast, Drinks, Bakery, Desserts
    }

    public static TypeRecipe typeRecipe;
    //endregion

    //region PAGINAS DE RECETAS

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments;
        List<String> titles;

        int totalPages;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            titles = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1, "position" + 1);
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            // Show total pages.
            return fragments.size();
        }

        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    public SectionsPagerAdapter mSectionsPagerAdapter;
    public ViewPager mViewPager;
    //endregion

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_recipes);

        //Oculta los menus de default de android y hace la app full screen
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(1, "UNO"), "UNO");
        mSectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(2, "DOS"), "DOS");
        mViewPager = (ViewPager) findViewById(R.id.PageContainer);

        //Checa que tipo de recetas mostrará
        switch (typeRecipe) {
            case Breakfast:
                txtTitle.setText("DESAYUNOS");
                mSectionsPagerAdapter.totalPages = 2;
                break;
            case Drinks:
                txtTitle.setText("BEBIDAS");
                mSectionsPagerAdapter.totalPages = 3;
                break;
            case Bakery:
                txtTitle.setText("PANADERIA");
                mSectionsPagerAdapter.totalPages = 1;
                break;
            case Desserts:
                txtTitle.setText("POSTRES");
                mSectionsPagerAdapter.totalPages = 1;
                break;
        }

        Button btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
            }
        });

        mViewPager.setAdapter(mSectionsPagerAdapter);

        switch (typeRecipe) {
            case Breakfast:
                break;
            case Drinks:
                break;
            case Bakery:
                break;
            case Desserts:
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        private String nameFragment;
        private int sectionNumber;

        private static final String ARG_SECTION_NUMBER = "section_number";

        Button Recipe1;
        Button Recipe2;
        Button Recipe3;
        Button Recipe4;
        Button Recipe5;
        Button Recipe6;
        Button Recipe7;
        Button Recipe8;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, String titleFragment) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString("TITLE_FRAGMENT", titleFragment);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            nameFragment = getArguments().getString("TITLE_FRAGMENT");
            sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_page, container, false);
            Recipe1 = (Button) rootView.findViewById(R.id.btnRecipe1);
            Recipe2 = (Button) rootView.findViewById(R.id.btnRecipe2);
            Recipe3 = (Button) rootView.findViewById(R.id.btnRecipe3);
            Recipe4 = (Button) rootView.findViewById(R.id.btnRecipe4);
            Recipe5 = (Button) rootView.findViewById(R.id.btnRecipe5);
            Recipe6 = (Button) rootView.findViewById(R.id.btnRecipe6);
            Recipe7 = (Button) rootView.findViewById(R.id.btnRecipe7);
            Recipe8 = (Button) rootView.findViewById(R.id.btnRecipe8);

            if(sectionNumber == 2){
                Recipe1.setBackgroundResource(R.drawable.btn_atole);
            } else {
                Recipe1.setBackgroundResource(R.drawable.btn_avena_frambuesas);
            }
            Recipe1.setOnClickListener(this);
            return rootView;
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btnRecipe1:
                    Toast.makeText(getActivity(), "Button1 " + nameFragment, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
