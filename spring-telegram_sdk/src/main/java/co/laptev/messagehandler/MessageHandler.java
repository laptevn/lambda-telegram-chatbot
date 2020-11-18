package co.laptev.messagehandler;

import co.laptev.messagehandler.entity.UpdateEvent;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.Map;

public class MessageHandler extends SpringBootRequestHandler<UpdateEvent, Map<String, Integer>> {
}