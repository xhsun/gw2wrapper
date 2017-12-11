package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.error.ErrorCode;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * For more Info on GW2 API Version 2 go <a href="https://wiki.guildwars2.com/wiki/API:2">here</a><br/>
 * Guild Wars 2 API Wrapper uses {@link Retrofit} to connect to Guild wars 2 API server<br/>
 * This class provides two ways user can get and process data from the server:<br/>
 * &#32;1) use methods provided by {@link SynchronousRequest} to get data synchronously<br/>
 * &#32;2) use methods provided by {@link AsynchronousRequest} to get/process data asynchronously
 *
 * If you want to set language for APIs that are locale aware, use {@link GuildWars2#setLanguage(LanguageSelect)}<br/>
 * If you do not call {@link GuildWars2#setLanguage(LanguageSelect)}, default language will be English
 *
 * @author xhsun
 * @since 2017-02-06
 */

public final class GuildWars2 {
	public enum LanguageSelect {
		English("en"), German("de"), Spanish("es"), French("fr"), Chinese("zh");
		private final String lang;

		LanguageSelect(String lang) {
			this.lang = lang;
		}

		public String getValue() {
			return lang;
		}
	}
	private static final String API = "https://api.guildwars2.com";
	private static volatile GuildWars2 instance = null;
	static volatile LanguageSelect lang = LanguageSelect.English;
	private volatile GuildWars2API gw2API;
	private volatile SynchronousRequest synchronous;
	private volatile AsynchronousRequest asynchronous;

	/**
	 * You need to call {@link #setInstance(Cache)} to create instance with custom caching<br/>
	 * If you don't call {@link #setInstance(Cache)}, this method will create a new instance without custom caching
	 *
	 * @return {@link GuildWars2}
	 */
	public static GuildWars2 getInstance() {
		if (instance == null) instance = new GuildWars2();
		return instance;
	}
	
	/**
	 * You need to call {@link #setInstance(Cache)} to create instance with custom
	 * caching<br/>
	 * This method will create instance with your custom Client
	 * @param client
	 *            your custom client
	 */
	public static void setInstance(OkHttpClient client) throws GuildWars2Exception {
		if (instance != null)
			throw new GuildWars2Exception(ErrorCode.Other, "Instance already initialized");
		instance = new GuildWars2(client);
	}

	/**
	 * Use this to initialize instance with custom cache
	 *
	 * @param cache {@link Cache}
	 * @throws GuildWars2Exception instance already exist
	 */
	public static void setInstance(Cache cache) throws GuildWars2Exception {
		if (instance != null)
			throw new GuildWars2Exception(ErrorCode.Other, "Instance already initialized");
		instance = new GuildWars2(cache);
	}

	/**
	 * Set language for APIs that are locale aware <br/>
	 * Possible Value: english (default), german, spanish, french, chinese
	 *
	 * @param lang selected language
	 */
	public static void setLanguage(LanguageSelect lang) {
		if (lang == null) GuildWars2.lang = LanguageSelect.English;
		else GuildWars2.lang = lang;
	}

	public static LanguageSelect getLanguage() {
		return lang;
	}

	//constructor
	private GuildWars2() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(API)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		gw2API = retrofit.create(GuildWars2API.class);
	}
	
	private GuildWars2(OkHttpClient client) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(API).client(client)
				.addConverterFactory(GsonConverterFactory.create()).build();
		gw2API = retrofit.create(GuildWars2API.class);
	}

	private GuildWars2(Cache cache) {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(API)
				.client(new OkHttpClient.Builder().cache(cache).build())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		gw2API = retrofit.create(GuildWars2API.class);
	}

	public SynchronousRequest getSynchronous() {
		if (synchronous == null) synchronous = new SynchronousRequest(gw2API);
		return synchronous;
	}

	public AsynchronousRequest getAsynchronous() {
		if (asynchronous == null) asynchronous = new AsynchronousRequest(gw2API);
		return asynchronous;
	}
}
