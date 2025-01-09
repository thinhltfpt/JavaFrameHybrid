package commons;

import java.io.File;

public class GlobalConstants {
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
    public static final String REPORTING_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator + "reportNGImage" + File.separator;
    public static final  long SHORT_TIMEOUT = 5;
    public static final  long LONG_TIMEOUT = 30;
    public static final String ADMIN_USER_ORANGE = "Admin";
    public static final String ADMIN_PASSWORD_ORANGE = "admin123";
    public static final String BROWSER_LOG = RELATIVE_PROJECT_PATH + File.separator + "browserLogs" + File.separator;
}
