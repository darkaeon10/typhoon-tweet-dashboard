package tweet;

import java.util.ArrayList;
import java.util.List;

import database.ClassifiedTweetsDataManager;

public enum Category {
    RELIEF("reliefph"), 
    RESCUE("rescueph"), 
    SAFENOW("safenow"), 
    FLOOD("floodph"), 
    TRACING("tracingph"), 
    YOLANDA("yolandaph");
    
    private static List<String> values;
    
    static {
        values = new ArrayList<>();
        for (Category category : Category.class.getEnumConstants()) {
            values.add(category.name);
        }    
    }
    
    public static Category getCategory(String categoryName){
    	 for (Category category : Category.class.getEnumConstants()) {
    		 if(category.name.equals(categoryName))
    			 return category;
         }    
    	 return null;
    }
    
    public static List<String> getValues() {
        return values;
    }
    
    static Category extract(String text) {
        Category result = null;
        text = text.toLowerCase();
        
        if (text.contains("#reliefph")) {
            result = RELIEF;
        }
        else if (text.contains("#rescueph")) {
            result = RESCUE;
        }
        else if (text.contains("#safenow")) {
            result = SAFENOW;
        }
        else if (text.contains("#floodph")) {
            result = FLOOD;
        }
        else if (text.contains("#tracingph")) {
            result = TRACING;
        }
        else if (text.contains("#yolandaph")) {
            result = YOLANDA;
        }
        
        return result;
    }
    
    static String cleanUp(String text) {
        String result = text.toLowerCase();
        
        result = result.replace("#reliefph", "");
        result = result.replace("#rescueph", "");
        result = result.replace("#safenow", "");
        result = result.replace("#floodph", "");
        result = result.replace("#tracingph", "");
        result = result.replace("#yolandaph", "");
        
        return result;
    }
    
    static int countCategories(String text) {
        int result = 0;
        text = text.toLowerCase();
        if (text.contains("#reliefph")) {
            result++;
        }
        if (text.contains("#rescueph")) {
            result++;
        }
        if (text.contains("#safenow")) {
            result++;
        }
        if (text.contains("#tracingph")) {
            result++;
        }
        if (text.contains("#yolandaph")) {
            result++;
        }
        
        return result;
    }
    
    String name;
    Category(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public String getDescription(){
    	if(this.equals(RELIEF))
    		return "Resource Coordination";
    	if(this.equals(RESCUE))
    		return "Urgent Rescue Needed";
    	if(this.equals(SAFENOW))
    		return "Urgent Rescue Resolution";
    	if(this.equals(FLOOD))
    		return "Damage Reporting";
    	if(this.equals(TRACING))
    		return "Missing People";
    	if(this.equals(YOLANDA))
    		return "Media Storm Coverage";
    	return "";
    }

}
