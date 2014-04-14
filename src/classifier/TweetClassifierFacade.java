package classifier;

import java.util.ArrayList;

import database.ClassifiedTweetsDataManager;
import tweet.Category;
import twitter4j.Status;

public class TweetClassifierFacade {

	private SMOClassifier classifier;
	private ArrayList<SMOClassifier> binaryClassifiers;
	
	public TweetClassifierFacade(){
		binaryClassifiers = new ArrayList<SMOClassifier>();
		for(Category category: Category.values())
			binaryClassifiers.add(new SMOClassifier(category.getName()));
	}
	
	public Category classify(Status status){
        for(SMOClassifier classifier: binaryClassifiers){
        	Category category = classifier.classify(status);
            if(category!= null){
            	return category;
            }
        }
		return null;
	}
	
	public Category addToDBIfRelevant(Status status){
    	Category category = classify(status);
    	if(category != null){
    		ClassifiedTweetsDataManager.getInstance().insertTweet(status, category);
    		return category;
    	}
    	return null;
	}
}
