package tacos.data;

import java.sql.Types;
import java.util.Date;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

import tacos.Ingredient;
import tacos.Taco;

public class JdbcTacoRepository implements TacoRepository {

	@Override
	public Taco save(Taco design) {
		long tacoId = saveTacoInfo(design);
		for (Ingredient ingredient : design.getIngredients()) {
			saveIngredientToTaco(tacoId, ingredient);
		}
		return design.setId(tacoId);
	}
	
	private long saveTacoInfo(Taco design) {
		design.setCreatedAt(new Date());
		PreparedStatementCreator psc = 
				new PreparedStatementCreatorFactory("insert into "
						+ "Taco (name, createdAt) values (?,?)", Types.VARCHAR, Types.TIMESTAMP)
				.newPreparedStatementCreator()
	}

}
