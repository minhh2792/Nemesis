package nemesis;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

public class Log4JFilter extends AbstractFilter {

    private static final long serialVersionUID = -5594073755007974254L;

    private static Result validateMessage(Message message) {
        if (message == null) {
            return Result.NEUTRAL;
        }
        return validateMessage(message.getFormattedMessage());
    }

    private static Result validateMessage(String message) {
        return message.contains("papermc") && message.contains("/papermc")
                ? Result.DENY
                : Result.NEUTRAL;
    }

    @Override
    public Result filter(LogEvent event) {
        Message candidate = null;
        if (event != null) {
            candidate = event.getMessage();
        }
        return validateMessage(candidate);
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, Message msg, Throwable t) {
        return validateMessage(msg);
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String msg, Object... params) {
        return validateMessage(msg);
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, Object msg, Throwable t) {
        String candidate = null;
        if (msg != null) {
            candidate = msg.toString();
        }
        return validateMessage(candidate);
    }
}