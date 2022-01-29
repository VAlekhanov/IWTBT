package io.alekhanov.demo;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot  extends  TelegramLongPollingBot{
    public static void startBot(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(new ChannelHandlers());
//            telegramBotsApi.registerBot(new DirectionsHandlers());
//            telegramBotsApi.registerBot(new RaeHandlers());
//            telegramBotsApi.registerBot(new WeatherHandlers());
//            telegramBotsApi.registerBot(new TransifexHandlers());
//            telegramBotsApi.registerBot(new FilesHandlers());
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "IWTBTbot";
    }

    @Override
    public String getBotToken() {
        return "5022644779:AAHFV4aWTIUEyIgPWJ9vfaG1qMTqzfnaOjU";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
