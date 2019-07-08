package tacos.data;

import tacos.Ingredient;
import tacos.Taco;

public class JdbcTacoRepository implements TacoRepository {

	@Override
	public Taco save(Taco design) {
		long tacoId = saveTacoInfo(design);
		for (Ingredient ingredient : design.getIngredients()) {
			saveIngredientToTaco(tacoId, ingredient);
		}
		return null;
	}

}
