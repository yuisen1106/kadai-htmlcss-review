package jp.co.kiramex.dbSample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
//データベース接続と結果取得のための変数
	private static Connection con;

	//データベース接続を行うメソッド  getConnection
public static  Connection getConnection()throws SQLException, ClassNotFoundException{
	//ドライバのクラスをjava上で読み込む
	Class.forName("com.mysql.cj.jdbc.Driver");
	//DBと接続する
	con=DriverManager.getConnection(
		"jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
		"root",

			"3Srntaityotodanjon");
	     return con;


}

     //データベースを接続を閉じるメソッド
   public static void close() {
	   //　接続をとじる
	   if(con != null) {
		   try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	   }
   }

}