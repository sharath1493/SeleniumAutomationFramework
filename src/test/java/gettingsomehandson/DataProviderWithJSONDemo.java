package gettingsomehandson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviderWithJSONDemo {

	@Test(dataProvider = "jsondata")
	public void jsondptest(HashMap<String, Object> m) {

		m.forEach((k, v) -> System.out.println(k + " " + v));
	}

	@DataProvider
	public Object[] jsondata() throws StreamReadException, DatabindException, FileNotFoundException, IOException {

		// Reading data from json file and putting in an HashMap
		HashMap<String, Object> map = new ObjectMapper().readValue(
				new FileInputStream("C:\\Users\\shara\\Desktop\\jsonsample.json"),
				new TypeReference<HashMap<String, Object>>() {
				});

		HashMap<String, Object> map2 = new ObjectMapper().readValue(
				new FileInputStream("C:\\Users\\shara\\Desktop\\jsonsample1.json"),
				new TypeReference<HashMap<String, Object>>() {
				});

		// Can this way as well. But better to do the way mentioned above

		HashMap<String, Object> map3 = new ObjectMapper().readValue(
				new FileInputStream("C:\\Users\\shara\\Desktop\\jsonsample1.json"),
				HashMap.class);

		return new Object[] { map, map2 };

	}

}
