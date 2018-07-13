package caronaufg.android.com.caronaufg.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String uid;
    private String displayName;
    private String email;
    private String password;

    public User() {
    }

    public String getDisplayName() { return this.displayName; }

    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getUid() {
        return uid;
    }

    public void setUid(String id) {
        this.uid = id;
    }

    public String getEmail() { return this.email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest =  MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes("UTF-8"));
        this.password = new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
