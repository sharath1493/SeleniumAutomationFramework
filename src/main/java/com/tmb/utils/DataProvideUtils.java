package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tmb.constants.FrameworkConstants;

public final class DataProvideUtils {

	private static List<Map<String, String>> testdata = new ArrayList<>();

	@DataProvider(parallel = false)
	public static Object[] getData(Method m) {

		if (testdata.isEmpty()) {
			testdata = ExcelUtils.getTestDetails(FrameworkConstants.getTestDataIterationSheet());
		}
		String testname = m.getName();

		List<Map<String, String>> l = new ArrayList<>();

		for (int i = 0; i < testdata.size(); i++) {
			if (testdata.get(i).get("testname").equalsIgnoreCase(testname)
					&& testdata.get(i).get("execute").equalsIgnoreCase("yes")) {
				l.add(testdata.get(i));

			}
		}

		return l.toArray();

	}
}
