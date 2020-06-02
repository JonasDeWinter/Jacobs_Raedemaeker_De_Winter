package Model;

public class CodeerFactory {
    public static CodeerStrategy createCodeerStrategy(String codeerTaal){
        CodeerEnum codeerEnum = CodeerEnum.valueOf(codeerTaal);
        String klassenaam = codeerEnum.getKlasseNaam();
        CodeerStrategy codeerStrategy = null;

    try{
        Class dbClass = Class.forName(klassenaam);
        Object object = dbClass.newInstance();
        codeerStrategy = (CodeerStrategy) object;
    }catch (Exception e){}
    return codeerStrategy;
    }
}
