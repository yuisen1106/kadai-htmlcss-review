package jp.co.kiramex.dbSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import jp.co.kiramex.dbSample.dao.CountryDAO;
import jp.co.kiramex.dbSample.entity.Country;

public class DbConnectSample06 {

	public static void main(String[] args) {
		//country クラスにアクセスするためCountryDAOをインスタンス化
		CountryDAO dao= new CountryDAO();

		//検索キーワード入力
		System.out.print("検索キーワードを入力してください");
		String name =keyIn();

		//入力された値を引数に指定し　検索処理を実行しLIｓｔオブジェクトを取得
		List<Country> list=dao.getCountryFromName(name);


		//取得したいlistオブジェクトを順番にとりだし出力
		for(Country item : list) {
			System.out.println(item.getName());
            System.out.println(item.getPopulation());

		}

	}
        private static String keyIn() {
        	String line = null;
        	try {
        	BufferedReader key =new BufferedReader(new InputStreamReader(System.in));

				line =key.readLine();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
        	return line;

        }
}
