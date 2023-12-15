import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;

import java.io.File;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        // Set the path to your project directory
        String projectDirectory = "D:\\IdeaProjects\\A21_ReportAutomation";
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File("D:\\apache-maven-3.9.3")); // Set your Maven home directory

        invoker.setWorkingDirectory(new File(projectDirectory));

        InvocationRequest request = new DefaultInvocationRequest();
        request.setGoals(List.of("clean", "install"));

        try
        {
            invoker.execute(request);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}