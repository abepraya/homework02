package id.abypraya.challange02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import id.abypraya.challange02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listDataView;
    String JSON_STRING;
    Button btnDelete, btnEdit;
    String userId;
    ActivityMainBinding binding;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        btnEdit = findViewById(R.id.btnEdit);
//        btnDelete = findViewById(R.id.btnDelete);

        Intent receiveIntent = getIntent();
        userId = receiveIntent.getStringExtra(Configurations.EMPLOYEES_ID);

//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder promptDelete = new AlertDialog.Builder(MainActivity.this);
//                promptDelete.setMessage(Configurations.PROMPT_EDIT_DELETE);
//
//                promptDelete.setPositiveButton(Configurations.PROMPT_YES, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        deleteEmployee();
//                    }
//                });
//
//                promptDelete.setNegativeButton(Configurations.PROMPT_NO, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//
//                AlertDialog alertDialog = promptDelete.create();
//                alertDialog.show();
//            }
//        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        initView();


        listDataView = findViewById(R.id.listDataView);
        listDataView.setOnItemClickListener(this);

        getJSON();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_employees:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;
            case R.id.nav_customers:
                startActivity(new Intent(MainActivity.this, CustomerDataActivity.class));
                break;
            default:
                Toast.makeText(this, Configurations.CANNOT_ACCESS_PAGE, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //    private void deleteEmployee(){
//        class DeleteEmployee extends AsyncTask<Void, Void, String>{
//            ProgressDialog loading = new ProgressDialog(getApplicationContext());
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                loading = ProgressDialog.show(MainActivity.this, Configurations.REMOVE_DATA, Configurations.PLEASE_WAIT, false, false);
//
//            }
//
//            @Override
//            protected String doInBackground(Void... voids) {
//                RequestHandler handler = new RequestHandler();
//                String result = handler.sendGetDetailResponse(Configurations.URL_DELETE, userId);
//                return result;
//            }
//
//            @Override
//            protected void onPostExecute(String message) {
//                super.onPostExecute(message);
//                loading.dismiss();
//                displayData();
//            }
//        }
//
//        DeleteEmployee delEmployee = new DeleteEmployee();
//        delEmployee.execute();
//        startActivity(new Intent(MainActivity.this, MainActivity.class));
//    }

//    private void initView() {
//        setSupportActionBar(binding.toolbar);
//        binding.navView.setCheckedItem(R.id.nav_employees);
//
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawer,binding.toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close);
//
//        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
//
//        actionBarDrawerToggle.syncState();
//
//        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.nav_employees:
//                        getSupportActionBar().setTitle(Configurations.TITLE_EMPLOYEES);
//                        binding.drawer.closeDrawer(GravityCompat.START);
//                        Intent empIntent = new Intent(MainActivity.this, MainActivity.class);
//                        startActivity(empIntent);
//                        break;
//
//                    case R.id.nav_customers:
//                        getSupportActionBar().setTitle(Configurations.TITLE_CUSTOMER);
//                        binding.drawer.closeDrawer(GravityCompat.START);
//                        Intent custIntent = new Intent(MainActivity.this, CustomerDataActivity.class);
//                        startActivity(custIntent);
//                        break;
//
//                    default:
//                        binding.drawer.closeDrawer(GravityCompat.START);
//                        Toast.makeText(MainActivity.this, Configurations.CANNOT_ACCESS_PAGE, Toast.LENGTH_SHORT).show();
//                }
//                return true;
//            }
//        });
//
//    }



    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading = new ProgressDialog(getApplicationContext());
            Utility utilities = new Utility();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                loading = ProgressDialog.show(MainActivity.this, Configurations.COLLECT_DATA,Configurations.PLEASE_WAIT,false,false);
//                loading.setMessage(Configurations.PLEASE_WAIT);
//                loading.setTitle(Configurations.COLLECT_DATA);
//                loading.setCancelable(false);
//                loading.setIndeterminate(false);
//                loading.show();

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                    }
                };
                Handler handler = new Handler();
                handler.postDelayed(runnable, 10000);

//                utilities.setTimeout(() -> loading.show(), 10000);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler handler = new RequestHandler();
                String result = handler.sendGetResponse(Configurations.URL_GET_ALL);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
//                utilities.setTimeout(() -> loading.dismiss(), 10000);
//                loading.dismiss();
                JSON_STRING = message;
                Log.d("DATA_JSON: ",JSON_STRING);

                displayData();

            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void displayData() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> listData = new ArrayList<>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configurations.TAG_JSON_ARRAY);
            Log.d("DATA_JSON: ",JSON_STRING);

            for(int i = 0; i < result.length(); i++){
                JSONObject object = result.getJSONObject(i);
                String id = object.getString(Configurations.TAG_JSON_ID);
                String name = object.getString(Configurations.TAG_JSON_NAME);
                HashMap<String, String> employee = new HashMap<>();
                employee.put(Configurations.TAG_JSON_ID, id);
                employee.put(Configurations.TAG_JSON_NAME, name);

                //ubah format JSON menjadi ArrayList
                listData.add(employee);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                listData,
                R.layout.row,
                new String[]{Configurations.TAG_JSON_ID, Configurations.TAG_JSON_NAME, Configurations.TAG_JSON_TITLE},
                new int[]{R.id.txtIdUser, R.id.txtFullname, R.id.txtTitle}
                );
        listDataView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("onItemClick - CHECK");

        Intent myIntent = new Intent(MainActivity.this, DetailEmployeeActivity.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String empId = map.get(Configurations.TAG_JSON_ID).toString();
        myIntent.putExtra(Configurations.EMPLOYEES_ID, empId);
        startActivity(myIntent);
    }


}