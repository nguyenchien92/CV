package winds.com.ibike;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import winds.com.ibike.ViewController.Accessory.AccessoryFragment;
import winds.com.ibike.ViewController.History.HistoryFragment;
import winds.com.ibike.ViewController.Info.InfoFragment;
import winds.com.ibike.ViewController.Service.ServiceFragment;
import winds.com.ibike.ViewController.Utils.AppConfig;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Spinner spinner;
    private List<String> listBike = new ArrayList<>();
    private NavigationView navigationView;
    private View headerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        AccessoryFragment accessoryFragment = new AccessoryFragment();
        // Thay thế vào vị trí của frame layout
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, accessoryFragment).commit();



        navigationView = findViewById(R.id.nav_view);
        headerLayout = navigationView.getHeaderView(0);

        String customerName = AppConfig.getValue(this,"iBike","customerName",MODE_PRIVATE);


        TextView tvCustomerName = headerLayout.findViewById(R.id.tv_customer_name);
        tvCustomerName.setText(customerName);

        //add item on Spinner
        addItemOnSpinner();
        addListenerOnSpinnerItemSelection();
    }

    private void addListenerOnSpinnerItemSelection() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, listBike.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void addItemOnSpinner() {

        spinner = headerLayout.findViewById(R.id.sp_list_bike_id);

        SharedPreferences sharedPreferences = getSharedPreferences("iBike", MODE_PRIVATE);
        String data = sharedPreferences.getString("bikeId", null);

        listBike.add(data);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listBike);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_service: {
                // Tạo ra một fragment
                ServiceFragment serviceFragment = new ServiceFragment();
                // Thay thế vào vị trí của frame layout
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, serviceFragment).commit();

                break;
            }
            case R.id.nav_history: {
                HistoryFragment historyFragment = new HistoryFragment();
                // Thay thế vào vị trí của frame layout
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, historyFragment).commit();
                break;
            }
            case R.id.nav_accessory: {
                AccessoryFragment accessoryFragment = new AccessoryFragment();
                // Thay thế vào vị trí của frame layout
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, accessoryFragment).commit();
                break;
            }
            case R.id.nav_info: {
                InfoFragment infoFragment = new InfoFragment();
                // Thay thế vào vị trí của frame layout
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, infoFragment).commit();
                break;
            }
            case R.id.nav_logout: {
                AppConfig.setIsLogin(this, false, MODE_PRIVATE);

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
            default: {

                break;
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
