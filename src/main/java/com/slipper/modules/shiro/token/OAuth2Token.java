package com.slipper.modules.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author gumingchen
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
