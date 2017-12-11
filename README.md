# Guild Wars 2 API Wrapper for Android and Java
[ ![Download](https://api.bintray.com/packages/xhsun/maven/gw2wrapper/images/download.svg) ](https://bintray.com/xhsun/maven/gw2wrapper/_latestVersion)

This is a library for accessing the [Guild Wars 2 API](https://wiki.guildwars2.com/wiki/API:Main). As of right now, all Guild Wars 2 API version 2 endpoints are available and access to Guild Wars 2 API version 1 is on the table.

## How To Use

*Note: when using this library in Android application make sure to require internet permission* 

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

First of all, you need to get GuildWars2 object by calling:

```java
GuildWars2.getInstance();
```

If you would like to get the information in different language (only for APIs which are locale aware), 
use ```GuildWars2.setLanguage(LanguageSelect)```. For instance, to get information in Spanish:

```java
GuildWars2.setLanguage(LanguageSelect.Spanish);
```

<sub>*Note: Possible languages are English (Default), German, Spanish, French, and Chinese. If you do not set 
a language, it will default to English.*</sub>

#### API Wrapper Methods

Use methods in ```SynchronousRequest``` class to get the content synchronously, which can be accessed by calling ```getSynchronous()``` function in ```GuildWars2``` class.

For instance, to get content of item [12452 and 28445](https://api.guildwars2.com/v2/items?ids=12452,28445) synchronously:

```java
GuildWars2 api = GuildWars2.getInstance();
int[] ids = new int[]{12452, 28445};
List<Item> result = api.getSynchronous().getItemInfo(ids);
//more amazing codes
```

Use methods in ```AsynchronousRequest``` class to process you the content asynchronously, which can be accessed by calling ```getAsynchronous()``` function in ```GuildWars2``` class.

For instance, to process content of item [12452 and 28445](https://api.guildwars2.com/v2/items?ids=12452,28445) asynchronously:

```java
GuildWars2 api = GuildWars2.getInstance();
int[] ids = new int[]{12452, 28445};
api.getAsynchronous().getItemInfo(ids, new Callback<List<Item>>() {
  @Override
  public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
    //more amazing codes
  }
	
  @Override
  public void onFailure(Call<List<Item>> call, Throwable t) {
    //handle failure
  }
});
```

#### Content Model Classes

Each content model class follows the exact same format presented by [official wiki](https://wiki.guildwars2.com/wiki/API:2). Thus a good way to know what to expect from a model class is to go to the API wiki page and see what is in the 
response for that endpoint.

For example, the response for [/v2/tokeninfo](https://wiki.guildwars2.com/wiki/API:2/tokeninfo):

> id (string) - The API key that was requested.
>
> name (string) - The name given to the API key by the account owner. <strong>Warning</strong>: The value of this field is not escaped and may contain valid HTML, JavaScript, other code. Handle with care.
>
> permissions (array) - Array of strings describing which permissions the API key has. The array can contain any of:
> + account - Grants access to the /v2/account endpoint (This permission is required for all API keys).
> + builds - Grants access to view each character's equipped specializations and gear.
> + characters - Grants access to the /v2/characters endpoint.
> + guilds - Grants access to guild info under the /v2/guild/:id/ sub-endpoints.
> + inventories - Grants access to inventories in the /v2/characters, /v2/account/bank, and /v2/account/materials endpoints.
> + progression - Grants access to achievements, dungeon unlock status, mastery point assignments, and general PvE progress.
> + pvp - Grants access to the /v2/pvp sub-endpoints. (i.e. /v2/pvp/games, /v2/pvp/stats)
> + tradingpost - Grants access to the /v2/commerce/transactions endpoint.
> + unlocks - Grants access to the /v2/account/skins and /v2/account/dyes endpoints.
> + wallet - Grants access to the /v2/account/wallet endpoint.


The format for TokenInfo class is:

```java
public class TokenInfo {
  private String id;
  private String name;
  private String[] permissions;
  //getters
}
```

<sub>*Note: If parts of response of an endpoint is not documented on the wiki, I probably will missed it in my model class. 
So if you see anything I missed, please don't hesitate to create an issue to let me know.*</sub>

## Available Endpoints

All Guild Wars 2 API [Version 2](https://wiki.guildwars2.com/wiki/API:2) endpoints are available and I will continue to support
new endpoints as they come out.

#### Guild Wars 2 API Version 1

+ /v1/event_detail.json

+ /v1/map_names.json

+ /v1/world_names.json

+ /v1/wvw/matches.json

+ /v1/wvw/objective_names.json

<sub>*Note: above endpoints are the only API:1 endpoints I will support. I do not plan on support other
API:1 endpoints because there probably is an API:2 endpoint that does the same thing or the endpoint is
currently disabled.*</sub>

## Extra Utility Methods

```GuildWars2Utility``` class contains a few utility methods, such as extract id from chat link, get root id, and parse coins, 
which should hopefully help you out. 

For example, ```GuildWars2Utility.parseCoins(long)``` will parse the given coin value into gold, sliver, and copper:
 
 ```java
long coins = 199;
long[] result = GuildWars2Utility.parseCoins(coins);
//result will be [0, 1, 99], which means 0 gold, 1 sliver and 99 coppers
```

## Download

Download latest [release](https://github.com/xhsun/gw2wrapper/releases) in Maven:

```xml
<dependency>
    <groupId>me.xhsun.gw2wrapper</groupId>
    <artifactId>gw2wrapper</artifactId>
    <version>1.3.2</version>
</dependency>
```

Or Gradle:

```groovy
dependencies {
  ...
  compile 'me.xhsun.gw2wrapper:gw2wrapper:1.3.2'
  ...
}
```

## Contributing

#### Issues

If you find anything that is not working as it should be, please don't hesitate to open an issue in the issue tracker.

<sub>When reporting an issue, it will help me a lot if you include what you've done that lead to the issue.</sub>

Or, if you feel like it, you can always fork and try to fix it yourself.

##### Somethings to know when contributing code

- Try to adhere to the current code style of this library

- Try to run some testes to make sure you didn't accidentally break anything before creating a pull request

- It would help me to review your code if you tell me what you are trying to do in the pull request

- I really do appreciate your effort to help me to improve this library

#### Credit
 
 + [Retrofit](https://github.com/square/retrofit) for HTTP client
 
 + [Base64](https://github.com/karlroberts/base64) for Base 64 decoder using core Java
 
 ## Troubleshooting
 
 When building your project in Gradle you may encounter `DuplicateFileException` caused by:
 > Duplicate files copied in APK publicsuffixes.gz.
 
 To resolve this issue:
 ```groovy
 packagingOptions {
   ...
   pickFirst 'publicsuffixes.gz'
   ...
 }
 ```
