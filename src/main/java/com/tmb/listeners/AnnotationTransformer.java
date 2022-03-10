package com.tmb.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.tmb.constants.FrameworkConstants;
import com.tmb.utils.DataProvideUtils;

public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProvideUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
		//FrameworkConstants.setMethodName(testMethod.getName());
		System.out.println(testMethod.getName());
	}

	

}
