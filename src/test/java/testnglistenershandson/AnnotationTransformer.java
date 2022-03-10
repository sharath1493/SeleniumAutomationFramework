package testnglistenershandson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", "test1");
		m.put("enabled", false);
		m.put("count", 3);

		HashMap<String, Object> m1 = new HashMap<String, Object>();
		m1.put("name", "test2");
		m1.put("enabled", true);
		m1.put("count", 1);

		HashMap<String, Object> m2 = new HashMap<String, Object>();
		m2.put("name", "test3");
		m2.put("enabled", true);
		m2.put("count", 2);

		List<HashMap<String, Object>> l = new ArrayList<HashMap<String, Object>>();
		l.add(m);
		l.add(m1);
		l.add(m2);

		System.out.println(l);

		for (int i = 0; i < l.size(); i++) {

			if (testMethod.getName().equalsIgnoreCase(String.valueOf(l.get(i).get("name")))) {
				if ((boolean) l.get(i).get("enabled") == false) {
					annotation.setEnabled(false);
				} else {
					annotation.setInvocationCount((int) l.get(i).get("count"));
					annotation.setRetryAnalyzer(Retry.class);
				}
			}

		}

	}

}
