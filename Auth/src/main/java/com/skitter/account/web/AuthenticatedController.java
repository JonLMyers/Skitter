package com.skitter.account.web;

import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.session.Session;
import com.skitter.account.model.Authenticated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
