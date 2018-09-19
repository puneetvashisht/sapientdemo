1. Create a Maven Project
2. Configure Hibernate Libraries
3. Create persistence.xml -> Configure to JPA project
4. Configure persistence-unit in persistence.xml
5. Create a entity -> @Id
6. Create a repo -> EMF, EM 
7. Methods (add, fetch)


Stored Procedures --- 
CREATE OR REPLACE FUNCTION calculate(
    IN x double precision,
    IN y double precision,
    OUT sum double precision)
  RETURNS double precision AS
$BODY$
BEGIN
    sum = x + y;
END;
$BODY$
  LANGUAGE plpgsql
  
  
 @NamedStoredProcedureQuery(
	name = "calculate", 
	procedureName = "calculate", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "x"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "y"), 
		@StoredProcedureParameter(mode = ParameterMode.OUT, type = Double.class, name = "sum")
	}
)

StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("calculate");
query.setParameter("x", 1.23d);
query.setParameter("y", 4.56d);
query.execute();
Double sum = (Double) query.getOutputParameterValue("sum");
