//
// Hyperverse - A minecraft world management plugin
// Copyright © 2020 Alexander Söderberg (sauilitired@gmail.com)
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
//

package com.intellectualsites.hyperverse;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.Stage;
import com.intellectualsites.hyperverse.listeners.WorldListener;
import com.intellectualsites.hyperverse.modules.HyperverseModule;
import org.bukkit.plugin.java.JavaPlugin;

@Singleton
public final class Hyperverse extends JavaPlugin {

    @Override public void onEnable() {
        final Injector injector = Guice.createInjector(Stage.PRODUCTION,
            new HyperverseModule());
        // Register event listeners
        this.getServer().getPluginManager()
            .registerEvents(injector.getInstance(WorldListener.class), this);
    }

    @Override public void onDisable() {
        // Plugin shutdown logic
    }
}
