package gettingsomehandson;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.testng.annotations.Test;

public class AssertJDemo {

	@Test
	public void stringTest()
	{
		String s="BillyGail";

		Assertions.assertThat(s)
		.contains("Gail")
		.doesNotContain("Kelly")
		.hasSizeBetween(3, 15)
		.isNotEmpty()
		.isNotBlank()
		.isNotNull()
		.isEqualTo("BillyGail")
		.as("String do not have white spaces").containsWhitespaces()
		.as("Not one line").hasLineCount(1);

	}

	@Test
	public void intTest()
	{
		int i = -32;
		
		Assertions.assertThat(i)
		.isEqualTo(-32)
		.isPositive()
		.isCloseTo(16, Offset.offset(4));

	}

	@Test
	public void listTest()
	{

	}

	@Test
	public void mapTest()
	{

	}

	@Test
	public void classTest()
	{

	}

}
