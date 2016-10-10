package site.zhangchuzhao.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/10/9 15:49
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class VelocitySample {
    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,"classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("hello.vm");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("name", "Velocity");
        List list =  new ArrayList();
        list.add("1");
        list.add("2");
        velocityContext.put("list", list);
        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext,stringWriter);
        System.out.println(stringWriter);
    }
}
