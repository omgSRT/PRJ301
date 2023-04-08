/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThangND.DAO;

import java.io.Serializable;

/**
 *
 * @author omg
 */
public class RegistrationDTO implements Serializable{
    private String username;
    private String lastname;
    private String password;
    private boolean isAdmin;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String fullname, String password, boolean isAdmin) {
        this.username = username;
        this.lastname = fullname;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String fullname) {
        this.lastname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Registration{" + "username=" + username + ", fullname=" + lastname + ", password=" + password + ", isAdmin=" + isAdmin + '}';
    }
}
