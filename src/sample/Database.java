package sample;

import java.sql.*;

public class Database {

    private Connection conn;
    private Statement sm;
    private ResultSet rs;
    private PreparedStatement ps;

    public Database(String host, String db, String user, String pw) {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + db, user, pw);
            this.sm = this.conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Kapcsolódási hiba");
        }
    }
    public ResultSet query(String sql){
        try{
            this.rs=this.sm.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Adatbázis hiba");
        }
        return this.rs;
    }

    public void modify(String sql, String[]params){
        try{
            this.ps=this.conn.prepareStatement(sql);

            for(int i=0;i<params.length;i++){
                this.ps.setString(i+1, params[i]);
            }
            this.ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Adatbázis hiba");
        }
        close();
    }
    public void close(){
        try{
            if(this.rs!= null) this.rs.close();
            if(this.sm!=null) this.sm.close();
            if(this.conn!=null) this.conn.close();

        }catch(Exception e){
            System.out.println("Nem sikerült lezárni az adatbázis kapcsolatot.");

        }
    }

}