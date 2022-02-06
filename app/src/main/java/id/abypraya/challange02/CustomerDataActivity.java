package id.abypraya.challange02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import id.abypraya.challange02.databinding.ActivityCustomerDataBinding;

public class CustomerDataActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listDataView;
    String JSON_STRING;
    ActivityCustomerDataBinding binding;
    Toolbar toolbar;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listDataView = findViewById(R.id.listDataView);
        listDataView.setOnItemClickListener(this);

        getJSON();

    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading = new ProgressDialog(getApplicationContext());
            Utility utilities = new Utility();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                loading = ProgressDialog.show(CustomerDataActivity.this, "Collecting Data","Please Wait",false,false);
//                loading.setMessage(Configurations.PLEASE_WAIT);
//                loading.setTitle(Configurations.COLLECT_DATA);
//                loading.setCancelable(false);
//                loading.setIndeterminate(false);

//                utilities.setTimeout(() -> loading.show(), 10000);

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                    }
                };
                Handler handler = new Handler();
                handler.postDelayed(runnable, 10000);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler handler = new RequestHandler();
                String result = handler.sendGetResponse(Configurations.URL_GET_ALL_CUST);
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
                String name = object.getString(Configurations.TAG_JSON_FULLNAME);
                String email = object.getString(Configurations.TAG_JSON_EMAIL);

                HashMap<String, String> customer = new HashMap<>();
                customer.put(Configurations.TAG_JSON_ID, id);
                customer.put(Configurations.TAG_JSON_FULLNAME, name);
                customer.put(Configurations.TAG_JSON_EMAIL, email);

                //ubah format JSON menjadi ArrayList
                listData.add(customer);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                listData,
                R.layout.row,
                new String[]{Configurations.TAG_JSON_ID, Configurations.TAG_JSON_FULLNAME, Configurations.TAG_JSON_EMAIL},
                new int[]{R.id.txtIdUser, R.id.txtFullname, R.id.txtTitle}
        );
        listDataView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent myIntent = new Intent(CustomerDataActivity.this, DetailCustomerActivity.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String custId = map.get(Configurations.TAG_JSON_ID).toString();
        myIntent.putExtra(Configurations.CUSTOMER_ID, custId);
        startActivity(myIntent);
    }
}