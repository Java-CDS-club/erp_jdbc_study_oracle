package erp_jdbc_study_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

    public static void main(String[] args) {
        // 1. JDBC 드라이버 로딩
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 2. 데이터베이스 커넥션 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl?useSSL=false", "kim", "rootroot");
            // 3. Statement 생성
            stmt = conn.createStatement();
            // 4. 쿼리 실행
            rs = stmt.executeQuery("select dept_name from Department");
            // 5. 쿼리 실행 결과 출력
            while(rs.next()) {
                 String name = rs.getString(1);
                 System.out.println(name);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            // 6. 사용한 Statement 종료
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
            // 7. 커넥션 종료
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }

}
