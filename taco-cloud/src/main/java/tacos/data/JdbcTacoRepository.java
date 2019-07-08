package tacos.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import tacos.Taco;

public class JdbcTacoRepository implements TacoRepository {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Taco save(Taco design) {
		long tacoId = saveTacoInfo(design);
		for (String ingredient : design.getIngredients()) {
			saveIngredientToTaco(tacoId, ingredient);
		}
		return design.setId(tacoId);
	}
	
	private long saveTacoInfo(Taco taco) {
		taco.setCreatedAt(new Date());
		PreparedStatementCreator psc = new PreparedStatementCreatorFactory("insert into Taco (name, createdAt)"
				+ " values (?, ?)", Types.VARCHAR, Types.TIMESTAMP)
				.newPreparedStatementCreator(Arrays.asList(taco.getName(), new Timestamp(taco.getCreatedAt().getTime())));
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, keyHolder);
		return keyHolder.getKey().longValue();
		
	}
	
	private void saveIngredientToTaco(long tacoId, String ingredient) {
		jdbcTemplate.update("insert into Taco_Ingredients (taco, ingredient)"
				+ " values (?, ?)", tacoId, ingredient);
	}

}
