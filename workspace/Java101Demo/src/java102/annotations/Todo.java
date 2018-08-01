package java102.annotations;

//@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Todo {
	public enum Items {PHONES, SCREENS}
	String value();
	Items item() default Items.PHONES;

}
