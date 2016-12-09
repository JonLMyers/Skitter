package com.skitter.account.web;

import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;
import com.skitter.account.model.User;
import com.skitter.account.service.SecurityService;
import com.skitter.account.service.SecurityServiceImpl;
import com.skitter.account.service.UserService;
import com.skitter.account.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.HttpHeaders.USER_AGENT;

/**
 * Created by soren on 12/4/16.
 */

@RestController
public class AuthenticatedController {

    @RequestMapping("/isAuthenticated")
    public String isAuthenticated(@RequestParam(value="sessionId") String sessionId){

        HttpURLConnection connection = null;
        sessionId = "JSESSIONID=" + sessionId;

        try {
            URL url = new URL("http","localhost", 8080, "/autho");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Cookie", sessionId);
            int responseCode = con.getResponseCode();
            return "{Code, " + responseCode + "}";
        }
        catch(Exception ex){
            return "{Code, 6}";
        }

    }

    @RequestMapping("/autho")
    public String autho(){
        return "Success.";
    }

}
