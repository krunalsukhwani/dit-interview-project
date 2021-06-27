package example.ditinterviewproject.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import example.ditinterviewproject.bean.*;
import example.ditinterviewproject.config.JwtTokenUtil;
import example.ditinterviewproject.service.DitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class DitController {
    @Autowired
    DitService ditService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    String token=null;

    @GetMapping("/hello")
    public String hello(ResponseBean respBean) {
        respBean.setSuccess("true");
        respBean.setError(null);
        respBean.setData("Hello, World!");
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(respBean);
    }

    @PostMapping(value = "/create",consumes="application/json",produces ="application/json")
    public CreateResponseBean create(@RequestBody UserBean user)
    {
        return ditService.create(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUser_name(), authenticationRequest.getPassword());

        final UserDetails userDetails = ditService
                .loadUserByUsername(authenticationRequest.getUser_name());

//        final String token = jwtTokenUtil.generateToken(userDetails);
        token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/authenticate")
    public AuthenticateResponseBean userauthenticate() {
        AuthenticateResponseBean respBean = new AuthenticateResponseBean();
        AuthDataResponse dataresp = new AuthDataResponse();
        JwtResponse response=new JwtResponse(token);
        if(response.getToken()!=null)
        {
            dataresp.setAuthorized("true");
            respBean.setSuccess("true");
            respBean.setData(dataresp);
            respBean.setError(null);
        }else{
            dataresp.setAuthorized("false");
            respBean.setSuccess("false");
            respBean.setData(dataresp);
            respBean.setError("true");
        }
        return respBean;
    }
}