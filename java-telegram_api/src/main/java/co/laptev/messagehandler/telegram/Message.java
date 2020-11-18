package co.laptev.messagehandler.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Message {
    @JsonProperty("chat_id")
    private final long chatId;

    private final String text;
}