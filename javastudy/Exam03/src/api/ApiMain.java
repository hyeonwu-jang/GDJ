package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {

	public static void main(String[] args) {
		
		
		String ServiceKey = "tuKJQnWosgochz4Xdrz/EnE0fod1HOfyo0ZK7gAZMn7bUHdBQNpbTN6zksDAGe2KOWYJLpKMYuvDJWjBI5aAvQ==";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			urlBuilder.append("?ServiceKey=" + URLEncoder.encode(ServiceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021").append("&siDo=1100").append("&guGun=1125").append("&type=json").append("&numOfRows=10").append("&pageNo=1")
			.append("&acc_year=2021").append("&occrrnc_day_cd=4").append("&dth_dnv_cnt=0").append("&injpsn_cnt=1").append("&occrrnc_lc_sido_cd=1100").append("&occrrnc_lc_sgg_cd=1125");
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
			
		
		
//			
			
//			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath");
//			urlBuilder.append("?ServiceKey=" + URLEncoder.encode(ServiceKey, "UTF-8"));
//			urlBuilder.append("&searchYear=2021").append("&siDo=1100").append("&guGun=1125").append("&numOfRows=10").append("&pageNo=1").append("&resultCode=0000").append("&resultMsg=Success")
//					.append("&acc_year=2021").append("&occrrnc_dt=2019011622").append("&dght_cd=2").append("&occrrnc_day_cd=4").append("&dth_dnv_cnt=0").append("&injpsn_cnt=1").append("&se_dnv_cnt=1")
//					.append("&sl_dnv_cnt=0").append("&wnd_dnv_cnt=0").append("&occrrnc_lc_sido_cd=1100").append("&occrrnc_lc_sgg_cd=1125").append("&acc_ty_lclas_cd=02").append("&acc_ty_mlsfc_cd=23")
//					.append("&acc_ty_cd=23").append("&aslt_vtr_cd=01").append("&road_frm_lclas_cd=01").append("&road_frm_cd=04").append("&wrngdo_isrty_vhcty_l clas_cd=01").append("&dmge_isrty_vhcty_lcl as_cd=01")
//					.append("&occrrnc_lc_x_crd=943817").append("&occrrnc_lc_y_crd=1945678").append("&lo_crd=128.45275545").append("&lo_crd=128.45275545").append("&la_crd=35.94815032").append("&totalCount=19").append("&numOfRows=10").append("&pageNo=1");

		
		
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader br = null;
		StringBuilder sourceSb = new StringBuilder();
		
		String sbUrl = urlBuilder.toString();
		
		try {
			
			url = new URL(sbUrl);
			con = (HttpURLConnection)url.openConnection();
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
			
		} catch(IOException e) {
			System.out.println("API 접속 오류");
		}
			
		
		BufferedWriter bw = null;
		File file = new File("accident.txt");
		
		
		
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = br.readLine()) != null) {
				sourceSb.append(line);
			}
			
			br.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
			
			
			String source = sourceSb.toString();
			
		try {
			
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(source);
			bw.close();

		} catch(IOException e) {
			e.printStackTrace();
		}
		
		JSONObject obj = new JSONObject(source);
		JSONObject items = obj.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");
		
		List<JSONObject> sourceList = new ArrayList<JSONObject>();
		
		for(int i = 0; i < item.length(); i++) {
				
			JSONObject element = item.getJSONObject(i);
			
			String occrrncDt = element.getString("occrrnc_dt");
			String occrrncDayCd = element.getString("occrrnc_day_cd");
			int dthDnvCnt = element.getInt("dth_dnv_cnt");
			int injpsnCnt = element.getInt("injpsn_cnt");
			
			Accident accident = new Accident(occrrncDt, occrrncDayCd, dthDnvCnt, injpsnCnt);
			
//			sourceList = 
			
			System.out.println(accident);
			
		}
		
		
		
	}
		
	
}
