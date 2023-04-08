/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThangND.DAO;

import ThangND.database.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.Registration;

/**
 *
 * @author omg
 */
public class RegistrationDAO implements Serializable {

    public static boolean checkLogin(String username, String password) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select *"
                        + "from Registration\n"
                        + "where username LIKE ? AND password LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public static boolean deleteRegistration(String username) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        int table;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "delete from Registration\n"
                        + "where username LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                table = stm.executeUpdate();
                if (table == 1) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public static boolean updateRegistration(String username, String lastname, String password, boolean isAdmin) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        int table;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "update Registration\n"
                        + "set lastname = ?, password = ?, isAdmin = ?\n"
                        + "where username LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, lastname);
                stm.setString(2, password);
                stm.setBoolean(3, isAdmin);
                stm.setString(4, username);
                table = stm.executeUpdate();
                if (table >= 1) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public static RegistrationDTO getRegistration(String username) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        RegistrationDTO reg = null;
        if(username == null || username.trim().equalsIgnoreCase("")){
            reg = new RegistrationDTO();
            return reg;
        }

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select username, lastname, password, isAdmin\n"
                        + "from Registration\n"
                        + "where username LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        username = rs.getString("username");
                        String lastname = rs.getString("lastname");
                        String password = rs.getString("password");
                        boolean isAdmin = rs.getBoolean("isAdmin");
                        reg = new RegistrationDTO(username, lastname, password, isAdmin);
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return reg;
    }

    public static ArrayList<RegistrationDTO> searchByLastName(String search) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<RegistrationDTO> list = null;
        RegistrationDTO reg = null;
        if(search == null || search.trim().equals("")){
            return list;
        }
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select username, lastname, password, isAdmin\n"
                        + "from Registration\n"
                        + "where lastname LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        String username = rs.getString("username");
                        String lastname = rs.getString("lastname");
                        String password = rs.getString("password");
                        boolean isAdmin = rs.getBoolean("isAdmin");
                        reg = new RegistrationDTO(username, lastname, password, isAdmin);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(reg);
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public static boolean createRegistration(String username, String lastname, String password, String confirm) throws Exception {
        if (getRegistration(username) != null || password == null || !password.equalsIgnoreCase(confirm)) {
            return false;
        } else {
            Connection con = null;
            PreparedStatement stm = null;
            int table = 0;

            try {
                con = DBUtils.makeConnection();
                if (con != null) {
                    String sql = "insert into Registration\n"
                            + "values(?, ?, ?, 0)";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, username);
                    stm.setString(2, lastname);
                    stm.setString(3, password);
                    table = stm.executeUpdate();
                    if (table >= 1) {
                        return true;
                    }
                }
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        }

        return false;
    }
}
