package featurer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class QueryFeaturer extends Featurer {

	protected HashMap<HashMap<String, Integer>, ArrayList<Double>> featuresForQuery;
	
	public QueryFeaturer() {
		super();
		this.featuresForQuery = new HashMap<HashMap<String, Integer>, ArrayList<Double>>();
	}

	public abstract void buildFeatures(HashMap<String, Integer> query) throws ClassNotFoundException, IOException;
	
	@Override
	public ArrayList<Double> getFeatures(String idDoc, HashMap<String, Integer> query) throws ClassNotFoundException, IOException{
		if (! this.featuresForQuery.containsKey(query)){
			this.buildFeatures(query);
		}
		return this.featuresForQuery.get(query);
	}
}
