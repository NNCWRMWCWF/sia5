// tag::all[]
// tag::allButValidation[]
package tacos;
import java.util.Date;
import java.util.List;

// end::allButValidation[]
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// tag::allButValidation[]
import lombok.Data;

@Data
public class Taco {
	
	private Long id;
	
	private Date createdAt;

  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
// end::allButValidation[]
  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  // tag::allButValidation[]
  private String name;
  // end::allButValidation[]
  @Size(min=1, message="You must choose at least 1 ingredient")
  // tag::allButValidation[]
  private List<String> ingredients;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<String> getIngredients() {
	return ingredients;
}
public void setIngredients(List<String> ingredients) {
	this.ingredients = ingredients;
}
  
  

}
//end::allButValidation[]
//tag::end[]