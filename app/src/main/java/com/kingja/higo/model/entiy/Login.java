package com.kingja.higo.model.entiy;


/**
 * Description:TODO
 * Create Time:2018/4/6 20:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Login {


    /**
     * token : 5sd565asd55645wdac
     * uid : 123
     * expires_in : 1532158889
     */

    private String token;
    private String uid;
    private int expires_in;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
