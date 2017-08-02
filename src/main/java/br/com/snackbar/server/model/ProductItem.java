package br.com.snackbar.server.model;

public class ProductItem {

	private Ingredient ingredient;

	private Integer quantity;

	public ProductItem() {

	}

	public ProductItem(final Ingredient ingredient, final Integer quantity) {
		super();
		this.ingredient = ingredient;
		this.quantity = quantity;
	}

	public Ingredient getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(final Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.ingredient == null ? 0 : this.ingredient.hashCode());
		result = prime * result + (this.quantity == null ? 0 : this.quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		ProductItem other = (ProductItem) obj;
		if (this.ingredient == null) {
			if (other.ingredient != null) {
				return false;
			}
		} else if (!this.ingredient.equals(other.ingredient)) {
			return false;
		}
		if (this.quantity == null) {
			if (other.quantity != null) {
				return false;
			}
		} else if (!this.quantity.equals(other.quantity)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProductItem [ingredient=" + this.ingredient + ", quantity=" + this.quantity + "]";
	}

}
