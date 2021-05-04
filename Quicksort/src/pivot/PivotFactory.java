package pivot;

public class PivotFactory {
	
    public static Pivot create(String type){
    	Pivot actionObject;
        String nomeClasse = "pivot.Pivot"+ type;
        Class classe;
        Object objeto;
        try{
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        }catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex){
            return null;
        }
        if (!(objeto instanceof Pivot)) return null;
        actionObject = (Pivot) objeto;
                
        return actionObject;        
    }
}
