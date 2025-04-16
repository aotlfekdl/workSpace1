package n.genaric.ex1;

public class Farm {
	private String kind;

	public Farm() {
		super();
	}

	public Farm(String kind) {
		super();
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Farm [kind=" + kind + "]";
	}

	

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Farm) {
			Farm f= (Farm)obj;
			if(this.kind.equals(f.getKind())) {
				return true;
			}
			
		}
		return false;
	}

	
}
