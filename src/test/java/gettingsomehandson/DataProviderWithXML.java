package gettingsomehandson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class DataProviderWithXML {

	@Test
	public void mytest2() {

		ObjectMapper o = new XmlMapper();
		FileInputStream f;
		try {
			f = new FileInputStream("C:\\Users\\shara\\Desktop\\xmlsample.xml");
			TypeReference<List<Book>> l = new TypeReference<List<Book>>() {
			};

			List<Book> b = o.readValue(f, l);

			for (Book k : b) {
				System.out.println(k.getAuthor());
				System.out.println(k.getLang());
				System.out.println(k.getLang());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
