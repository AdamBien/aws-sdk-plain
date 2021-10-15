package airhacks;

import java.util.Arrays;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.services.ec2.model.Tag;
import software.amazon.awssdk.services.sts.StsClient;

/**
 *
 * @author airhacks.com
 */
public class SDKApp {

    public static void main(String[] args) {
        var appName = "aws-sdk-plain";
        var project = Tag.builder().key("project").value("airhacks").build();
        var environment = Tag.builder().key("environment").value("test").build();
        var application = Tag.builder().key("application").value(appName).build();
        var tags = Arrays.asList(project, environment, application);

        //current accessKey
        var credentialsProvider = DefaultCredentialsProvider.builder().build();
        var accessKey = credentialsProvider.resolveCredentials().accessKeyId();
        System.out.println(accessKey);

        //who am I?
        var response = StsClient.create().getCallerIdentity();
        var arn = response.arn();
        System.out.println(arn);


    }
}
