package com.example.thdgk.graduateProject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thdgk on 2017-06-24.
 */

public class RegisterRequest extends StringRequest{

    final static private  String URL = "http://192.168.17.1:8080/UserRegister.php";

    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userGender, String userMajor, String userEmail, String userName, String userNum, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userGender", userGender);
        parameters.put("userMajor", userMajor);
        parameters.put("userEmail", userEmail);
        parameters.put("userName", userName);
        parameters.put("userNum", userNum);

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }

}
