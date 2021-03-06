package de.arbi.poker.com;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import de.arbi.poker.handlers.JoinGameHandler;
import de.arbi.poker.handlers.JoinedGameHandler;
import de.arbi.poker.handlers.QuitGameHandler;
import de.arbi.poker.handlers.RootHandler;
import ratpack.handling.HandlerDecorator;

public class PokerComModule extends AbstractModule {
    protected void configure() {
        bind(JoinGameHandler.class);
        bind(JoinedGameHandler.class);
        bind(QuitGameHandler.class);
        bind(RootHandler.class);
        Multibinder.newSetBinder(binder(), HandlerDecorator.class).addBinding().toInstance(HandlerDecorator.prepend(new de.arbi.poker.LoggingHandler()));
    }
}
