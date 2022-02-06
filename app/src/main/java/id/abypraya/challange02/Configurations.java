package id.abypraya.challange02;

public class Configurations {
    //API Employees
    public static final String URL_GET_ALL = "http://192.168.0.100/pegawai/tampilSemuaPgw.php";
    public static final String URL_GET_DETAIL = "http://192.168.0.100/pegawai/tampilPgw.php?id=";
    public static final String URL_ADD = "http://192.168.0.100/pegawai/tambahPgw.php";
    public static final String URL_UPDATE = "http://192.168.0.100/pegawai/updatePgw.php?id=";
    public static final String URL_DELETE = "http://192.168.0.100/pegawai/hapusPgw.php?id=";

    //API Customers
    public static final String URL_GET_ALL_CUST = "http://192.168.0.100/nasabah/tampilSemuaNsbh.php";
    public static final String URL_GET_DETAIL_CUST = "http://192.168.0.100/nasabah/tampilNsbh.php?id=";
    public static final String URL_ADD_CUST = "http://192.168.0.100/nasabah/tambahNsbh.php";
    public static final String URL_UPDATE_CUST = "http://192.168.0.100/nasabah/updateNsbh.php?id=";
    public static final String URL_DELETE_CUST = "http://192.168.0.100/nasabah/hapusNsbh.php?id=";

    //key & value JSON Employees
    public static final String KEY_EMPLOYEES_ID = "id";
    public static final String KEY_EMPLOYEES_NAME = "name";
    public static final String KEY_EMPLOYEES_TITLE = "desg";
    public static final String KEY_EMPLOYEES_SALARY = "salary";

    //key & value JSON Customers
    public static final String KEY_CUSTOMER_ID = "id";
    public static final String KEY_CUSTOMER_NAME = "fullname";
    public static final String KEY_CUSTOMER_EMAIL = "email";
    public static final String KEY_EMPLOYEES_AGE = "age";
    public static final String KEY_EMPLOYEES_ADDRESS = "address";
    public static final String KEY_EMPLOYEES_PHONENUMBER = "phonenumber";

    //flag JSON
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_JSON_ID = "id";
    public static final String TAG_JSON_NAME = "name";
    public static final String TAG_JSON_TITLE = "desg";
    public static final String TAG_JSON_SALARY = "salary";

    //flag Customer JSON
    public static final String TAG_JSON_FULLNAME = "fullname";
    public static final String TAG_JSON_EMAIL = "email";
    public static final String TAG_JSON_AGE = "age";
    public static final String TAG_JSON_PHONENUMBER = "phonenumber";
    public static final String TAG_JSON_ADDRESS = "address";

    //variable ID pegawai
    public static final String EMPLOYEES_ID = "emp_id"; //sebagai alias atau pembeda dengan ID yg lain

    //variable ID customers
    public static final String CUSTOMER_ID = "cust_id";

    //Constant title & message
    public static final String TITLE_DETAIL_EMPLOYEES = "Employee Detail";
    public static final String TITLE_EMPLOYEES = "Employee";
    public static final String TITLE_CUSTOMER = "Customer";
    public static final String TITLE_DETAIL_CUSTOMER = "Customer Detail";
    public static final String PLEASE_WAIT = "Please Wait";
    public static final String COLLECT_DATA = "Collecting Data";
    public static final String COLLECT_EMP_DATA = "Getting Employee Data";
    public static final String COLLECT_CUST_DATA = "Getting Customer Data";
    public static final String CANNOT_ACCESS_PAGE = "Can't Access The Page";
    public static final String REMOVE_DATA = "Removing Data";
    public static final String PROMPT_EDIT_DELETE = "Are You Sure?";
    public static final String PROMPT_YES = "Yes";
    public static final String PROMPT_NO = "No";
}
