package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AisleTest {

	private static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);

	@Test
	public void test_serialize() throws Exception {
		Aisle a = new Aisle(1L);
		// TODO
		String json = mapper.writeValueAsString(a);
		assertThat(json, is(fixture("fixtures/aisle.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Aisle a = mapper.readValue(fixture("fixtures/aisle.json"), Aisle.class);
		assertThat(a.getId(), is(1L));
		// TODO
	}

}
