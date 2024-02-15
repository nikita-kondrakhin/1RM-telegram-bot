package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import util.BotConfigUtil;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
       return BotConfigUtil.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return BotConfigUtil.getBotToken();
    }
}
