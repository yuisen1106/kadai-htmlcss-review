package jp.co.kiramex.dbSample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResourcesSample01 {

	public static void main(String[] args) {
		// 3. データベース接続と結果取得のための変数宣言

		// 5.6 Select文の実行と結果の格納
		String sql= "SELECT * FROM country LIMIT 50";

		try {
			// 1.ドライバのクラスをjava上で読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");


			// 2．DBと接続する
         try(
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
					"root",
					"3Srntaityotodanjon"
					);

			// 4.DBとやりとりする窓口（Statement オブジェクト）の作成
			Statement stmt = con.createStatement();

			//Sql を実行
			ResultSet rs =stmt.executeQuery(sql);){




			// 7．結果を表示する
		while(rs.next()) {

	       // NAme列の値を取得
		  String name =rs.getString("Name");
		  //　取得した値を表示
		  System.out.println(name);
		}
			}
			// 8．接続を閉じる
		} catch (ClassNotFoundException e) {
			System.err.println("JDBCドライバのロードに失敗しました");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("データベースに異常が発生しました。");
			e.printStackTrace();
		}

	}

}
