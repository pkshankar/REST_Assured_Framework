package com.qa.gorest.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import com.qa.gorest.path.FilePath;

public class TestBase {

	public Properties prop;

	public TestBase() {

		try {

			FileInputStream fis = new FileInputStream(FilePath.CONFIG_FILE_PATH);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
