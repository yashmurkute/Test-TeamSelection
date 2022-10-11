package testCases;

import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import utils.UtilityMethods;

public class RCBTeamSelection {


	@Test
	public void testforForigenPlayer() {

		try {


			/* Creating Object of int for validation */
			int flag = 0;

			/* Store file path */
			String filePath = System.getProperty("user.dir")+"\\testdata\\RoyalChallengersBangalore.json";

			/* read the json file */
			Object obj = UtilityMethods.readJSONFile(filePath);

			/* Creating object of json */
			JSONObject jsonObject =  (JSONObject) obj;

			/* Creating object of JSONArray for all the players */
			JSONArray cars = (JSONArray) jsonObject.get("player");

			/* iterating through the all the details of the player */
			for(int i=0;i<cars.size();i++) {
				JSONObject  data = (JSONObject) cars.get(i);
				Map<?, ?> mp = data;
				Object con = mp.get("country");
				Object role = mp.get("role");

				/* Validation for the foreign players */
				if (con.equals("India") != true ) {
					ArrayList<String> al = new ArrayList<String>();
					al.add((String) mp.get("name"));
					flag = flag + 1 ;	
					System.out.println(mp.get("name")+ " is a forigen player");
				}else {
					System.out.println(mp.get("name")+" is a Indian player");
				}
			}

			System.out.println();

			/* Validation for the foreign players */
			if (flag >= 4) {
				System.out.println("Team has atleast 4 foreign player");
				System.out.println();
			}

		}catch(Exception e) {
			System.out.println("Exception occure while execution of test");
		}
	}

	@Test
	public void testforWicketKeeper() {

		try {


			/* Creating Object of int for validation */
			int flag = 0;

			/* Store file path */
			String filePath = System.getProperty("user.dir")+"\\testdata\\RoyalChallengersBangalore.json";

			/* read the json file */
			Object obj = UtilityMethods.readJSONFile(filePath);

			/* Creating object of json */
			JSONObject jsonObject =  (JSONObject) obj;

			/* Creating object of JSONArray for all the players */
			JSONArray cars = (JSONArray) jsonObject.get("player");

			/* iterating through the all the details of the player */
			for(int i=0;i<cars.size();i++) {
				JSONObject  data = (JSONObject) cars.get(i);
				Map<?, ?> mp = data;
				Object role = mp.get("role");

				/* Validation for Wicket keeper */
				if(role.equals("Wicket-keeper") == true ) {
					flag = flag + 1 ;
					System.out.println(mp.get("name"));
				}
			}

			/* Validation for Wicket-keeper */
			if (flag >= 1) {
				System.out.println("Team has at least one wicket keeper");
			}
		}catch(Exception e) {
			System.out.println("Exception occure while execution of test");
		}
	}
}