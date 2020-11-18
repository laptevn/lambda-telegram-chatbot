package co.laptev.messagehandler;

import co.laptev.messagehandler.entity.UpdateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

@Component
public class HandleMessageFunction implements Function<UpdateEvent, Map<String, Integer>> {
    private final static Logger logger = LoggerFactory.getLogger(HandleMessageFunction.class);

    private final TelegramClient telegramClient;

    public HandleMessageFunction(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    @Override
    public Map<String, Integer> apply(UpdateEvent value) {
        logger.info(value.toString());

        String message = String.format("Hey, you wrote: %s", value.getBody().getMessage().getText());
        try {
            telegramClient.sendMessage(value.getBody().getMessage().getFrom().getId(), message);
        } catch (TelegramApiException e) {
            logger.error("Cannot send a message", e);
        }

        return Collections.singletonMap("statusCode", 200);
    }
}