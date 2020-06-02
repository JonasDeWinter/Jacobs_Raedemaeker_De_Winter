package Service;

import Model.CodeerContext;
import Model.CodeerStrategy;

public class CodeerFacade {
    private CodeerStrategy codeerStrategy;
    private  CodeerContext context;

    public CodeerFacade(CodeerContext context, CodeerStrategy codeerStrategy){
        this.codeerStrategy = codeerStrategy;
        this.context = context;
    }

    public void vertaal( String code){
        if (code.equalsIgnoreCase("e")){
            context.encode(context.getTekst());
            System.out.println(context.encode(context.getTekst()));
        }else if (code.equalsIgnoreCase("d")){
            context.decode(context.getTekst());

            System.out.println(context.decode(context.getTekst()));
        }
    }
}
