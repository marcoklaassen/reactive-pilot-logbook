package click.klaassen.logbook;

import io.smallrye.mutiny.Uni;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.reactive.mutiny.Mutiny;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/leg")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LegController {

  @Inject Mutiny.Session session;

  @GET
  @Path("/{id}")
  public Uni<Leg> findLegById(@PathParam Long id) {
    return session.find(Leg.class, id);
  }

  @POST
  public Uni<Void> createLeg(LegDto leg) {
    return session
        .persist(Leg.builder().flightFrom(leg.getFlightFrom()).flightTo(leg.getFlightTo()).build())
        .flatMap(x -> session.flush());
  }
}
