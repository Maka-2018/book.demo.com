package com.book.entity;

public class Author {

	private Sex TypeSex;
	private String FullName;
	
	public Author(String strFullName, Sex strSex)
	{
		this.FullName = strFullName;
		TypeSex = strSex;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		this.FullName = fullName;
	}
	public Sex getSex() {
		return TypeSex;
	}
	public void setSex(Sex sex) {
		this.TypeSex = sex;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FullName == null) ? 0 : FullName.hashCode());
		result = prime * result + ((TypeSex == null) ? 0 : TypeSex.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (FullName == null) {
			if (other.FullName != null)
				return false;
		} else if (!FullName.equals(other.FullName))
			return false;
		if (TypeSex != other.TypeSex)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return FullName+ ", " +TypeSex;
	}

}
