package temp.sonar;

import java.io.File;

/**
 * ClassName: SonarDemo2
 * Description:
 * data: 2020/12/07 22:32
 *
 * @author zhy
 * @version 1.0
 */
public class SonarDemo2 {

    public File newFile(String path) {
        return new File(path);
    }

    public boolean isMatch(String str, String pattern) {
        return str.matches(pattern);
    }

}
