package com.mateuslima.mvpcats.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mateuslima.mvpcats.MvpApplication;
import com.mateuslima.mvpcats.R;
import com.mateuslima.mvpcats.adapter.CatsAdapter;
import com.mateuslima.mvpcats.data.db.model.User;
import com.mateuslima.mvpcats.data.network.result.CatResult;
import com.mateuslima.mvpcats.di.component.DaggerActivityComponent;
import com.mateuslima.mvpcats.di.module.ActivityModule;
import com.mateuslima.mvpcats.ui.login.LoginActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView recyclerCats;
    private FloatingActionButton fabReload;
    private Toolbar toolbar;
    @Inject MainPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        setSupportActionBar(toolbar);

        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build().inject(this);

        presenter.retrieveCats(18); // quantity of cats you want to retrieve from database

        fabReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.retrieveCats(18);
            }
        });
    }

    private void initUi(){
        recyclerCats = findViewById(R.id.recycler_cats);
        toolbar = findViewById(R.id.toolbar);
        fabReload = findViewById(R.id.fabReload);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_logout) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showCats(List<CatResult> catResultList) {
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        CatsAdapter adapter = new CatsAdapter(catResultList);
        recyclerCats.setLayoutManager(layoutManager);
        recyclerCats.setAdapter(adapter);
        recyclerCats.setHasFixedSize(true);
    }

    @Override
    public void errorRetrieveCats(String error) {
        Toast.makeText(MainActivity.this, "error: "+error, Toast.LENGTH_SHORT).show();
    }
}
