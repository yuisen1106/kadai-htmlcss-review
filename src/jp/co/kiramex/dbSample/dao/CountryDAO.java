package jp.co.kiramex.dbSample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.kiramex.dbSample.entity.Country;
import jp.co.kiramex.dbSample.util.DatabaseManager;

public class CountryDAO {
	//データベース接続と結果取得のための変数
   private PreparedStatement pstmt;
   private ResultSet rs;

   //検索結果に合致するCountryオブジェクトリストを取得するメソッド
          //戻る型　　　　　　　　//メソッド名　　　　　　　　　　//引数
   public List<Country> getCountryFromName(String name){

	   //メソッドの結果として返すリスト List<データ型名> オブジェクト名 = new ArrayList<データ型名>();インターフェース/クラ
	   List<Country>results = new ArrayList<Country>();

	       try {
	    	   //ドライバを読み込みDBに接続
			Connection con =DatabaseManager.getConnection();

			//DBとやりとりする窓口
			String sql ="select * from country where Name= ?";
			pstmt= con.prepareStatement(sql);

			//select文の実行と結果を格納/代入
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();

			//結果を表示
			while(rs.next()) {
				//一件ずつCountry オブジェクトを生成して結果をつめる
				Country country =new Country();
				country.setName(rs.getString("Name"));
				country.setPopulation(rs.getInt("Population"));

			//リストに追加
				results.add(country);
			}




		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(pstmt !=null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				}
			DatabaseManager.close();
			}
	       return results;
		}


}


