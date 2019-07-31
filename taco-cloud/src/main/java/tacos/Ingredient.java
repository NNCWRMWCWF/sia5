package tacos;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Ingredient {
	@Id
	public final String id;
	public final String name;
	public final Type type;
	
	
	
	public Ingredient(String id, String name, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	private Ingredient() {
		this.id = null;
		this.name = null;
		this.type = null;
	}

	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}





	public static enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
	
}
