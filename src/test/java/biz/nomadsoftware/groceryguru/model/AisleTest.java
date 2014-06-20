package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.joda.time.DateTime;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AisleTest {

	private static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);
	private static final DateTime dt = DateTime.parse("1972-02-07T12:34:56.789Z");

	@Test
	public void test_serialize() throws Exception {
		Aisle a = new Aisle(1L);
		a.setStoreId(2L);
		a.setOrderSequence(3);
		a.setCreated(dt);
		a.setUpdated(dt);
		a.setVersion(4);
		String json = mapper.writeValueAsString(a);
		assertThat(json, is(fixture("fixtures/aisle.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Aisle a = mapper.readValue(fixture("fixtures/aisle.json"), Aisle.class);
		assertThat(a.getId(), is(1L));
		assertThat(a.getStoreId(), is(2L));
		assertThat(a.getOrderSequence(), is(3));
		assertThat(a.getCreated().getMillis(), is(dt.getMillis()));
		assertThat(a.getUpdated().getMillis(), is(dt.getMillis()));
		assertThat(a.getVersion(), is(4));
	}

}
