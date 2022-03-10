package com.tmb.gettingjavainhands;

import org.assertj.core.util.Arrays;

public class EnumRunner {

	public static void main(String[] args) {

		System.out.println(DefectSeverity.CRITICAL);

		System.out.println(DefectSeverity.CRITICAL.getClass());

		System.out.println(DefectSeverity.CRITICAL.toString());

		System.out.println(DefectSeverity.CRITICAL.toString().getClass());

		System.out.println(DefectSeverity.LOW.ordinal());

		Arrays.asList(DefectSeverity.values()).forEach(System.out::println);

		DefectSeverity v = DefectSeverity.valueOf("UNDEFINED");

		// System.out.println(v);

		switch (v) {
		case CRITICAL:
			System.out.println("Defect is Critical");
			break;
		case HIGH:
			System.out.println("Defect is High");
			break;
		case MEDIUM:
			System.out.println("Defect is Medium");
			break;
		case LOW:
			System.out.println("Defect is Low");
			break;

		default:
			System.out.println("Defects is Undefined");
			break;

		}
		
		

	}

}
