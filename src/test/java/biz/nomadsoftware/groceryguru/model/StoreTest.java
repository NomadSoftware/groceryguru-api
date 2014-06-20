package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.joda.time.DateTime;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StoreTest {

	private static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);
	private static final DateTime dt = DateTime.parse("1972-02-07T12:34:56.789Z");

	@Test
	public void test_serialize() throws Exception {
		Store s = new Store(1L);
		s.setAccountId(2L);
		s.setOrderSequence(3);
		s.setCreated(dt);
		s.setUpdated(dt);
		s.setVersion(4);
		String json = mapper.writeValueAsString(s);
		assertThat(json, is(fixture("fixtures/store.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Store s = mapper.readValue(fixture("fixtures/store.json"), Store.class);
		assertThat(s.getId(), is(1L));
		assertThat(s.getAccountId(), is(2L));
		assertThat(s.getOrderSequence(), is(3));
		assertThat(s.getCreated().getMillis(), is(dt.getMillis()));
		assertThat(s.getUpdated().getMillis(), is(dt.getMillis()));
		assertThat(s.getVersion(), is(4));
	}

}
