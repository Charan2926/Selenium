package jupiterGeneric;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String fetchdatafromFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantPaths.filepath);
		Properties Pobj= new Properties();
		Pobj.load(fis);
		String url=Pobj.getProperty(key);
		return url;
		
		
	}

}
