package airhacks;

import java.util.Arrays;

import software.amazon.awssdk.services.ec2.model.Tag;

/**
 *
 * @author airhacks.com
 */
public class SDKApp {

    public static void main(String[] args) {
        var appName = "${PROJECT_NAME}";
        var project = Tag.builder().key("project").value("airhacks").build();
        var environment = Tag.builder().key("environment").value("test").build();
        var application = Tag.builder().key("application").value(appName).build();
        var tags = Arrays.asList(project, environment, application);

    }
}
