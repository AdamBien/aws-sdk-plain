package airhacks;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.services.sts.StsClient;

/**
 *
 * @author airhacks.com
 */
interface App {

    static void main(String... args) {
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
