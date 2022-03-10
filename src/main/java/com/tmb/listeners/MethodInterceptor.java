package com.tmb.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.constants.FrameworkConstants;
import com.tmb.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> list = new ArrayList<>();
		List<Map<String, String>> testsmethods = ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheet());

		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < testsmethods.size(); j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(testsmethods.get(j).get("testname")))
				{
					if(testsmethods.get(j).get("runtest").equalsIgnoreCase("yes"))
					{
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(testsmethods.get(j).get("count")));
						methods.get(i).getMethod().setDescription(testsmethods.get(j).get("testdescription"));
						list.add(methods.get(i));
					}	

				}

			}
		}

		return list;
	}

}
