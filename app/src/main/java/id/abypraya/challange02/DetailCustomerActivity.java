package id.abypraya.challange02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

public class DetailCustomerActivity extends AppCompatActivity {
    String userId;
    private EditText editCustId, editFullname, editAddress, editEmail, editAge, editPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_customer);

        editCustId = findViewById(R.id.editCustId);
        editFullname = findViewById(R.id.editFullName);
        editAddress = findViewById(R.id.editAddress);
        editEmail = findViewById(R.id.editEmail);
        editAge = findViewById(R.id.editAge);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);

        Intent receiveIntent = getIntent();
        userId = receiveIntent.getStringExtra(Configurations.CUSTOMER_ID);
        editCustId.setText(userId);

        getJSON();
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading = new ProgressDialog(getApplicationContext());
            Utility utilities = new Utility();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading.setTitle(Configurations.COLLECT_CUST_DATA);
                loading.setMessage(Configurations.PLEASE_WAIT);
                loading.setCancelable(false);
                loading.setIndeterminate(false);

                utilities.setTimeout(() -> loading.show(), 10000);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler handler = new RequestHandler();
                String result = handler.sendGetDetailResponse(Configurations.URL_GET_DETAIL_CUST, userId);
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
            String custName, custEmail, custAge, custAddress, custPhoneNumber;
            JSONObject dataObject = new JSONObject(dataJson);
            JSONArray result = dataObject.getJSONArray(Configurations.TAG_JSON_ARRAY);
            JSONObject objects = result.getJSONObject(0);

            custName = objects.getString(Configurations.TAG_JSON_FULLNAME);
            custEmail = objects.getString(Configurations.TAG_JSON_EMAIL);
            custAge = objects.getString(Configurations.TAG_JSON_AGE);
            custAddress = objects.getString(Configurations.TAG_JSON_ADDRESS);
            custPhoneNumber = objects.getString(Configurations.TAG_JSON_PHONENUMBER);

            editFullname.setText(custName);
            editPhoneNumber.setText(custPhoneNumber);
            editEmail.setText(custEmail);
            editAge.setText(custAge);
            editAddress.setText(custAddress);
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