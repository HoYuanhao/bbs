package com.bbs.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
   private final String code;
   private final String kapcode;
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        code=request.getParameter("code");
        kapcode= (String) request.getSession().getAttribute("code");

    }

    public String getCode() {
        return code;
    }

    public String getKapcode() {
        return kapcode;
    }
}
