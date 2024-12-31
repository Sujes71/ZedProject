package es.zed.api.shared.rest;

public class Routing {

  public static final String ACCOUNT_PATH = "account";

  public static final String GET_ACCOUNT_BY_GAME_TAG_PATH = "/accounts/gameTag/{gameName}/{tagLine}";

  public static final String MATCH_PATH = "match";

  public static final String GET_MATCHES_BY_ACCOUNT_ID_PATH = "/matches/accountId/{accountId}";

  public static final String SUMMONER_PATH = "summoner";

  public static final String GET_SUMMONERS_BY_ACCOUNT_ID_PATH = "/summoners/accountId/{accountId}";
}