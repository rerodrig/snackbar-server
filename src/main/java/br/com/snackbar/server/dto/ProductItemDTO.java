package br.com.snackbar.server.dto;

public class ProductItemDTO {

	private Integer ingredientId;

	private Integer quantity;

	public Integer getIngredientId() {
		return this.ingredientId;
	}

	public void setIngredientId(final Integer ingredientId) {
		this.ingredientId = ingredientId;
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
		result = prime * result + (this.ingredientId == null ? 0 : this.ingredientId.hashCode());
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
		ProductItemDTO other = (ProductItemDTO) obj;
		if (this.ingredientId == null) {
			if (other.ingredientId != null) {
				return false;
			}
		} else if (!this.ingredientId.equals(other.ingredientId)) {
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
		return "ProductComposition [ingredientId=" + this.ingredientId + ", quantity=" + this.quantity + "]";
	}

}
