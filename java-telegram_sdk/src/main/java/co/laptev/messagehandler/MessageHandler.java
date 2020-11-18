package co.laptev.messagehandler;

import co.laptev.messagehandler.entity.UpdateEvent;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Collections;
import java.util.Map;

public class MessageHandler implements RequestHandler<UpdateEvent, Map<String, Integer>> {
    private final static Logger logger = LoggerFactory.getLogger(MessageHandler.class);

    private final TelegramClient telegramClient;

    public MessageHandler() {
        this.telegramClient = new TelegramClient(getEnvVariable("botToken"));
    }

     @Override
    public Map<String, Integer> handleRequest(UpdateEvent value, Context context) {
        logger.info(value.toString());

         String message = String.format("Hey, you wrote: %s", value.getBody().getMessage().getText());
         try {
             telegramClient.sendMessage(value.getBody().getMessage().getFrom().getId(), message);
         } catch (TelegramApiException e) {
             logger.error("Cannot send a message", e);
         }

        return Collections.singletonMap("statusCode", 200);
    }

    private static String getEnvVariable(String key) {
        String value = System.getenv(key);
        if (value == null) {
            String errorMessage = String.format("'%s' environment variable is not set", key);
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        return value;
    }
}