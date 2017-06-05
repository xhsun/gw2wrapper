package me.xhsun.guildwars2wrapper.model.colors;

import java.util.Arrays;

/**
 * For more info on Colors API go <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
 * <p>
 * Color detail model for {@link Color}
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class ColorDetail {
	private int brightness;
	private double contrast;
	private int hue;
	private double saturation;
	private double lightness;
	private int[] rgb;

	public int getBrightness() {
		return brightness;
	}

	public double getContrast() {
		return contrast;
	}

	public int getHue() {
		return hue;
	}

	public double getSaturation() {
		return saturation;
	}

	public double getLightness() {
		return lightness;
	}

	public int[] getRgb() {
		return rgb;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ColorDetail that = (ColorDetail) o;

		return brightness == that.brightness &&
				Double.compare(that.contrast, contrast) == 0 &&
				hue == that.hue &&
				Double.compare(that.saturation, saturation) == 0 &&
				Double.compare(that.lightness, lightness) == 0 &&
				Arrays.equals(rgb, that.rgb);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = brightness;
		temp = Double.doubleToLongBits(contrast);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + hue;
		temp = Double.doubleToLongBits(saturation);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lightness);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + Arrays.hashCode(rgb);
		return result;
	}

	@Override
	public String toString() {
		return "ColorDetail{" +
				"brightness=" + brightness +
				", contrast=" + contrast +
				", hue=" + hue +
				", saturation=" + saturation +
				", lightness=" + lightness +
				", rgb=" + Arrays.toString(rgb) +
				'}';
	}
}
