package xmlTest;

import java.util.HashSet;
import java.util.Set;

public class Mapping {
	private String name;
	private Set<String> pattern;
	
	public Mapping() {
		pattern=new HashSet<String>();
	}
	public void addpattern(String str) {
		pattern.add(str);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getPattern() {
		return pattern;
	}
	public void setPattern(Set<String> pattern) {
		this.pattern = pattern;
	}
	
	
}
