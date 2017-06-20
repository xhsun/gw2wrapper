package me.xhsun.guildwars2wrapper.model.pvp;

/**
 * For more info on pvp standings API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/standings">here</a><br/>
 * Model class for pvp standings
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class PvPStanding {
	private String season_id;
	private Standing current, best;

	public String getSeasonId() {
		return season_id;
	}

	public Standing getCurrent() {
		return current;
	}

	public Standing getBest() {
		return best;
	}

	@Override
	public String toString() {
		return "PvPStanding{" +
				"season_id='" + season_id + '\'' +
				", current=" + current +
				", best=" + best +
				'}';
	}

	public class Standing {
		private int total_points, division, tier, points,
				repeats, rating, decay;

		public int getTotal_points() {
			return total_points;
		}

		public int getDivision() {
			return division;
		}

		public int getTier() {
			return tier;
		}

		public int getPoints() {
			return points;
		}

		public int getRepeats() {
			return repeats;
		}

		public int getRating() {
			return rating;
		}

		public int getDecay() {
			return decay;
		}

		@Override
		public String toString() {
			return "Standing{" +
					"total_points=" + total_points +
					", division=" + division +
					", tier=" + tier +
					", points=" + points +
					", repeats=" + repeats +
					", rating=" + rating +
					", decay=" + decay +
					'}';
		}
	}
}
