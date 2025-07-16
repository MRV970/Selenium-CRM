package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {
	@Test
	public void runtimeParameterTest() {
		String Url=System.getProperty("url");
		String Browser=System.getProperty("browser");
		String Username=System.getProperty("username");
		String Password=System.getProperty("password");
		System.out.println("Env Data==> URL==>"+Url);
		System.out.println("Env Data==> Browser==>"+Browser);
		System.out.println("Env Data==> Username==>"+Username);
		System.out.println("Env Data==> Password==>"+Password);
	}

}
