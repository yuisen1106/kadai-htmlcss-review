package jp.co.kiramex.dbSample.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Review05 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/kadaidb?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"3Srntaityotodanjon");

			String sql = "SELECT * FROM person WHERE id=?";

			pstmt = con.prepareStatement(sql);

			System.out.println("idを入力してください>");
			int id = keyIn();
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println(name);
				System.out.println(age);
			}

		} catch (ClassNotFoundException e) {
			System.err.println("JDBCドライバのロードに失敗しました");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("データベースに異常が発生しました");
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
					System.err.println("ResultSetを閉じるときに異常が発生しました");
					e2.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.err.println("PreraredStatemrntを閉じるときに異常が発生しました");
					e.printStackTrace();
				}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("データベース切断時に異常が発生しました");
				e.printStackTrace();
			}
		}
	}

	private static int keyIn() {
		String id = null;
		try {
			BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
			id = key.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int result = Integer.parseInt(id);
		return result;
	}
}
