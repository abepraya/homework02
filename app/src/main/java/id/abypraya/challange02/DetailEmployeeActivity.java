package id.abypraya.challange02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import id.abypraya.challange02.databinding.ActivityDetailEmployeeBinding;

public class DetailEmployeeActivity extends AppCompatActivity {
    String userId;
    private EditText editUserId, editFullname, editSalary, editTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_employee);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle(Configurations.TITLE_DETAIL_EMPLOYEES);

        editUserId = findViewById(R.id.editUserId);
        editFullname = findViewById(R.id.editFullname);
        editSalary = findViewById(R.id.editSalary);
        editTitle = findViewById(R.id.editTitle);

        Intent receiveIntent = getIntent();
        userId = receiveIntent.getStringExtra(Configurations.EMPLOYEES_ID);
        editUserId.setText(userId);

        getJSON();
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading = new ProgressDialog(getApplicationContext());
            Utility utilities = new Utility();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading.setTitle(Configurations.COLLECT_EMP_DATA);
                loading.setMessage(Configurations.PLEASE_WAIT);
                loading.setCancelable(false);
                loading.setIndeterminate(false);

                utilities.setTimeout(() -> loading.show(), 10000);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler handler = new RequestHandler();
                String result = handler.sendGetDetailResponse(Configurations.URL_GET_DETAIL, userId);
                return result;
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loading.dismiss();

                displayDetailData(message);
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void displayDetailData(String dataJson) {
        try {
            String empName, empTitle, empSalary;

            JSONObject dataObject = new JSONObject(dataJson);
            JSONArray result = dataObject.getJSONArray(Configurations.TAG_JSON_ARRAY);
            JSONObject objects = result.getJSONObject(0);

            empName = objects.getString(Configurations.TAG_JSON_NAME);
            empTitle = objects.getString(Configurations.TAG_JSON_TITLE);
            empSalary = objects.getString(Configurations.TAG_JSON_SALARY);

            editFullname.setText(empName);
            editTitle.setText(empTitle);
            editSalary.setText(empSalary);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}