package xhsun.gw2api.guildwars2.model;

import java.util.List;

/**
 * For more info on TokenInfo API go <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
 * Token info model class
 * @author xhsun
 * @since 2017-02-07
 */

public class TokenInfo {
	private String id;
	private String name;
	private String[] permissions;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String[] getPermissions() {
		return permissions;
	}

	@Override
	public String toString(){
		String result="ID: "+id+" Name: "+name+" Permissions: ";
		if (permissions!=null) for (String permission : permissions) result += permission + " ";
		return result;
	}
}
