package es.zed.api.shared.rest;

public class Routing {

  public static final String ACCOUNT_PATH = "account";

  public static final String GET_ACCOUNT_BY_RIOT_ID_PATH = "/accounts/by-riot-id/{gameName}/{tagLine}";

  public static final String MATCH_PATH = "match";

  public static final String GET_MATCHES_BY_PUUID = "/matches/by-puuid/{puuid}/ids";
}