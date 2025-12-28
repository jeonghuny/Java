package C09NetWorking;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class C03DbConnect {
    public static void main(String[] args) throws SQLException {
//        mysql드라이버 별도 다운로드 및 추가
    // java mysql driver download // SSL은 보안 기술
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String password = "test1234";
        Connection myConnection = DriverManager.getConnection(url,userName,password);
        System.out.println(myConnection);

//        Statement 객체에 쿼리를 담아 db에 전송
        Statement st = myConnection.createStatement();
        ResultSet result = st.executeQuery("select * from post");
//        next()를 통해 데이터를 1행씩 read
        while(result.next()){
            System.out.println(result.getInt("id"));
            System.out.println(result.getString("title"));
            System.out.println(result.getString("contents"));
        }
    }
}

/*
java -> db
 1) jdbc 2) mybatis 3) jpa

 */
