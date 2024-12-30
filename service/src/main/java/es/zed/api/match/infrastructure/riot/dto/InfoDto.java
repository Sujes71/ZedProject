package es.zed.api.match.infrastructure.riot.dto;
import es.zed.api.shared.infrastructure.riot.dto.Dto;
import java.util.List;

public class InfoDto extends Dto {
  private String endOfGameResult;
  private long gameCreation;
  private long gameDuration;
  private long gameEndTimestamp;
  private long gameId;
  private String gameMode;
  private String gameName;
  private long gameStartTimestamp;
  private String gameType;
  private String gameVersion;
  private int mapId;
  private List<ParticipantDto> participants;
  private String platformId;
  private int queueId;
  private List<TeamDto> teams;
  private String tournamentCode;
}
