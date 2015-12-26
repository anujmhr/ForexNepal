 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.allbanks;

import java.util.HashMap;

/**
 *
 * @author Anuz
 */
public class ScrapCommandFactory {
     private static final HashMap<String,ScrapCommand> commands=initCommands();

    public ScrapCommandFactory() {
    }
    
    
    
    private static HashMap<String,ScrapCommand> initCommands(){
        HashMap<String,ScrapCommand> c=new HashMap();
        //c.put("1", new RastraBank());
        c.put("1", new HimalayanBank());
        c.put("2", new NabilBank());
        c.put("3",new NepalInvestmentBank());
        //c.put("5",new NepalSBIBank());           
        c.put("4",new NepalBangladeshBank());  
        
        c.put("5",new MachhapuchchhreBank() );
         c.put("6",new EverestBank());  
         c.put("7",new SiddharthaBank());
        return c;
    }
    
    
    
    public static ScrapCommand get(String param){
        if(commands.containsKey(param)){
            return commands.get(param);
        }
        return null;
    }
    
    
}
