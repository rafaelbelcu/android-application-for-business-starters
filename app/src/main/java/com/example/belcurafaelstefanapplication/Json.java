package com.example.belcurafaelstefanapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class Json extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        String jsonStr = getListData();
        try{
            ArrayList<HashMap<String, String>> taxesList = new ArrayList<>();
            ListView lv = (ListView) findViewById(R.id.list);
            JSONObject jObj = new JSONObject(jsonStr);
            JSONArray jsonArry = jObj.getJSONArray("taxes");
            for(int i=0;i<jsonArry.length();i++){
                HashMap<String,String> tax = new HashMap<>();
                JSONObject obj = jsonArry.getJSONObject(i);
                tax.put("name",obj.getString("name"));
                tax.put("value",obj.getString("value"));
                taxesList.add(tax);
            }
            ListAdapter adapter = new SimpleAdapter(Json.this, taxesList, R.layout.json_list,
                    new String[]{"name","value"}, new int[]{R.id.name, R.id.value});
            lv.setAdapter(adapter);
        }
        catch (JSONException ex){
            Log.e("JsonParser Example","unexpected JSON exception", ex);
        }
    }
    private String getListData() {
        String jsonValues = "{ \"taxes\" :[" +
                "{\"name\":\"Corporate tax rate\",\"value\":\"16%\"}" +
                ",{\"name\":\"For micro-companies with no employees\",\"value\":\"3%\"}" +
                ",{\"name\":\"For micro-companies with one or more employees\",\"value\":\"1%\"}" +
                ",{\"name\":\"VAT rate\",\"value\":\"19%\"}] }";
        return jsonValues;
    }
}
