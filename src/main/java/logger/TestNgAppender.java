package logger;


import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.testng.Reporter;

import java.io.Serializable;

/**
 * Created by Andrei_Muliarchyk on 4/10/2017.
 */
@Plugin(name = "TestNgAppender", category = "Core", elementType = "appender", printObject = true)
public class TestNgAppender extends AbstractAppender {

    protected TestNgAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout);
    }

    @Override
    public void append(LogEvent logEvent) {
        Reporter.log(new String(getLayout().toByteArray(logEvent))+"<br>");
    }

    @PluginFactory
    public static TestNgAppender createAppender(@PluginAttribute("name") String name,
                                                  @PluginElement("filter") Filter filter, @PluginElement("layout") Layout<LogEvent> layout) {
        if (name == null) {
            LOGGER.error("No name provided for TestNgAppender");
            return null;
        }

        if (layout == null) {
            LOGGER.error("No layout provided for TestNgAppender");
            return null;
        }
        return new TestNgAppender (name, filter, layout);
    }
}
