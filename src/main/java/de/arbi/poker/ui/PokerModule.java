package de.arbi.poker.ui;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import de.arbi.poker.PokerService;
import de.arbi.poker.game.Game;
import de.arbi.poker.game.GameScope;
import de.arbi.poker.game.GameScoped;
import net.engio.mbassy.bus.MBassador;


public class PokerModule extends AbstractModule {

    private volatile MBassador bus;

    public PokerModule(MBassador bus) {
        this.bus = bus;
    }

    @Override
    protected void configure() {
        GameScope gameScope = new GameScope();
        bindScope(GameScoped.class, gameScope);
        bind(GameScope.class).toInstance(gameScope);
        bind(Game.class);

        bind(MBassador.class).toInstance(bus);
        bind(PokerService.class).in(Singleton.class);
    }
}
