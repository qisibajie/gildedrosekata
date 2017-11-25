package com.oocl.arp.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by on 10/30/2017.
 */
public class ConnectionTool {
    public static void closeConnection(Connection con, PreparedStatement pre, ResultSet result) {
        try {
            if (result != null)
                result.close();
            if (pre != null)
                pre.close();
            if (con != null)
                con.close();
            System.out.println("数据库连接已关闭！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
