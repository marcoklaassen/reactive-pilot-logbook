package click.klaassen.logbook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LegDto {
  private Long id;
  private String flightFrom;
  private String flightTo;
}
