package com.blackey.bbs.global.shiro;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * jwt token
 *
 * @author kaven
 * @date 2017-05-20 13:22
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
