package me.xhsun.guildwars2wrapper.model.account;

import me.xhsun.guildwars2wrapper.model.util.Inventory;

/**
 * For more info on Bank API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">here</a><br/>
 * Bank item model class<br/>
 * Note: if slot is empty, API will return null
 * TODO methods that use this class will directly reference {@link Inventory} in v1.0.0 (aka soon(TM))
 * @author xhsun
 * @see me.xhsun.guildwars2wrapper.model.Item item info
 * @see me.xhsun.guildwars2wrapper.model.Skin skin info
 * @since 2017-02-07
 */

public class Bank extends Inventory {
}
