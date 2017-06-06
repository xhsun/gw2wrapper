package me.xhsun.guildwars2wrapper.model.account;

import me.xhsun.guildwars2wrapper.model.util.Storage;

import java.util.List;

/**
 * For more info on Bank API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">here</a><br/>
 * Bank item model class<br/>
 * Note: if slot is empty, API will return null
 *
 * @author xhsun
 * @see me.xhsun.guildwars2wrapper.model.Item item info
 * @see me.xhsun.guildwars2wrapper.model.Skin skin info
 * @since 2017-02-07
 */

public class Bank extends Storage {
	private int skin;
	private List<Integer> upgrades;
	private List<Integer> infusions;

	public int getSkinId() {
		return skin;
	}

	public List<Integer> getUpgradeIds() {
		return upgrades;
	}

	public List<Integer> getInfusionIds() {
		return infusions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Bank bank = (Bank) o;

		return getItemId() == bank.getItemId() &&
				getCount() == bank.getCount() &&
				getCharges() == bank.getCharges() &&
				skin == bank.skin &&
				getBinding() == bank.getBinding() &&
				(getBound_to() != null ? getBound_to().equals(bank.getBound_to()) : bank.getBound_to() == null) &&
				(upgrades != null ? upgrades.equals(bank.upgrades) : bank.upgrades == null) &&
				(infusions != null ? infusions.equals(bank.infusions) : bank.infusions == null);
	}

	@Override
	public int hashCode() {
		int result = getItemId();
		result = 31 * result + getCount();
		result = 31 * result + getCharges();
		result = 31 * result + (getBinding() != null ? getBinding().hashCode() : 0);
		result = 31 * result + (getBound_to() != null ? getBound_to().hashCode() : 0);
		result = 31 * result + skin;
		result = 31 * result + (upgrades != null ? upgrades.hashCode() : 0);
		result = 31 * result + (infusions != null ? infusions.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Bank{" +
				"id=" + getItemId() +
				", count=" + getCount() +
				", charges=" + getCharges() +
				", binding=" + getBinding() +
				", bound_to='" + getBound_to() + '\'' +
				", skin=" + skin +
				", upgrades=" + upgrades +
				", infusions=" + infusions +
				'}';
	}
}
