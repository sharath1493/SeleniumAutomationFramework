package testnglistenershandson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> l = new ArrayList<IMethodInstance>();

		Map<String, String> m = new HashMap<>();

		m.put("name", "test1");
		m.put("count", "3");

		Map<String, String> m1 = new HashMap<>();

		m1.put("name", "test2");
		m1.put("count", "2");

		List<Map<String, String>> list = new ArrayList<>();
		list.add(m1);
		list.add(m);

		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (methods.get(i).getMethod().getMethodName().equals(list.get(j).get("name"))) {
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
					l.add(methods.get(i));
				}
			}
		}

		return l;
	}

}
