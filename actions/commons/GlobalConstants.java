package commons;

import java.io.File;

public class GlobalConstants {
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
    public static final  long SHORT_TIMEOUT = 10;
    public static final  long LONG_TIMEOUT = 30;
}
