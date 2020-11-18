package co.laptev.messagehandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
class TelegramClient extends TelegramLongPollingBot {
    private final String botToken;

    public TelegramClient(@Value("${botToken}") String botToken) {
        this.botToken = botToken;
    }

    public void sendMessage(long chatId, String messageContent) throws TelegramApiException {
        SendMessage message = new SendMessage().setChatId(chatId);
        message.setText(messageContent);

        execute(message);
    }

    @Override
    public void onUpdateReceived(Update update) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getBotUsername() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}