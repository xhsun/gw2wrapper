package me.xhsun.guildwars2wrapper.request;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;

@FunctionalInterface
interface RequestAction<T> {
	void accept(T t) throws GuildWars2Exception;
}
