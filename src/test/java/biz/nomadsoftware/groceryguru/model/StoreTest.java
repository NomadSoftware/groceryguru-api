package biz.nomadsoftware.groceryguru.model;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StoreTest {

	private static final ObjectMapper mapper = Jackson.newObjectMapper().disable(WRITE_DATES_AS_TIMESTAMPS);

	@Test
	public void test_serialize() throws Exception {
		Store s = new Store(1L);
		// TODO
		String json = mapper.writeValueAsString(s);
		assertThat(json, is(fixture("fixtures/store.json")));
	}

	@Test
	public void test_deserialize() throws Exception {
		Store s = mapper.readValue(fixture("fixtures/store.json"), Store.class);
		assertThat(s.getId(), is(1L));
		// TODO
	}

}
