package co.laptev.messagehandler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;

public class MessageHandler implements RequestHandler<Object, Map<String, Integer>> {
    private final static Logger logger = LoggerFactory.getLogger(MessageHandler.class);

    @Override
    public Map<String, Integer> handleRequest(Object value, Context context) {
        logger.info(value.toString());
        return Collections.singletonMap("statusCode", 200);
    }
}