package com.example.thdgk.graduateProject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thdgk on 2017-06-24.
 */

public class AddRequest extends StringRequest{

    final static private  String URL = "http://192.168.17.1:8080/CourseAdd.php";

    private Map<String, String> parameters;

    public AddRequest(String userID, String courseID, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("courseID", courseID);

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }

}
